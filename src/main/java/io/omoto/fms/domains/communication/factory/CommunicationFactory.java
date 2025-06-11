package io.omoto.fms.domains.communication.factory;

import io.omoto.fms.commons.constants.CampaignConstants;
import io.omoto.fms.domains.communication.CommunicationService;
import io.omoto.fms.domains.communication.impl.EmailCommunicationServiceImpl;
import io.omoto.fms.domains.communication.impl.SmsCommunicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Venkatesh Gowda on 20/2/18.
 */
@Component
public class CommunicationFactory {

    @Autowired
    private EmailCommunicationServiceImpl emailCommunicationService;

    @Autowired
    private SmsCommunicationServiceImpl smsCommunicationService;

    public CommunicationService provides(String communicationType){
        if (communicationType.equalsIgnoreCase(CampaignConstants.CHANNEL_SMS)) {
            return smsCommunicationService;
        }else if (communicationType.equalsIgnoreCase(CampaignConstants.CHANNEL_MAIL)){
            return emailCommunicationService;
        }
        return null;
    }
}
