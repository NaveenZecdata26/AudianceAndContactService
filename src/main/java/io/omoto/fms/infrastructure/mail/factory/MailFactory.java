package io.omoto.fms.infrastructure.mail.factory;

import io.omoto.fms.commons.constants.MailConstants;
import io.omoto.fms.infrastructure.mail.Mail;
import io.omoto.fms.infrastructure.mail.impl.Flow;
import io.omoto.fms.infrastructure.mail.impl.GmailServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ashwin Thakre on 8/2/18.
 * This Factory class returns mail service provider(like zoho mail server, gmail mail server)
 *
 */
@Component
public class MailFactory{
    @Autowired
    private GmailServiceProvider gmailServiceProvider;

    @Autowired
    Flow flow;

    public Mail getMailProvider(String provider){
        if (provider.equals(MailConstants.GMAIL_SERVICE_PROVIDER)) {
            return gmailServiceProvider;
        }else if (provider.equals(MailConstants.FLOW_SERVICE_PROVIDER)) {
            return flow;
        } else {
            throw new IllegalArgumentException("mail server not found!");
        }
    }
}
