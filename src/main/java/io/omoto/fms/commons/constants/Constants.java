package io.omoto.fms.commons.constants;

public class Constants {

    public static final String SOCKET = "socket";
    public static final String INVITATION_SENT_SUCCESSFULLY = "Invitation sent successfully";
    public static final String PENDING = "PENDING";
    public static final Long ROLE_ID_OWNER = 1L;
    public static final String SUSPENDED = "SUSPENDED";
    public static final String INVITE_EXPIRED = "Invite expired";
    public static final String CAMPAIGN_URL = "campaign_url";
    public static final String DEFAULT_SURVEY_PREVIEW_TITLE = "Default title";
    public static final String DEFAULT_SURVEY_PREVIEW_DESCRIPTION = "Default description";
    public static final String DEFAULT_SURVEY_PREVIEW_CARD_IMAGE = "https://cdn.omoto.io/rocket.gif";
    public static final String PREVIEW_IMAGE_FILE_PATH = "/home/omotoadmin/surveyPreviewImages/";
    public static final String SUBSCRIPTION_CANCELED_NOTIFICATION_MESSAGE = "Your subscription is canceled!";
    public static final String SUBSCRIPTION_DUE_NOTIFICATION_MESSAGE = "Your subscription is due. Please update your payment information.";
    public static final String SUBSCRIPTION_UPDATED_NOTIFICATION_MESSAGE = "Subscription status is updated successfully!";
    public static final String SUBSCRIPTION_PAYMENT_SUCCESSFUL = "Payment successful for a current billing cycle of a subscription.";
    public static final String SUBSCRIPTION_PAYMENT_FAILURE = "Payment failed for a current billing cycle of a subscription. Please update payment information.";
    public static final String SUBSCRIPTION_PAYMENT_ACTION_REQUIRED = "Payment action required for a current billing cycle of a subscription.";
    public static final String PAST_DUE = "past_due";
    public static final String LOGO = "LOGO";
    //public static final String PREVIEW_IMAGE_FILE_PATH = "/home/venki/Documents/Logs/";

    private Constants(){

    }

    public static final String API_VERSION = "V3.0";
    public static final String INACTIVE = "INACTIVE";
    public static final String ACTIVE = "ACTIVE";
    public static final int FREE_TRIAL_DAYS = 14;

    public static final String REGISTRATION_CONTEXT = "Registration";
    public static final String INVITE_USER_CONTEXT = "Invite new user to team";
    public static final String PHONE = "Phone";
    public static final String EMAIL = "Email";
    public static final String FIRST_NAME = "First name";
    public static final String LAST_NAME = "Last name";
    public static final String GENDER = "Gender";
    public static final String REGISTRATION_ID = "Registration ID";
    public static final String EMPTY_STRING = "";

    public static final String CHANNEL_EMAIL = "email";

    public static final String PHONE_FIELD = "phoneNumber";
    public static final String EMAIL_FIELD = "emailID";
    public static final String CONTACT_EMAIL_FIELD = "emailID";
    public static final String FIRST_NAME_FIELD = "firstName";
    public static final String LAST_NAME_FIELD = "lastName";
    public static final String REGISTRATION_ID_FIELD = "registrationId";
    public static final String GENDER_FIELD = "gender";

    public static final String PHONE_DISPLAY_FIELD = "Phone Number";
    public static final String EMAIL_DISPLAY_FIELD = "Email";
    public static final String FIRST_NAME_DISPLAY_FIELD = "First Name";
    public static final String LAST_NAME_DISPLAY_FIELD = "Last Name";
    public static final String REGISTRATION_ID_DISPLAY_FIELD = "Registration Id";
    public static final String GENDER_DISPLAY_FIELD = "Gender";

    public static final String NOTIFICATION = "notification";
    public static final String NOTIFICATION_TITLE = "Omoto-notification";
    public static final String SURVEY = "survey";


    public static final int USER_DEF_MERGE_TAG_MAX_LIMIT = 10;


/*    public static final String FIRST_QUESTION_IN_EMAIL = "First question in email";
    public static final String FULL_SURVEY_IN_EMAIL = "Full survey in email";*/

    public static final int FIRST_QUESTION_IN_EMAIL = 1;
    public static final int FULL_SURVEY_IN_EMAIL = 2;


    // Role constants
    public static  final long OWNER = 1;
    public static  final long ADMIN = 1;
    public static  final long USER = 1;

