package io.omoto.fms.infrastructure.mail.impl;

import io.omoto.fms.domains.communication.Communication;
import io.omoto.fms.infrastructure.adapters.email.Email;
import io.omoto.fms.infrastructure.adapters.email.impl.FlowEmailAdapter;
import io.omoto.fms.infrastructure.mail.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Collections;

import static io.omoto.fms.commons.constants.Constants.FLOW_INTEGRATION_KEY;

@Component
public class Flow implements Mail {

    @Autowired
    FlowEmailAdapter flowEmailAdapter;

    private static final Logger LOGGER = LoggerFactory.getLogger(Flow.class.getName());


    @Override
    public void send(Communication communication) throws MessagingException, MailSendException {
        LOGGER.info("Inside flow sending");


        Email email = new Email();
        email.setTos(new ArrayList<>(Collections.singletonList(communication.getTemplate().getEmail())));
        email.setBody(communication.getTemplate().getTemplateContent());
        email.setToEmail(communication.getTemplate().getEmail());
        email.setSubject(communication.getTemplate().getSubject());
        email.setFromEmail(communication.getTemplate().getFromEmail());
        email.setIntegrationKey(FLOW_INTEGRATION_KEY);
        if(communication.getCampaign() != null) {
            email.setUserId(communication.getCampaign().getUserId());
        }
        flowEmailAdapter.sendEmail(email);

    }
}
