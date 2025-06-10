package io.omoto.fms.infrastructure.exception.base;

import io.omoto.fms.infrastructure.exception.custom.base.CustomBaseException;
import io.omoto.fms.infrastructure.exception.message.ErrorMessage;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static io.omoto.fms.commons.constants.Constants.API_VERSION;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class BaseExceptionHandler {
    private static final ExceptionMapping DEFAULT_ERROR = new ExceptionMapping(
            "SERVER_ERROR",
            "Internal server error",
            INTERNAL_SERVER_ERROR);


    private Logger logger;

    private final Map<Class, ExceptionMapping> exceptionMappings = new HashMap<>();

    public BaseExceptionHandler(final Logger logger) {
        this.logger = logger;
        registerMapping(MissingServletRequestParameterException.class, "MISSING_PARAMETER", "Missing request parameter", BAD_REQUEST);
        registerMapping(MethodArgumentTypeMismatchException.class, "ARGUMENT_TYPE_MISMATCH", "Argument type mismatch", BAD_REQUEST);
        registerMapping(HttpRequestMethodNotSupportedException.class, "METHOD_NOT_SUPPORTED", "HTTP method not supported", METHOD_NOT_ALLOWED);
        registerMapping(ServletRequestBindingException.class, "MISSING_HEADER", "Missing header in request", BAD_REQUEST);
    }

    protected void registerMapping(final Class<?> clazz, final String code, final String message, final HttpStatus status) {
        exceptionMappings.put(clazz, new ExceptionMapping(code, message, status));
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ErrorMessage handleThrowable(final Throwable ex, final HttpServletResponse response) {
        ExceptionMapping mapping = exceptionMappings.getOrDefault(ex.getClass(), DEFAULT_ERROR);
        response.setStatus(mapping.status.value());

        return logAndConstruct(mapping, ex);
    }

    private ErrorMessage logAndConstruct(ExceptionMapping mapping, Throwable t) {
        logger.error("{} ({}): {}", mapping.message, mapping.code, t.getMessage(), t);

        return construct(mapping,t);
    }

    private ErrorMessage construct(ExceptionMapping mapping, Throwable throwable) {
        CustomBaseException customBaseException = (CustomBaseException) throwable;
        return new ErrorMessage(
                mapping.code,
                mapping.message,
                API_VERSION,
                customBaseException.getContext(),
                customBaseException.getMethod(),
                customBaseException.getMessage());
    }

    private static class ExceptionMapping {
        private final String message;
        private final String code;
        private final HttpStatus status;

        ExceptionMapping(final String code, final String message, final HttpStatus status) {
            this.code = code;
            this.message = message;
            this.status = status;
        }
    }
}
