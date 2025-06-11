package io.omoto.fms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Venkatesh Gowda on 12/1/18.
 * GmailEmailConfig Configure Gmail server.
 *
 */
@Configuration
public class GmailEmailConfig {


    @Bean
    public JavaMailSender gmailMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("mail.smtp.starttls.enable","true");
        hashMap.put("mail.smtp.auth","true");
        hashMap.put("mail.debug","true");
        Properties properties=new Properties();
        properties.putAll(hashMap);

        mailSender.setJavaMailProperties(properties);
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(25);
        mailSender.setUsername("omoto.level1@gmail.com");
        mailSender.setPassword("omoto@2017");

        return mailSender;
    }
}
