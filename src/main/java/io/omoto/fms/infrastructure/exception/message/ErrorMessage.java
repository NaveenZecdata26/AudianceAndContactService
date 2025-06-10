package io.omoto.fms.infrastructure.exception.message;

public class ErrorMessage {
        private String code;
        private String message;
        private String apiVersion;
        private String context;
        private String method;
        private String detailedMessage;

        public ErrorMessage(String code, String message, String apiVersion, String context, String method, String detailedMessage) {
            this.code = code;
            this.message = message;
            this.apiVersion = apiVersion;
            this.context = context;
            this.method = method;
            this.detailedMessage = detailedMessage;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public String getApiVersion() {
            return apiVersion;
        }

        public String getContext() {
            return context;
        }

        public String getMethod() {
            return method;
        }

        public String getDetailedMessage() {
            return detailedMessage;
        }
    }

