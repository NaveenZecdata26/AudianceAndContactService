package io.omoto.fms.domains.campaign.impl;

import io.omoto.fms.commons.constants.MergeTagConstants;
import io.omoto.fms.commons.constants.UrlConstants;
import io.omoto.fms.domains.audience.Audience;
import io.omoto.fms.domains.campaign.CampaignService;
import io.omoto.fms.domains.campaign.vo.Campaign;
import io.omoto.fms.domains.quota.Quota;
import io.omoto.fms.domains.quota.impl.EmailQuotaService;
import io.omoto.fms.domains.survey.Survey;
import io.omoto.fms.infrastructure.adapters.email.Email;
import io.omoto.fms.infrastructure.adapters.email.EmailAdapter;
import io.omoto.fms.infrastructure.adapters.scheduler.Schedule;
import io.omoto.fms.infrastructure.adapters.scheduler.impl.FlowSchedulerImpl;
import io.omoto.fms.infrastructure.entities.mongo.CampaignTransactionDocument;
import io.omoto.fms.infrastructure.entities.mongo.ContactsDocument;
import io.omoto.fms.infrastructure.repositories.audience.AudienceRepository;
import io.omoto.fms.infrastructure.repositories.campaign.CampaignRepository;
import io.omoto.fms.infrastructure.repositories.survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import static io.omoto.fms.commons.constants.Constants.*;
import static io.omoto.fms.commons.constants.Constants.SEND_STATUS_CHANNEL_SUSPENDED;
import static io.omoto.fms.commons.constants.Constants.SEND_STATUS_QUOTA_EXHAUSTED;
import static io.omoto.fms.commons.constants.Constants.STATUS_FAILED;


@Component
@Qualifier("emailCampaignServiceImpl")
public class EmailCampaignServiceImpl implements CampaignService {


    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private FlowSchedulerImpl flowScheduler;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AudienceRepository audienceRepository;

    @Autowired
    private EmailAdapter<Campaign> emailAdapter;


    @Autowired
    private EmailQuotaService emailQuotaService;









    @Override
    public Campaign getCampaign(Campaign campaign) {
        return campaignRepository.getCampaignById(campaign);
    }

    @Override
    public String saveCampaignRecipients(Campaign campaign) {
        return campaignRepository.saveCampaignRecipients(campaign);
    }

    private void updateCampaignTransactionStatus(Campaign campaign,String groupId,String contactIdentifier,String status,String sendStatus){
        campaignRepository.updateContactTransactionStatus(campaign,groupId,contactIdentifier,CHANNEL_EMAIL,status,sendStatus);
    }


    @Override
    public String scheduleCampaign(Campaign.Schedule campaignSchedule) {
        String[] dateSplit = campaignSchedule.getSendingDate().split("-");
        String[] timeSplit = campaignSchedule.getSendingTime().split(":");

        Schedule schedule = new Schedule();
        Schedule.ScheduleAt scheduleAt = new Schedule.ScheduleAt();
        scheduleAt.setYear(dateSplit[0]);
        scheduleAt.setMonth(dateSplit[1]);
        scheduleAt.setDay(dateSplit[2]);
        scheduleAt.setHour(timeSplit[0]);
        scheduleAt.setMin(timeSplit[1]);
        schedule.setScheduleAt(scheduleAt);

        schedule.setIntegrationKey(FLOW_INTEGRATION_KEY);
        schedule.setScheduleEndpoint(UrlConstants.OMOTO_BACKEND_URL + "/campaign/sendScheduledCampaign");
        //schedule.setTimeZone(usersRepository.getUserTimeZoneById(reminderCampaign.getCreatedBy()));
        HashMap uniqueArguments = new HashMap();
        uniqueArguments.put("isPrimaryCampaign", campaignSchedule.isPrimaryCampaign());
        uniqueArguments.put("campaignRecipientId", campaignSchedule.getCampaignRecipientId());
        uniqueArguments.put("isContactLevelSending", campaignSchedule.isContactLevelSending());

        schedule.setUniqueArguments(uniqueArguments);
        schedule.setTimeZone(schedule.getTimeZone());
        return flowScheduler.schedule(schedule);
    }

    private String replaceFirstNameMergeTags(String message, String firstName) {
        return message.replace(MergeTagConstants.FIRST_NAME, firstName);
    }

    private String replaceSurveyUrl(String message, String surveyUrl) {
        return message.replace(MergeTagConstants.SURVEY_LINK_MERGE_TAG, surveyUrl);
    }

    private void updateCampaignTransactionData(Campaign campaign,String groupId,String contactIdentifer){
        campaignRepository.updateContactTransaction(campaign,groupId,contactIdentifer,CHANNEL_EMAIL);
    }





