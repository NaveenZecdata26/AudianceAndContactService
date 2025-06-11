package io.omoto.fms.controllers.audience;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.omoto.fms.api.rest.v3.resources._private.AudienceApi;
import io.omoto.fms.api.rest.v3.vo.AudienceNewVO;
import io.omoto.fms.api.rest.v3.vo.AudienceVO;
import io.omoto.fms.commons.constants.QueueConstants;
import io.omoto.fms.commons.constants.StatusCodeAndMessages;
import io.omoto.fms.domains.audience.Audience;
import io.omoto.fms.domains.audience.AudienceService;
import io.omoto.fms.infrastructure.exception.custom.Empty;
import io.omoto.fms.infrastructure.exception.custom.Invalid;
import io.omoto.fms.infrastructure.queues.Queues;
import io.omoto.fms.infrastructure.queues.QueuesVO;
import io.omoto.fms.infrastructure.queues.factory.QueueFactory;


import io.omoto.fms.utils.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class AudienceController {


    private static final Logger LOGGER = LoggerFactory.getLogger(AudienceController.class.getName());

    @Autowired
    private AudienceService audienceService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private QueueFactory queueFactory;

    @Autowired
    private Gson gson;

    public String createAudience(AudienceVO audienceVO) {
        String documentId = audienceService.saveAsDocument(objectMapper.convertValue(audienceVO, Audience.class)).getAudienceId();
        addToQueue(documentId);
        return "Success";
    }
    private void addToQueue(String documentId){
        Queues queueProvider = queueFactory.getQueueProvider(QueueConstants.RABBIT_MQ);
        QueuesVO queuesVO = new QueuesVO();
        queuesVO.setData(documentId);
        queuesVO.setQueueName(QueueConstants.RABBIT_CREATE_AUDIENCE_QUEUE_NAME);
        queueProvider.sendToQueue(queuesVO);
    }

    public String createAudience(AudienceVO audienceVO, MultipartFile file) throws IOException, JSONException {
        if (file.isEmpty()) {
            throw Empty.supplier(StatusCodeAndMessages.MSG_UPLOADED_FILE_IS_EMPTY, "createAudience", AudienceApi.AUDIENCE_CREATION_CONTEXT).get();
        }
        if (!audienceService.isHeadersAreValid(file)) {
            throw Invalid.supplier(StatusCodeAndMessages.MSG_INVALID_HEADERS, "createAudience", AudienceApi.AUDIENCE_CREATION_CONTEXT).get();
        }

        JSONArray jsonArray = FileUtils.csvToJson(file);
        audienceVO.setContacts(jsonArray.toString());
        String documentId = audienceService.saveAsDocument(objectMapper.convertValue(audienceVO,Audience.class)).getAudienceId();
        addToQueue(documentId);

        return "Success";
    }

    public List<Audience.Bean> getAllAudience(AudienceVO audienceVO) {
        return audienceService.getAllAudience(objectMapper.convertValue(audienceVO, Audience.class));
    }

    public String saveAudience(AudienceNewVO audienceVO) {
        LOGGER.info("Saving the Audience");
        String documentId = audienceService.saveAsDocument(objectMapper.convertValue(audienceVO,Audience.class)).getAudienceId();
        Queues queueProvider = queueFactory.getQueueProvider(QueueConstants.RABBIT_MQ);
        QueuesVO queuesVO = new QueuesVO();
        queuesVO.setData(documentId);
        queuesVO.setQueueName(QueueConstants.RABBIT_SAVE_AUDIENCE_QUEUE_NAME);

        queueProvider.sendToQueue(queuesVO);
        //audienceService.saveAudience(objectMapper.convertValue(audienceVO, Audience.class));
        return "Success";
    }

    public String save(AudienceNewVO audienceVO) {
        if(audienceVO.getApiKey()==null || audienceVO.getApiKey().isEmpty()){
            return "Invalid api key";
        }
        Audience audience = objectMapper.convertValue(audienceVO,Audience.class);
        Audience savedAudience= audienceService.getAudienceByApiKey(audience);
        audience.setAudienceId(savedAudience.getAudienceId());
        System.out.println("audience new "+ gson.toJson(audience));
        audience.setAutoAudience(true);
        audienceService.saveAudience(audience);//todo need to send via queue
        //sendDataToAudienceQueue(audience.getAudienceId());
        return null ;
    }

    public Audience.UserDefinedFields getUserDefinedFields(long accountId) {
        return audienceService.getUserDefinedFields(accountId);

    }

    public String updateAudience(AudienceVO audienceVO) {
        Audience audience = objectMapper.convertValue(audienceVO,Audience.class);
        audienceService.updateAudience(audience);
        return null;
    }

    public String deleteAudience(AudienceVO audienceVO) {
        Audience audience = objectMapper.convertValue(audienceVO,Audience.class);
        audienceService.deleteAudience(audience);
        return null;
    }











}
