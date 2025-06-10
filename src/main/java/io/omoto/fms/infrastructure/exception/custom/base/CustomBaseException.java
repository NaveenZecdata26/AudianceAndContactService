package io.omoto.fms.infrastructure.exception.custom.base;

public class CustomBaseException extends  RuntimeException{


    private final String message;
    private final String method;
    private final String context;

    public CustomBaseException(String message, String method,String context) {
        super(message);
        this.method = method;
        this.context = context;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getMethod() {
        return method;
    }

    public String getContext() {
        return context;
    }


}
