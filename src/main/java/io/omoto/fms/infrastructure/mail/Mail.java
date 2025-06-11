package io.omoto.fms.infrastructure.mail;

import io.omoto.fms.domains.communication.Communication;
import org.springframework.mail.MailSendException;

import javax.mail.MessagingException;

/**
 * Created by Venkatesh Gowda on 11/12/17.
 */
public interface Mail {
    void send(Communication communication) throws MessagingException,MailSendException;
}
