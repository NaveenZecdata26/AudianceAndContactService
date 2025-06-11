package io.omoto.fms.api.rest.v3.vo;

import java.util.List;

public class CampaignVO {


    /**
     * organizationName : Metropolis
     * emailInfo : {"preHeader":"Pre-header","signature":"Best regards,<br/>Full name of user","subject":"Subject","toEmail":"Venkatesh","salutation":{"text":"Hi ||FIRSTNAME||","mergeTags":["||FIRSTNAME||"]},"body":{"npsQuestion":"How likely is it that you would recommend ||ORGANIZATIONNAME|| to your friends and family?","mergeTags":["||ORGANIZATIONNAME||"]},"fromEmail":"venkatesh@omoto.io","footerContent":{"websiteLink":"link","csEmailId":"sucsess@omoto.io","csContactNumber":"+91-843546289+","disclaimerLink":"link","mergeTags":["||ORGANIZATIONNAME||"],"officeAddress":"address"}}
     * campaignId : 12
     * orgLogoLink : link
     */
    private String organizationName;
    private EmailInfo emailInfo;
    private String campaignId;
    private String surveyId;
    private String name;
    private long accountId;
    private long createdBy;
    private long updatedBy;
    private String orgLogoLink;
    private boolean scheduleSending;
    private String sendingDate;
    private String sendingTime;
    private boolean notifyUponCompletion;
    private String campaignType;
    private Popup popup;

    public boolean isNotifyUponCompletion() {
        return notifyUponCompletion;
    }

