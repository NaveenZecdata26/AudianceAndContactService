package io.omoto.fms.utils;

import java.util.UUID;

public class CommonUtil {
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    private static final String PHONE_REGEX = "^[0-9]{10}$";
    private static final String NAME_REGEX = "^[\\p{L} .-]*\\'?[\\p{L} .-]*";

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

}
