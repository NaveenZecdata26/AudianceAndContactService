package io.omoto.fms.commons.constants;

/**
 * Created by Venkatesh Gowda on 12/12/17.
 */
public class StatusCodeAndMessages {

    public static final int SUCCESS = 200;
    public static final int BAD_REQUEST = 400;
    public static final int ALREADY_EXISTS = 409;
    public static final String ACCOUNT_CREATED_SUCCESSFULLY = "Account is created successfully";
    public static final String ACTIVATION_EMAIL_SENT_SUCCESSFULLY = "Activation email has been sent successfully";
    public static final String MAGIC_LINK_EMAIL_SENT_SUCCESSFULLY = "Magic link email has been sent successfully";
    public static final String PASSWORD_UPDATED_SUCCESSFULLY = "Password has been updated successfully";
    public static final String RESET_PASSWORD_LINK_EMAIL_SENT_SUCCESSFULLY = "Reset password link email has been sent successfully";
    public static final String RESET_PASSWORD_LINK_EMAIL = "Reset password link email method";

    public static final String MSG_ALREADY_ACTIVATED ="You have already completed the sign-up and activation process";
    public static final String DEFAULT_MESSAGE = " There seems to be a problem with processing your request currently. We are looking into it, please try again in sometime. Or you can also email us on success@omoto.io";
    public static final String MSG_EMAIL_VERIFIED = "Email is verified";
    public static final String MSG_ALREADY_ACTIVATION_PROCESS_COMPLETED = "You have already completed the sign-up and activation process";
    public static final String MSG_SUCCESS = "success";
    public static final String MSG_INVALID_NAME = "Only alphabets [A-Z] and [', ] are allowed in queueName";
    public static final String MSG_INVALID_EMAIL = "Please check the format of email id provided";
    public static final String MSG_ALREADY_EMAIL_EXISTS = " A user already exists for the given email ID. In case you don't remember your password, would you like to recover password and sign-in?";
    public static final String MSG_SUCCESSFULL_SIGNUP = "Thank you for signing-up for Omoto. Please check your email to verifyUser your account and get started!";
    public static final String MSG_RESEND_ACTIVATION_EMAIL = " We just resent your account activation email. You'd have received an email from success@omoto.io - try searching for this from address.";
    public static final String MSG_LIMIT_RESEND_ACTIVATION_EMAIL = "It looks like you are having trouble signing up. Please provide your phone number so we can help you get started asap.";

    public static final String CAMPAIGN_SAVED_SUCCESSFULLY = "CampaignDocument is saved successfully";
    public static final String MSG_UPLOADED_FILE_IS_EMPTY = "Please check the file uploaded, it seems to be empty";
    public static final String MSG_INVALID_HEADERS = "The headers in the uploaded file doesn't seem to match with the templates. Download templates and try again.";

    public static final String CAMPAIGN_SENT_SUCCESSFULLY="Campaign sent successfully.";
    public static final String CAMPAIGN_TEMPLATE_NOT_FOUND_MESSAGE="Campaign templates was not found.";
    public static final String CAMPAIGN_NOT_FOUND_MESSAGE="Campaign was not found.";
    public static final String CAMPAIGN_DOC_NOT_FOUND_MESSAGE="Campaign document was not found.";
    public static final String AUDIENCE_CONTACT_EMTPY_MESSAGE="AudienceService contact list is empty.";
    public static final String AUDIENCE_NOT_FOUND_MESSAGE="AudienceService was not found.";
    public static final String SURVEY_NOT_FOUND="SurveyService was not found.";
    public static final String SURVEY_DOC_NOT_FOUND="SurveyService document was not found.";
    public static final String DATA_NOT_AVAILABLE_FOR_GIVEN_WIDGET = "Data not available for given widgetDataProcessor";

    public static final String ORG_NOT_FOUND ="Organisation is not found.";
    public static final String USER_DEF_MERGE_TAG_MAX_LIMIT_EXCEEDS ="Cannot create merge tags. Max limit exceeds.";
    public static final String USER_DEF_MERGE_TAG_SAVED_SUCCESSFULLY ="Merge tags are saved successfully.";
    public static final String USER_DEF_MERGE_TAG_ALREADY_USED = "merge tag is already in use and present in database. Please use another tag.";
    public static final String USER_DEF_MERGE_TAG_DUP = "duplicate merge tag present. Cannot process.";
    public static final String CONTEXT_ACCOUNT_ACTIVATION = "Account activation";
    public static final String MSG_ACCOUNT_INACTIVATED = "Sorry but the account invitation is no longer valid because the account has been deactivated. Would you like to reclaim the account?";
    public static final String MSG_ACCOUNT_SUSPENDED = "Your account has been suspended";
    public static final String MSG_LINK_EXPIRED = "";

    public static final String USER_ALREADY_EXIST= "User Already Exist";
    public static final String USER_DOES_NOT_EXIST = "User does not exist";



    private StatusCodeAndMessages(){
    }
}