    //Survey Questions types
    public static  final String NPS  ="NPS" ;
    public static  final String MULTIPLE_CHOICE  ="Multiple Choice" ;
    public static  final String CHOICE  ="Choice" ;
    public static  final String YES_OR_NO  ="Yes/No" ;
    public static  final String SINGLE_SELECT  ="Single Select" ;
    public static  final String RATING  ="Rating" ;
    public static  final String DROP_DOWN  ="Drop Down" ;
    public static  final String DATE  ="Date" ;
    public static  final String SHORT_TEXT ="Short Text" ;
    public static  final String LONG_TEXT  ="Long Text" ;
    public static  final String LEGAL  ="Legal" ;
    public static  final String STATEMENT  ="Statement" ;
    public static  final String NUMBER  ="Number" ;
    public static  final String FILE_UPLOAD  ="File Upload" ;
    public static  final String WEBSITE  ="Website" ;
    public static  final String QUESTION_GROUP  ="Question Group" ;
    public static  final String MATRIX  ="Matrix" ;


    //Survey Questions types
    public static  final String QUESTION_TYPE_NPS  ="NPS" ;
    public static  final String QUESTION_TYPE_MULTIPLE_CHOICE  ="CHOICE" ;
    public static  final String QUESTION_TYPE_YES_OR_NO  ="YES / NO" ;
    public static  final String QUESTION_TYPE_SINGLE_SELECT  ="SINGLE SELECT" ;
    public static  final String QUESTION_TYPE_RATING  ="RATING" ;
    public static  final String QUESTION_TYPE_DROP_DOWN  ="DROP DOWN" ;
    public static  final String QUESTION_TYPE_DATE  ="DATE" ;
    public static  final String QUESTION_TYPE_SHORT_TEXT ="SHORT TEXT" ;
    public static  final String QUESTION_TYPE_LONG_TEXT  ="LONG TEXT" ;
    public static  final String QUESTION_TYPE_EMAIL  ="EMAIL" ;
    public static  final String QUESTION_TYPE_PHONE  ="PHONE NUMBER";
    public static  final String QUESTION_TYPE_LEGAL  ="LEGAL" ;
    public static  final String QUESTION_TYPE_STATEMENT  ="STATEMENT" ;
    public static  final String QUESTION_TYPE_NUMBER  ="NUMBER" ;
    public static  final String QUESTION_TYPE_FILE_UPLOAD  ="FILE UPLOAD" ;
    public static  final String QUESTION_TYPE_WEBSITE  ="WEBSITE" ;
    public static  final String QUESTION_TYPE_QUESTION_GROUP  ="QUESTION GROUP" ;
    public static  final String QUESTION_TYPE_MATRIX  ="MATRIX" ;

    public static final String WEB_SOCKET_SENDING_URL = "/topic/server-broadcaster";
    public static final String RECEIVING_URL = "/server-receiver";

    public static final String CONTACT_QUALIFYING_INFO_GROUP_ID = "groupId";

    public static final String API_SUCCESS_MESSAGE = "Success";

    public static final String STATUS_FAILED="FAILED";
    public static final String SEND_STATUS_CHANNEL_SUSPENDED="CHANNEL_SUSPENDED";
    public static final String SEND_STATUS_QUOTA_EXHAUSTED="QUOTA_EXHAUSTED";
    public static final String FLOW_INTEGRATION_KEY="4f5c740d-2ab7-4576-b808-27f958bb5863";

    public static final String SHOPIFY = "SHOPIFY";

    public static final String ACCOUNT_TEAM = "ACCOUNT TEAM";
    public static final String INDIVIDUAL_RESPONSE = "INDIVIDUAL RESPONSE";
    public static final String REPORT_SURVEY_LIST = "SURVEY LIST";
    public static final String REPORT_CAMPAIGN_LIST = "CAMPAIGN LIST";

    public static final String NOTIFICATION_TITLE_DAILY ="Daily";
    public static final String NOTIFICATION_TITLE_WEEKLY="Weekly";
    public static final String NOTIFICATION_TITLE_MONTHLY="Monthly";

    public static final String NOTIFICATION_KEY_DAILY ="daily";
    public static final String NOTIFICATION_KEY_WEEKLY="weekly";
    public static final String NOTIFICATION_KEY_MONTHLY="monthly";


    public static final String ACCOUNT_SETTINGS="ACCOUNT SETTINGS";
    public static final String DEFAULT_FEATURES="DEFAULT FEATURES";

    public static final String PASSWORD_RESET_EMAIL="PASSWORD RESET MAIL";
    public static final String PASSWORD_RESET="PASSWORD RESET";


}
