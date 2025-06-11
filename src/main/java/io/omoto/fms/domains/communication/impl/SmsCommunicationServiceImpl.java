package io.omoto.fms.domains.communication.impl;

import io.omoto.fms.domains.communication.Communication;
import io.omoto.fms.domains.communication.CommunicationService;
import org.springframework.stereotype.Component;

/**
 * Created by Venkatesh Gowda on 20/2/18.
 */
@Component
public class SmsCommunicationServiceImpl implements CommunicationService {

    @Override
    public String send(Communication communication) {
        // TODO: 21/2/18 implementation is pending for sms communication sending.
        return null;
    }
}
