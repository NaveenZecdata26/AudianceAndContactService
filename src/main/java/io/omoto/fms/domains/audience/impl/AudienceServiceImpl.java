package io.omoto.fms.domains.audience.impl;

import com.google.gson.Gson;
import io.omoto.fms.commons.constants.Constants;
import io.omoto.fms.domains.audience.Audience;
import io.omoto.fms.domains.audience.AudienceService;
import io.omoto.fms.infrastructure.entities.mongo.AudiencesDocument;
import io.omoto.fms.infrastructure.entities.mongo.ContactsDocument;
import io.omoto.fms.infrastructure.entities.mysql.AudienceUserDefinedFields;
import io.omoto.fms.infrastructure.repositories.audience.AudienceRepository;
import io.omoto.fms.utils.CommonUtil;
import io.omoto.fms.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import static io.omoto.fms.commons.constants.Constants.CONTACT_QUALIFYING_INFO_GROUP_ID;
import static io.omoto.fms.commons.constants.Constants.WEB_SOCKET_SENDING_URL;
import static io.omoto.fms.utils.StringUtils.isNumeric;

@Component
public class AudienceServiceImpl implements AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    @Autowired
    private Gson gson;



    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public AudienceServiceImpl(SimpMessagingTemplate template) {
        this.simpMessagingTemplate = template;
    }




    private static final Logger LOGGER = LoggerFactory.getLogger(AudienceServiceImpl.class.getName());

    @Override
    public Audience saveAsDocument(Audience audience) {
        return audienceRepository.saveDocument(audience);
    }

    @Override
    public boolean isHeadersAreValid(MultipartFile file) throws IOException {
        return FileUtils.getHeaders(file).containsAll(getMandatoryHeaders());
    }

    private List<String> getMandatoryHeaders() {
        List<String> mandatoryHeaders = new ArrayList<>();
        mandatoryHeaders.add(Constants.FIRST_NAME);
        mandatoryHeaders.add(Constants.LAST_NAME);
        mandatoryHeaders.add(Constants.EMAIL);
        return mandatoryHeaders;
    }

    @Override
    public List<Audience.Bean> getAllAudience(Audience audience) {
        return audienceRepository.getAllAudienceOfAnAccount(audience);

    }
    @Override
    public Audience getAudienceByApiKey(Audience audience) {
        return audienceRepository.getByApiKey(audience.getApiKey());
    }

    @Override
    public void saveAudience(Audience audience) {
        List<Object> contactInfoAudience = audience.getContacts();
        List<Object> createdFields = audience.getCreatedFields();
        if (createdFields == null) {
            createdFields = new ArrayList<>(1);
        }
        List<Audience.MappedFields> mappedFields = audience.getMappedFields();
        Map<String, String> headers = new HashMap<>(createdFields.size() + mappedFields.size());
        mappedFields.forEach(mappedField -> headers.put(mappedField.getField(), mappedField.getMappedTo()));
        createdFields.forEach(createdField -> headers.put(createdField.toString(), createdField.toString()));

        LOGGER.info("All headers/keys are : {} ", headers);


        List<Map> invalidContacts = new ArrayList<>();
        List<Map> duplicateContacts = new ArrayList<>();
        List<Map> createdContacts = new ArrayList<>();


        String audienceId;
        LOGGER.info("Audience id is : {} ", audience.getAudienceId());
        if (audience.getAudienceId() != null && !audience.getAudienceId().isEmpty()) {
            audienceId = audience.getAudienceId();
        } else {
            audienceId = audienceRepository.save(audience);
        }

        LOGGER.info("Audience id is : {} ", audienceId);

        int size = contactInfoAudience.size();
        if (size == 0) {
            return;
        }


        audienceRepository.saveAudienceMappedFields(createdFields, audience, mappedFields, audienceId);


        float count = 0;
        for (Object contactObject : contactInfoAudience) {
            String contactId = null;
            Map contactInfoMap = (Map) contactObject;

            LOGGER.info("contact info map is : {} ", contactInfoMap);

            try {
                contactId = audienceRepository.saveContactAndUpdateAudience(contactInfoMap, audience.getAccountId(), audience.getUserId(), audienceId);
                LOGGER.debug("Contact id is :{} ", contactId);
            } catch (DataIntegrityViolationException e) {
                LOGGER.info("DataIntegrityViolationException occurred");//todo this exception will never be thrown
                duplicateContacts.add(contactInfoMap);
            }
            String contactGroupIdentifier = CommonUtil.getUUID();
            createdContacts.add(contactInfoMap);
            count = count + 1;

            float percentage = (count / size) * 100;
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            percentage = Float.valueOf(decimalFormat.format(percentage));

            Map map = new WeakHashMap(3);
            map.put("audience", audience.getName());
            map.put("percentage", percentage);
            map.put("noOfContactsCompleted", count);
            map.put("audienceId", audienceId);
            map.put("description", audience.getDescription());
            LOGGER.info("The percentage is : {} ", percentage);
            simpMessagingTemplate.convertAndSend(WEB_SOCKET_SENDING_URL, gson.toJson(map));

        }
    }

        @Override
        public Audience.UserDefinedFields getUserDefinedFields(long accountId) {
            List<AudienceUserDefinedFields> userDefinedFields = audienceRepository.getUserDefinedFields(accountId);
            List<String> userDefinedFieldsList = new ArrayList<>();
            for (AudienceUserDefinedFields userDefinedField : userDefinedFields) {
                userDefinedFieldsList.add(userDefinedField.getFieldName());
            }
            Audience.UserDefinedFields userDefinedFields1 = new Audience.UserDefinedFields();
            userDefinedFields1.setUserDefinedFields(userDefinedFieldsList);
            return userDefinedFields1;
        }

    @Override
    public void updateAudience(Audience audience) {
        audienceRepository.updateNameAndDescription(audience);
    }

    @Override
    public void deleteAudience(Audience audience) {
        if (audience.getAudienceIdList() != null) {
            audienceRepository.deleteAudienceByIdsList(audience.getAudienceIdList());
            return;
        }
        audienceRepository.deleteAudienceById(audience.getAudienceId());
    }



















}
