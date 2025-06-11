package io.omoto.fms.commons.constants;

public class UrlConstants {
    //  public static final String FLOW_BASE_URL =  "http://testv3.omoto.io:8082";
    //  public static final String FLOW_BASE_URL = "http://test.omoto.io:8082";
    public static final String FLOW_BASE_URL = "http://localhost:8082";

    private UrlConstants() {
    }

    //private static final String OMOTO_FRONTEND_ENDPOINT="http://testv3.omoto.io:9001";
    private static final String OMOTO_FRONTEND_ENDPOINT="http://localhost:4200";

    //private static final String REGULAR_SURVEY_ENDPOINT="http://testv3.omoto.io:9002";
    private static final String REGULAR_SURVEY_ENDPOINT="http://localhost:4201";

    //private static final String CHAT_BOT_SURVEY_ENDPOINT="http://testv3.omoto.io:9003";
    private static final String CHAT_BOT_SURVEY_ENDPOINT="http://localhost:4202";

    // public static final String OMOTO_BACKEND_URL="http://testv3.omoto.io:80";
    public static final String OMOTO_BACKEND_URL="http://localhost:8081";
    //public static final String OMOTO_BACKEND_URL="http://test.omoto.io";
    public static final String FRONTEND_ACTIVATION_URL =OMOTO_FRONTEND_ENDPOINT+"/authorize/account-activation";
    public static final String FRONTEND_MAGIC_LINK_SIGN_IN_URL =OMOTO_FRONTEND_ENDPOINT+"/magic-link-sign-in";
    public static final String FRONTEND_PASSWORD_RESET_LINK_URL =OMOTO_FRONTEND_ENDPOINT+"/authorize/reset-password";
    public static final String REGULAR_SURVEY_FEEDBACK_LINK = REGULAR_SURVEY_ENDPOINT+"/feedback/";
    public static final String CHAT_BOT_SURVEY_FEEDBACK_LINK = CHAT_BOT_SURVEY_ENDPOINT+"/feedback/";
}
