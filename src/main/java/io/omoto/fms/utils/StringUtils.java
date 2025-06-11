package io.omoto.fms.utils;

public class StringUtils {

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static String notNull(String string) {
        return string==null?"":string;
    }
}
