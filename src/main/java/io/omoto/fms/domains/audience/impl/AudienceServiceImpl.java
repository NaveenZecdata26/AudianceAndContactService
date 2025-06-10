package io.omoto.fms.domains.audience.impl;

import io.omoto.fms.commons.constants.Constants;
import io.omoto.fms.domains.audience.Audience;
import io.omoto.fms.domains.audience.AudienceService;
import io.omoto.fms.infrastructure.entities.mysql.AudienceUserDefinedFields;
import io.omoto.fms.infrastructure.repositories.audience.AudienceRepository;
import io.omoto.fms.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AudienceServiceImpl implements AudienceService {

    @Autowired
    AudienceRepository audienceRepository;

    @Override
    public boolean isHeadersAreValid(MultipartFile file) throws IOException {
        return FileUtils.getHeaders(file).containsAll(getMandatoryHeaders());
    }

    @Override
    public Audience saveAsDocument(Audience audience) {
        return audienceRepository.saveDocument(audience);
    }


    @Override
    public Audience.ContactInfo getContacts(Audience audience) {
        Audience.ContactInfo contactInfo = audienceRepository.getContactInfo(audience);
        List<AudienceUserDefinedFields> userDefinedFields = audienceRepository.getUserDefinedFields(audience);
        List<Audience.ContactInfo.HeaderDataEntity> headerDataEntityList = new ArrayList<>(userDefinedFields.size());
        userDefinedFields.forEach(audienceUserDefinedFields -> {
            Audience.ContactInfo.HeaderDataEntity headerDataEntity = new Audience.ContactInfo.HeaderDataEntity();
            headerDataEntity.setHeaderName(audienceUserDefinedFields.getFieldDisplayName());
            headerDataEntity.setField(audienceUserDefinedFields.getFieldName());
            headerDataEntityList.add(headerDataEntity);
        });
        contactInfo.setHeaderData(headerDataEntityList);
        return contactInfo;
    }

    @Override
    public Audience.ContactInformation getContactsByAudience(Audience audience) {
        Audience.ContactInformation contactInfo = audienceRepository.getContactInfoByAudience(audience);
        List<AudienceUserDefinedFields> userDefinedFields = audienceRepository.getUserDefinedFields(audience);
        List<Audience.ContactInfo.HeaderDataEntity> headerDataEntityList = new ArrayList<>(userDefinedFields.size());
        userDefinedFields.forEach(audienceUserDefinedFields -> {
            Audience.ContactInfo.HeaderDataEntity headerDataEntity = new Audience.ContactInfo.HeaderDataEntity();
            headerDataEntity.setHeaderName(audienceUserDefinedFields.getFieldDisplayName());
            headerDataEntity.setField(audienceUserDefinedFields.getFieldName());
            headerDataEntityList.add(headerDataEntity);
        });
        contactInfo.setHeaderData(headerDataEntityList);
        return contactInfo;
    }


    private List<String> getMandatoryHeaders() {
        List<String> mandatoryHeaders = new ArrayList<>();
        mandatoryHeaders.add(Constants.FIRST_NAME);
        mandatoryHeaders.add(Constants.LAST_NAME);
        mandatoryHeaders.add(Constants.EMAIL);
        return mandatoryHeaders;
    }


}