    @Override
    public String sendCampaign(Campaign.Send send) {
        Campaign campaignRecipients = campaignRepository.getCampaignRecipientsById(send.getCampaignRecipientId());
        campaignRecipients.setCampaignRecipientId(send.getCampaignRecipientId());
        Survey survey = new Survey();
        survey.setSurveyDocumentId(campaignRecipients.getSurveyId());
        Long token = surveyRepository.getActiveSurveyUrlBySurveyDocumentId(survey).getToken();
        String surveyType = surveyRepository.getSurveyType(campaignRecipients.getSurveyId());

        if (send.isPrimaryCampaign()) {
            Campaign campaign = new Campaign();
            campaign.setCampaignId(campaignRecipients.getCampaignId());
            campaign = campaignRepository.getCampaignById(campaign);
            campaign.setSurveyId(campaignRecipients.getSurveyId());
            List<String> audiences = campaignRecipients.getAudiences();
            Audience audience = new Audience();
            if (send.isContactLevelSending()) {
                audience.setContactId(campaignRecipients.getContactId());
                ContactsDocument contactDocument = audienceRepository.getContactDocument(audience);
                sendMail(contactDocument, token, campaign, surveyType);

            } else {
                for (String audienceId : audiences) {
                    audience.setAudienceId(audienceId);
                    List<CampaignTransactionDocument> campaignTransactionDocumentList = campaignRepository.getCampaignTransactionByAudienceId(audienceId);
                    for (CampaignTransactionDocument campaignTransactionDocument : campaignTransactionDocumentList) {
                        Map qualifyingInfo = campaignTransactionDocument.getQualifyingInfo();
                        String groupId = qualifyingInfo.get(CONTACT_QUALIFYING_INFO_GROUP_ID).toString();
                        String surveyUrl = getSurveyUrl(token, groupId, surveyType);
                        String message = campaign.getEmailInfo().getBody().getMessage();
                        message = replaceFirstNameMergeTags(message, campaignTransactionDocument.getFirstName());
                        message = replaceSurveyUrl(message, surveyUrl);
                        Email email = new Email();
                        email.setTos(new ArrayList<>(Collections.singletonList(campaignTransactionDocument.getEmail())));
                        email.setBody(message);
                        email.setToEmail(campaignTransactionDocument.getEmail());
                        email.setSubject(campaign.getEmailInfo().getSubject());
                        email.setFromEmail(campaign.getEmailInfo().getFromEmail());
                        email.setIntegrationKey(FLOW_INTEGRATION_KEY);
                        email.setUserId(campaign.getUserId());
                        emailAdapter.sendEmail(email);
                        updateCampaignTransactionData(campaign, groupId, campaignTransactionDocument.getIdentifier());
                    }


                    //todo remove this
                    /*Audience.ContactInfo contacts = audienceRepository.getAllContacts(audience);
                    for (Map map : contacts.getContactsListData()) {
                        Document qualifyingInfo = (Document) map.get("qualifyingInfo");
                        String groupId = ((Document) map.get("qualifyingInfo")).get("groupId").toString();
                        String surveyUrl = getSurveyUrl(token, groupId,surveyType);
                        String message = campaign.getEmailInfo().getBody().getMessage();
                        message = replaceFirstNameMergeTags(message, map.get("firstName").toString());
                        message = replaceSurveyUrl(message, surveyUrl);
                        Email email = new Email();
                        email.setTos(new ArrayList<>(Collections.singletonList(qualifyingInfo.get("emailID").toString())));
                        email.setBody(message);
                        email.setToEmail(qualifyingInfo.get("emailID").toString());
                        email.setSubject(campaign.getEmailInfo().getSubject());
                        email.setFromEmail(campaign.getEmailInfo().getFromEmail());
                        email.setIntegrationKey(FLOW_INTEGRATION_KEY);
                        email.setUserId(campaign.getUserId());
                        emailAdapter.sendEmail(email);
                        updateCampaignTransactionData(campaign, groupId, map.get("identifier").toString());
                    }*/
                }
            }

        } else {
            Campaign.ReminderCampaign reminderCampaign = campaignRepository.getReminderCampaignById(campaignRecipients.getReminderCampaignId());
            List<String> audiences = campaignRecipients.getAudiences();
            Audience audience = new Audience();
            if (send.isContactLevelSending()) {

            } else {
                for (String audienceId : audiences) {
                    audience.setAudienceId(audienceId);
                    Audience.ContactInfo contacts = audienceRepository.getNonRespondedContacts(audience);
                    for (Map map : contacts.getContactsListData()) {
                        String groupId = ((HashMap) map.get("qualifyingInfo")).get("groupId").toString();
                        String surveyUrl = getSurveyUrl(token, groupId, surveyType);
                        String message = reminderCampaign.getEmailInfo().getBody().getMessage();
                        message = replaceFirstNameMergeTags(message, map.get("firstName").toString());
                        message = replaceSurveyUrl(message, surveyUrl);
                        Email email = new Email();
                        email.setTos(new ArrayList<>(Collections.singletonList(map.get("email").toString())));
                        email.setBody(message);
                        email.setToEmail(map.get("email").toString());
                        email.setSubject(reminderCampaign.getEmailInfo().getSubject());
                        email.setFromEmail(reminderCampaign.getEmailInfo().getFromEmail());
                        email.setIntegrationKey(FLOW_INTEGRATION_KEY);
                        email.setUserId(1);
                        emailAdapter.sendEmail(email);
                        //updateCampaignTransactionData(reminderCampaign,groupId,map.get("identifier").toString());//todo need to add the code
                    }
                }
            }
        }
        Campaign campaign = new Campaign();
        campaign.setAudiences(campaignRecipients.getAudiences());
        campaign.setAccountId(campaignRecipients.getAccountId());
        campaign.setCampaignId(campaignRecipients.getCampaignId());
        campaign.setSurveyId(campaignRecipients.getSurveyId());
        mapCampaignAndAudiences(campaign);
        return "Success";
    }


