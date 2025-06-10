package io.omoto.fms.controllers.audience;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.omoto.fms.api.rest.v3.resources._private.AudienceApi;
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


@Service
public class AudienceController {

    @Autowired
    private AudienceService audienceService;
    @Autowired
    private QueueFactory queueFactory;
    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(AudienceController.class.getName());

    public String createAudience(AudienceVO audienceVO, MultipartFile file) throws IOException, JSONException {
        if (file.isEmpty()) {
            throw Empty.supplier(StatusCodeAndMessages.MSG_UPLOADED_FILE_IS_EMPTY, "createAudience", AudienceApi.AUDIENCE_CREATION_CONTEXT).get();
        }
        if (!audienceService.isHeadersAreValid(file)) {
            throw Invalid.supplier(StatusCodeAndMessages.MSG_INVALID_HEADERS, "createAudience", AudienceApi.AUDIENCE_CREATION_CONTEXT).get();
        }

        JSONArray jsonArray = FileUtils.csvToJson(file);
        audienceVO.setContacts(jsonArray.toString());
        String documentId = audienceService.saveAsDocument(objectMapper.convertValue(audienceVO, Audience.class)).getAudienceId();
        addToQueue(documentId);

        return "Success";
    }


    private void addToQueue(String documentId) {
        Queues queueProvider = queueFactory.getQueueProvider(QueueConstants.RABBIT_MQ);
        QueuesVO queuesVO = new QueuesVO();
        queuesVO.setData(documentId);
        queuesVO.setQueueName(QueueConstants.RABBIT_CREATE_AUDIENCE_QUEUE_NAME);
        queueProvider.sendToQueue(queuesVO);
    }

    public Audience.ContactInfo getContacts(AudienceVO audienceVO) {
        Audience audience = new Audience();
        audience.setAudienceId(audienceVO.getAudienceId());
        audience.setAccountId(audienceVO.getAccountId());
        return audienceService.getContacts(audience);
    }


    public Audience.ContactInformation getContactsByAudience(AudienceVO audienceVO) {
        Audience audience = new Audience();
        audience.setAudienceId(audienceVO.getAudienceId());
        audience.setAccountId(audienceVO.getAccountId());
        return audienceService.getContactsByAudience(audience);
    }
}
