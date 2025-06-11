package io.omoto.fms.infrastructure.exception.custom;

import io.omoto.fms.infrastructure.exception.custom.base.CustomBaseException;

import java.util.function.Supplier;

/**
 * Created by Venkatesh Gowda on 11/1/18.
 */
public class Invalid extends CustomBaseException {

    private Invalid(String message, String method, String context) {
        super(message,method,context);
    }

    public static Supplier<Invalid> supplier(final String param, final String method, String context) {
        return () -> new Invalid(param,method,context);
    }
}