package io.omoto.fms.infrastructure.mail.impl;

import io.omoto.fms.domains.communication.Communication;
import io.omoto.fms.infrastructure.mail.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

/**
 * Created by Venkatesh Gowda on 12/1/18.
 *
 * GmailServiceProvider class provides functionality to send
 * send via gmail server. However it is not responsible to create
 * email template from html file that needs to be sent.
 *
 * Email template creation(i.e. adding replacement data/content) is handled
 * by EmailTemplate implementations.
 *
 */


@Component
public class GmailServiceProvider implements Mail{

    @Autowired
    @Qualifier("gmailMailSender")
    private JavaMailSender mailSender;

    /**
     * send method sends mail.
     * @param communication contains data that is required to send the mail.
     */
    @Override
    public void send(Communication communication) throws MessagingException,MailSendException {
        MimeMessage mimeMessage= mailSender.createMimeMessage();
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        String templateContent = communication.getTemplate().getTemplateContent();

        helper.setText(templateContent, true);
        helper.setFrom(communication.getTemplate().getFromEmail());
        helper.setTo(communication.getTemplate().getEmail());
        helper.setSubject(communication.getTemplate().getSubject());
        mailSender.send(mimeMessage);
    }
}