    private String getSurveyUrl(Long surveyIdentifier, String respondentIdentifier, String surveyType) {
        if (surveyType.equalsIgnoreCase("REGULAR")){
            return UrlConstants.REGULAR_SURVEY_FEEDBACK_LINK + surveyIdentifier + "/" + respondentIdentifier;
        }else{
            return UrlConstants.CHAT_BOT_SURVEY_FEEDBACK_LINK + surveyIdentifier + "/" + respondentIdentifier;
        }
    }




    @Override
    public Campaign mapCampaignAndAudiences(Campaign campaign) {
        for (String audienceId : campaign.getAudiences()) {
            Campaign.AutoAudienceCampaignMap autoAudienceCampaignMap = new Campaign.AutoAudienceCampaignMap();
            autoAudienceCampaignMap.setAccountId(campaign.getAccountId());
            autoAudienceCampaignMap.setAudienceId(audienceId);
            autoAudienceCampaignMap.setCampaignId(campaign.getCampaignId());
            autoAudienceCampaignMap.setSurveyId(campaign.getSurveyId());
            campaignRepository.saveAutoAudienceCampaignMap(autoAudienceCampaignMap);
        }
        return null;
    }


    public void sendMail(ContactsDocument document, Long token, Campaign campaign, String surveyType) {
        AtomicReference<String> groupIdAtomic = new AtomicReference<>();
        document.getQualifyingInfo().forEach(map -> {
            if (map.containsKey("groupId")) {
                groupIdAtomic.set(map.get("groupId").toString());
            }
        });

        String groupId = groupIdAtomic.toString();
        String surveyUrl = getSurveyUrl(token, groupId,surveyType);
        String message = campaign.getEmailInfo().getBody().getMessage();
        message = replaceFirstNameMergeTags(message, document.getFirstName());
        message = replaceSurveyUrl(message, surveyUrl);

        Quota quota = new Quota();
        quota.setAccountId(document.getAccountId());
        if (!emailQuotaService.isQuotaPresent(quota)) {
            updateCampaignTransactionStatus(campaign, groupId, document.getIdentifier(),STATUS_FAILED,SEND_STATUS_CHANNEL_SUSPENDED);
            return;

        }

        if (!emailQuotaService.isQuotaAvailable(quota)) {
            updateCampaignTransactionStatus(campaign, groupId, document.getIdentifier(),STATUS_FAILED,SEND_STATUS_QUOTA_EXHAUSTED);
            return;
        }


        Email email = new Email();
        email.setTos(new ArrayList<>(Collections.singletonList(document.getEmail())));
        email.setBody(message);
        email.setToEmail(document.getEmail());
        email.setSubject(campaign.getEmailInfo().getSubject());
        email.setFromEmail(campaign.getEmailInfo().getFromEmail());
        email.setIntegrationKey(FLOW_INTEGRATION_KEY);
        email.setUserId(campaign.getUserId());
        emailAdapter.sendEmail(email);
        updateCampaignTransactionData(campaign, groupId, document.getIdentifier());
        quota.setQuotaReductionCount(1);
        emailQuotaService.reduceQuota(quota);

    }
}















