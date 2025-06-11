package io.omoto.fms.domains.communication.impl;

import com.sun.mail.smtp.SMTPAddressFailedException;
import io.omoto.fms.commons.constants.MailConstants;
import io.omoto.fms.domains.communication.Communication;
import io.omoto.fms.domains.communication.CommunicationService;
import io.omoto.fms.infrastructure.mail.Mail;
import io.omoto.fms.infrastructure.mail.factory.MailFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import java.util.Map;

/**
 * Created by Venkatesh Gowda on 20/2/18.
 */
@Component
public class EmailCommunicationServiceImpl implements CommunicationService {
    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailCommunicationServiceImpl.class.getName());

    @Autowired
    private MailFactory mailFactory;

    @Override
    public String send(Communication communication) {
        LOGGER.info("Inside EmailCommunicationServiceImpl");
        Mail mail = mailFactory.getMailProvider(MailConstants.FLOW_SERVICE_PROVIDER);
        LOGGER.info("Mail is : {}",mail);
        try {
            mail.send(communication);
            return "Success";
        }catch (MailSendException exception){
            return getErrorMessage(exception.getFailedMessages());
        }
        catch (SMTPAddressFailedException e){
            return e.getLocalizedMessage();
        } catch (SendFailedException e){
            return "Failed";
        } catch (MessagingException e){
            return "Failed";
        }

    }

    private String getErrorMessage(Map<Object, Exception> failedMessages){
        Map.Entry<Object, Exception> next = failedMessages.entrySet().iterator().next();
        Exception value = next.getValue();
        return value.getMessage();
    }
}
