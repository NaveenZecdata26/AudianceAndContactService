package io.omoto.fms.config;

import io.omoto.fms.utils.EncryptUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

@Configuration
public class EncryptionConfig {

    private static final String ENCRYPTION_PASSWORD = "Om0t@V3in2018";

    @Bean
    EncryptUtil encryptUtil() throws Exception {
        DESKeySpec key = new DESKeySpec(ENCRYPTION_PASSWORD.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        return new EncryptUtil(keyFactory.generateSecret(key));
    }
}

