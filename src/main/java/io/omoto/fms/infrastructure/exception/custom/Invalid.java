package io.omoto.fms.infrastructure.exception.custom;

import io.omoto.fms.infrastructure.exception.custom.base.CustomBaseException;

import java.util.function.Supplier;

public class Invalid extends CustomBaseException {
    private Invalid(String message, String method, String context) {
        super(message,method,context);
    }

    public static Supplier<Invalid> supplier(final String param, final String method, String context) {
        return () -> new Invalid(param,method,context);
    }
}