    public void setNotifyUponCompletion(boolean notifyUponCompletion) {
        this.notifyUponCompletion = notifyUponCompletion;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public boolean isScheduleSending() {
        return scheduleSending;
    }

    public void setScheduleSending(boolean scheduleSending) {
        this.scheduleSending = scheduleSending;
    }

    public String getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(String sendingDate) {
        this.sendingDate = sendingDate;
    }

    public String getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(String sendingTime) {
        this.sendingTime = sendingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setEmailInfo(EmailInfo emailInfo) {
        this.emailInfo = emailInfo;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public void setOrgLogoLink(String orgLogoLink) {
        this.orgLogoLink = orgLogoLink;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public EmailInfo getEmailInfo() {
        return emailInfo;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public String getOrgLogoLink() {
        return orgLogoLink;
    }

    public String getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType;
    }

    public Popup getPopup() {
        return popup;
    }

    public void setPopup(Popup popup) {
        this.popup = popup;
    }

    public static class ScheduledCampaign{
        private boolean isPrimaryCampaign;
        private String campaignRecipientId;

        public boolean isPrimaryCampaign() {
            return isPrimaryCampaign;
        }

        public void setPrimaryCampaign(boolean primaryCampaign) {
            isPrimaryCampaign = primaryCampaign;
        }

        public String getCampaignRecipientId() {
            return campaignRecipientId;
        }

        public void setCampaignRecipientId(String campaignRecipientId) {
            this.campaignRecipientId = campaignRecipientId;
        }
    }

    public static class ReminderCampaign{
        private Long accountId;
        private Long createdBy;
        private String campaignId;
        private String campaignRecipientId;
        private String surveyDocumentId;
        private String reminderCampaignId;
        private EmailInfo emailInfo;
        private String name;
        private String type;
        private String sendingTime;
        private int reminderInterval;
        private int numberOfReminder;
        private Long userId;


        public String getCampaignRecipientId() {
            return campaignRecipientId;
        }

        public void setCampaignRecipientId(String campaignRecipientId) {
            this.campaignRecipientId = campaignRecipientId;
        }

        public Long getAccountId() {
            return accountId;
        }

        public void setAccountId(Long accountId) {
            this.accountId = accountId;
        }

        public Long getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Long createdBy) {
            this.createdBy = createdBy;
        }

        public String getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(String campaignId) {
            this.campaignId = campaignId;
        }

        public String getSurveyDocumentId() {
            return surveyDocumentId;
        }

        public void setSurveyDocumentId(String surveyDocumentId) {
            this.surveyDocumentId = surveyDocumentId;
        }

        public String getReminderCampaignId() {
            return reminderCampaignId;
        }

        public void setReminderCampaignId(String reminderCampaignId) {
            this.reminderCampaignId = reminderCampaignId;
        }

        public EmailInfo getEmailInfo() {
            return emailInfo;
        }

        public void setEmailInfo(EmailInfo emailInfo) {
            this.emailInfo = emailInfo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSendingTime() {
            return sendingTime;
        }

        public void setSendingTime(String sendingTime) {
            this.sendingTime = sendingTime;
        }

        public int getReminderInterval() {
            return reminderInterval;
        }

        public void setReminderInterval(int reminderInterval) {
            this.reminderInterval = reminderInterval;
        }

        public int getNumberOfReminder() {
            return numberOfReminder;
        }

        public void setNumberOfReminder(int numberOfReminder) {
            this.numberOfReminder = numberOfReminder;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }

    public static class EmailInfo {
        /**
         * preHeader : Pre-header
         * signature : Best regards,<br/>Full name of user
         * subject : Subject
         * toEmail : Venkatesh
         * salutation : {"text":"Hi ||FIRSTNAME||","mergeTags":["||FIRSTNAME||"]}
         * body : {"npsQuestion":"How likely is it that you would recommend ||ORGANIZATIONNAME|| to your friends and family?","mergeTags":["||ORGANIZATIONNAME||"]}
         * fromEmail : venkatesh@omoto.io
         * footerContent : {"websiteLink":"link","csEmailId":"sucsess@omoto.io","csContactNumber":"+91-843546289+","disclaimerLink":"link","mergeTags":["||ORGANIZATIONNAME||"],"officeAddress":"address"}
         */
        private String preHeader;
        private String subject;
        private String fromName;
        private Body body;
        private String fromEmail;

        public void setPreHeader(String preHeader) {
            this.preHeader = preHeader;
        }


        public void setSubject(String subject) {
            this.subject = subject;
        }

        public void setFromName(String fromName) {
            this.fromName = fromName;
        }


        public void setBody(Body body) {
            this.body = body;
        }

        public void setFromEmail(String fromEmail) {
            this.fromEmail = fromEmail;
        }


        public String getPreHeader() {
            return preHeader;
        }


        public String getSubject() {
            return subject;
        }

        public String getFromName() {
            return fromName;
        }


        public Body getBody() {
            return body;
        }

        public String getFromEmail() {
            return fromEmail;
        }



        public static class Body {
            /**
             * message : How likely is it that you would recommend ||ORGANIZATIONNAME|| to your friends and family?
             * mergeTags : ["||ORGANIZATIONNAME||"]
             */
            private String message;
            private List<String> mergeTags;


            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public List<String> getMergeTags() {
                return mergeTags;
            }

            public void setMergeTags(List<String> mergeTags) {
                this.mergeTags = mergeTags;
            }
        }

    }

    public static class Send {

        private long accountId;
        private String campaignId;
        private String themeId;
        private String surveyId;
        private long audienceId;
        private long userId;
        private List<String> audiences;
        private String contactId;
        private boolean isContactLevelSending;
        private String contactIdentifier;

        public String getContactIdentifier() {
            return contactIdentifier;
        }

        public void setContactIdentifier(String contactIdentifier) {
            this.contactIdentifier = contactIdentifier;
        }

        public List<String> getAudiences() {
            return audiences;
        }

        public void setAudiences(List<String> audiences) {
            this.audiences = audiences;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getAccountId() {
            return accountId;
        }

        public void setAccountId(long accountId) {
            this.accountId = accountId;
        }

        public String getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(String campaignId) {
            this.campaignId = campaignId;
        }

        public String getThemeId() {
            return themeId;
        }

        public void setThemeId(String themeId) {
            this.themeId = themeId;
        }

        public String getSurveyId() {
            return surveyId;
        }

        public void setSurveyId(String surveyId) {
            this.surveyId = surveyId;
        }

        public long getAudienceId() {
            return audienceId;
        }

        public void setAudienceId(long audienceId) {
            this.audienceId = audienceId;
        }

        public String getContactId() {
            return contactId;
        }

        public void setContactId(String contactId) {
            this.contactId = contactId;
        }

        public boolean isContactLevelSending() {
            return isContactLevelSending;
        }

        public void setContactLevelSending(boolean contactLevelSending) {
            isContactLevelSending = contactLevelSending;
        }
    }

    public static class SendTestCampaign{
        private String campaignId;
        private String templateId;
        private String toEmail;
        private long userId;
        private long accountId;
        private String themeId;
        private String surveyId;


        public long getAccountId() {
            return accountId;
        }

        public void setAccountId(long accountId) {
            this.accountId = accountId;
        }

        public String getThemeId() {
            return themeId;
        }

        public void setThemeId(String themeId) {
            this.themeId = themeId;
        }

        public String getSurveyId() {
            return surveyId;
        }

        public void setSurveyId(String surveyId) {
            this.surveyId = surveyId;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(String campaignId) {
            this.campaignId = campaignId;
        }

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }

        public String getToEmail() {
            return toEmail;
        }

        public void setToEmail(String toEmail) {
            this.toEmail = toEmail;
        }

    }

    public static class AutoAudienceCampaignMap {
        private Long accountId;
        private String campaignId;
        private String audienceName;
        private String audienceDescription;
        private String surveyId;
        private String touchPoint;
        private String accountIdentifier;

        public Long getAccountId() {
            return accountId;
        }

        public void setAccountId(Long accountId) {
            this.accountId = accountId;
        }

        public String getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(String campaignId) {
            this.campaignId = campaignId;
        }

        public String getAudienceName() {
            return audienceName;
        }

        public void setAudienceName(String audienceName) {
            this.audienceName = audienceName;
        }

        public String getAudienceDescription() {
            return audienceDescription;
        }

        public void setAudienceDescription(String audienceDescription) {
            this.audienceDescription = audienceDescription;
        }

        public String getSurveyId() {
            return surveyId;
        }

        public void setSurveyId(String surveyId) {
            this.surveyId = surveyId;
        }

        public String getTouchPoint() {
            return touchPoint;
        }

        public void setTouchPoint(String touchPoint) {
            this.touchPoint = touchPoint;
        }

        public String getAccountIdentifier() {
            return accountIdentifier;
        }

        public void setAccountIdentifier(String accountIdentifier) {
            this.accountIdentifier = accountIdentifier;
        }
    }

    public static class AutoAudienceCampaignResultVO{
        private String apikey;
        private String url;

        public String getApikey() {
            return apikey;
        }

        public void setApikey(String apikey) {
            this.apikey = apikey;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }


    public static class Popup{
        private int coolOfPeriodInDays;
        private Settings settings;
        private String bubbleColor;
        private String welcomeText;
        private int numberOfImpressions;
        private String position;

        public void setCoolOfPeriodInDays(int coolOfPeriodInDays) {
            this.coolOfPeriodInDays = coolOfPeriodInDays;
        }


        public void setBubbleColor(String bubbleColor) {
            this.bubbleColor = bubbleColor;
        }

        public void setWelcomeText(String welcomeText) {
            this.welcomeText = welcomeText;
        }

        public void setNumberOfImpressions(int numberOfImpressions) {
            this.numberOfImpressions = numberOfImpressions;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public int getCoolOfPeriodInDays() {
            return coolOfPeriodInDays;
        }

        public Settings getSettings() {
            return settings;
        }

        public void setSettings(Settings settings) {
            this.settings = settings;
        }

        public String getBubbleColor() {
            return bubbleColor;
        }

        public String getWelcomeText() {
            return welcomeText;
        }

        public int getNumberOfImpressions() {
            return numberOfImpressions;
        }

        public String getPosition() {
            return position;
        }

        public static class Settings {
            private String urls;
            private Integer scrollInPercentage;
            private boolean exitIntent;
            private Integer timeInSeconds;

            public String getUrls() {
                return urls;
            }

            public void setUrls(String urls) {
                this.urls = urls;
            }

            public Integer getScrollInPercentage() {
                return scrollInPercentage;
            }

            public void setScrollInPercentage(Integer scrollInPercentage) {
                this.scrollInPercentage = scrollInPercentage;
            }

            public boolean isExitIntent() {
                return exitIntent;
            }

            public void setExitIntent(boolean exitIntent) {
                this.exitIntent = exitIntent;
            }

            public Integer getTimeInSeconds() {
                return timeInSeconds;
            }

            public void setTimeInSeconds(Integer timeInSeconds) {
                this.timeInSeconds = timeInSeconds;
            }
        }
    }

    public static class DeleteVO{
        private long accountId;
        private long userId;
        private List<String> campaignIdList;


        public long getAccountId() {
            return accountId;
        }

        public void setAccountId(long accountId) {
            this.accountId = accountId;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }


        public List<String> getCampaignIdList() {
            return campaignIdList;
        }

        public void setCampaignIdList(List<String> campaignIdList) {
            this.campaignIdList = campaignIdList;
        }
    }


}
