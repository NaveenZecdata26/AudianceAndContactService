package io.omoto.fms.commons.constants;

/**
 * Created by Venkatesh Gowda on 12/1/18.
 *
 * TemplateConstants defines all the constants related to templates.
 *
 * Please define templates file name (file generally present in resources) as constant in TemplateConstants
 * before using file name else where in the code.
 *
 *
 */
public class TemplateConstants {

    private TemplateConstants() {
    }

    //activation email sent when user signup
    public static final String NPS_EMAIL_TEMPLATE =  "nps_email_template";
    public static final String ACTIVATION_EMAIL_TEMPLATE =  "activation_email_template";
    public static final String INVITATION_EMAIL_TEMPLATE =  "invitation_email_template";
    public  static final String ACTIVATION_EMAIL_TEMPLATE_HTML_FILE_NAME="activationEmailTemplate";
    public static final String INVITATION_DELIVERED_EMAIL_TEMPLATE =  "invitation_delivered_email_template";
    public static final String INVITATION_NOT_DELIVERED_EMAIL_TEMPLATE =  "invitation_not_delivered_email_template";
    public static final String INVITATION_ACCEPTED_EMAIL_TEMPLATE =  "invitation_accepted_email_template";
    public static final String REMINDER_INVITATION_EMAIL_TEMPLATE =  "reminder_invitation_email_template";
    public static final String INVITATION_NOT_ACCEPTED_EMAIL_TEMPLATE =  "invitation_not_accepted_email_template";
    public  static final String ACTIVATION_EMAIL_SUBJECT="Omoto: Activation link";



    //password reset link email
    public static final String PASSWORD_RESET_LINK_EMAIL_TEMPLATE =  "password_reset_link_email_template";
    public  static final String PASSWORD_RESET_LINK_EMAIL_TEMPLATE_HTML_FILE_NAME="passwordResetLinkEmailTemplate";
    public  static final String PASSWORD_RESET_LINK_EMAIL_SUBJECT="Omoto: Password reset link";











    //magic link email
    public static final String MAGIC_LINK_EMAIL_TEMPLATE =  "magic_link_email_template";
    public  static final String MAGIC_LINK_EMAIL_TEMPLATE_HTML_FILE_NAME="magicLinkEmailTemplate";
    public  static final String MAGIC_LINK_EMAIL_SUBJECT="Omoto: Magic link";

    //activation reminder email sent user has signup however has not verified the email.
    public static final String ACTIVATION_REMINDER_EMAIL_TEMPLATE ="activation_reminder_email_template";
    public static final String ACTIVATION_REMINDER_EMAIL_TEMPLATE_HTML_FILE_NAME_1="activationReminderEmailTemplate1";
    public static final String ACTIVATION_REMINDER_EMAIL_TEMPLATE_HTML_FILE_NAME_2="activationReminderEmailTemplate2";
    public static final String ACTIVATION_REMINDER_EMAIL_TEMPLATE_HTML_FILE_NAME_3="activationReminderEmailTemplate3";
    public static final String ACTIVATION_REMINDER_EMAIL_TEMPLATE_HTML_FILE_NAME_4="activationReminderEmailTemplate4";
    public static final String ACTIVATION_REMINDER_EMAIL_TEMPLATE_HTML_FILE_NAME_5="activationReminderEmailTemplate5";

    public static final String INVITATION_EMAIL_TEMPLATE_HTML_FILE_NAME = "invitationEmailTemplate";
    public static final String CAMPAIGN_STARTED_EMAIL_TEMPLATE_HTML_FILE_NAME = "campaignStartedEmailTemplate";
    public static final String INVITATION_DELIVERED_EMAIL_TEMPLATE_HTML_FILE_NAME = "invitationDeliveredEmailTemplate";
    public static final String INVITATION_NOT_DELIVERED_EMAIL_TEMPLATE_HTML_FILE_NAME = "invitationNotDeliveredEmailTemplate";
    public static final String INVITATION_ACCEPTED_EMAIL_TEMPLATE_HTML_FILE_NAME = "invitationAcceptedEmailTemplate";
    public static final String REMINDER_INVITATION_EMAIL_TEMPLATE_HTML_FILE_NAME = "reminderinvitationEmailTemplate";
    public static final String INVITATION_NOT_ACCEPTED_EMAIL_TEMPLATE_HTML_FILE_NAME = "invitationNotAcceptedEmailTemplate";
    //campaign with survey. Data needs to be configured in database for templates with name as templates name
    public static final String CAMPAIGN_WITH_SURVEY="campaign_with_survey";
    public static final String CAMPAIGN_WITH_SURVEY_HTML_FILE_NAME="campaignWithSurveyEmailTemplate";

    //account activation reminder email sent user has verified.However password is not yet set or account is not yet activated.
    public static final String ACCOUNT_ACTIVATION_REMINDER_EMAIL_TEMPLATE ="account_activation_reminder_email_template";
    public static final String ACCOUNT_ACTIVATION_REMINDER_EMAIL_TEMPLATE_HTML_FILE_NAME="accountActivationReminderEmailTemplate";

    public static final String OMOTO_LEVEL_1_EMAIL="omoto.level1@gmail.com";
    public static final String OMOTO_SUPPORT_EMAIL = "support@omoto.io";
    public static final String OMOTO_SUCCESS_EMAIL = "success@omoto.io";
}
