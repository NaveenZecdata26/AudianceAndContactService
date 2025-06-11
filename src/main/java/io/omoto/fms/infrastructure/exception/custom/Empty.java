package io.omoto.fms.infrastructure.exception.custom;

import io.omoto.fms.infrastructure.exception.custom.base.CustomBaseException;

import java.util.function.Supplier;

/**
 * Created by Venkatesh Gowda on 11/1/18.
 */
public class Empty extends CustomBaseException {

    private Empty(String message, String method, String context) {
        super(message,method,context);
    }

    public static Supplier<Empty> supplier(final String param, final String method, String context) {
        return () -> new Empty(param,method,context);
    }
}