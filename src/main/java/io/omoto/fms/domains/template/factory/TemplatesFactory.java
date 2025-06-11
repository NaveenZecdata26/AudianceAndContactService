package io.omoto.fms.domains.template.factory;

import io.omoto.fms.domains.template.TemplateService;
import io.omoto.fms.domains.template.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.omoto.fms.commons.constants.TemplateConstants.*;

/**
 * Created by Venkatesh Gowda on 21/2/18.
 */
@Component
public class TemplatesFactory {

    @Autowired
    private ActivationEmailTemplateServiceImpl activationEmailTemplateService;

    @Autowired
    private DefaultEmailTemplateServiceImpl defaultEmailTemplateService;

    @Autowired
    private CampaignWithSurveyEmailTemplateServiceImpl campaignWithSurveyEmailTemplateService;

    @Autowired
    private InvitationEmailTemplateServiceImpl invitationEmailTemplateService;

    @Autowired
    private InvitationDeliveredEmailTemplateServiceImpl invitationDeliveredEmailTemplateService;

    @Autowired
    private InvitationAcceptedEmailTemplateServiceImpl invitationAcceptedEmailTemplateService;

    @Autowired
    private InvitationNotDeliveredEmailTemplateServiceImpl invitationNotDeliveredEmailTemplateService;

    @Autowired
    private ReminderInvitationEmailTemplateServiceImpl reminderInvitationEmailTemplateService;

    @Autowired
    private InvitationNotAcceptedEmailTemplateServiceImpl invitationNotAcceptedEmailTemplateService;

    @Autowired
    private CampaignCompletionEmailTemplateServiceImpl campaignCompletionEmailTemplateService;


    public TemplateService getTemplate(String templateType){
        switch (templateType) {

            case ACTIVATION_EMAIL_TEMPLATE:
                return activationEmailTemplateService;

            case ACTIVATION_REMINDER_EMAIL_TEMPLATE:
                return defaultEmailTemplateService;

            case CAMPAIGN_WITH_SURVEY:
                return campaignWithSurveyEmailTemplateService;

            case INVITATION_EMAIL_TEMPLATE:
                return invitationEmailTemplateService;

            case INVITATION_DELIVERED_EMAIL_TEMPLATE:
                return invitationDeliveredEmailTemplateService;

            case INVITATION_NOT_DELIVERED_EMAIL_TEMPLATE:
                return invitationNotDeliveredEmailTemplateService;

            case INVITATION_ACCEPTED_EMAIL_TEMPLATE:
                return invitationAcceptedEmailTemplateService;

            case REMINDER_INVITATION_EMAIL_TEMPLATE:
                return reminderInvitationEmailTemplateService;

            case INVITATION_NOT_ACCEPTED_EMAIL_TEMPLATE:
                return invitationNotAcceptedEmailTemplateService;

            case ACCOUNT_ACTIVATION_REMINDER_EMAIL_TEMPLATE:
                return defaultEmailTemplateService;

            case MAGIC_LINK_EMAIL_TEMPLATE:
                return defaultEmailTemplateService;


            case PASSWORD_RESET_LINK_EMAIL_TEMPLATE:
                return defaultEmailTemplateService;

            case CAMPAIGN_STARTED_EMAIL_TEMPLATE_HTML_FILE_NAME:
                return campaignCompletionEmailTemplateService;

            case NPS_EMAIL_TEMPLATE:
                return null;

            default:
                throw new IllegalArgumentException("template type not found!");
        }
    }
}
