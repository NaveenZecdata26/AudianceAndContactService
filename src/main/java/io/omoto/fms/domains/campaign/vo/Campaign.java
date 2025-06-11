package io.omoto.fms.domains.campaign.vo;

import io.omoto.fms.api.rest.v3.vo.CampaignVO;
import io.omoto.fms.domains.audience.Audience;
import io.omoto.fms.domains.reports.filter.Filter;

import java.util.List;

public class Campaign {

    /**
     * organizationName : Metropolis
     * emailInfo : {"preHeader":"Pre-header","signature":"Best regards,<br/>Full name of user","subject":"Subject","fromName":"Venkatesh","salutation":{"text":"Hi ||FIRSTNAME||","mergeTags":["||FIRSTNAME||"]},"body":{"npsQuestion":"How likely is it that you would recommend ||ORGANIZATIONNAME|| to your friends and family?","mergeTags":["||ORGANIZATIONNAME||"]},"fromEmail":"venkatesh@omoto.io","footerContent":{"websiteLink":"link","csEmailId":"sucsess@omoto.io","csContactNumber":"+91-843546289+","disclaimerLink":"link","mergeTags":["||ORGANIZATIONNAME||"],"officeAddress":"address"}}
     * campaignId : 12
     * orgLogoLink : link
     */
    private String organizationName;
    private EmailInfo emailInfo;
    private String campaignId;
    private String reminderCampaignId;
    private String campaignRecipientId;
    private String surveyId;
    private String theme;
    private String themeId;
    private String orgLogoLink;
    private long userId;
    private String name;
    private int themeType;
    private long accountId;
    private long createdBy;
    private long updatedBy;
    private String surveyUrl;
    private boolean testMode;
    private String id;
    private Send send;
    private boolean scheduleSending;
    private boolean isPrimaryCampaign;
    private String sendingDate;
    private String sendingTime;
    private int numberOfReminder;
    private int numberOfReminderSent;
    private int reminderInterval;
    private boolean notifyUponCompletion;
    private List<String> touchPoints;
    private String contactId;
    private boolean isScheduledWithDelay;
    private Integer delayInMin;
    private Popup popup;
    private long impression;
    private long responses;
    private String channel;
    private String campaignType;
    private CampaignInfo campaignInfo;
    private List<String> campaignIds;
    private Filter filter;


    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public List<String> getTouchPoints() {
        return touchPoints;
    }

    public void setTouchPoints(List<String> touchPoints) {
        this.touchPoints = touchPoints;
    }

    public boolean isNotifyUponCompletion() {
        return notifyUponCompletion;
    }

    public void setNotifyUponCompletion(boolean notifyUponCompletion) {
        this.notifyUponCompletion = notifyUponCompletion;
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

    public int getNumberOfReminderSent() {
        return numberOfReminderSent;
    }

    public void setNumberOfReminderSent(int numberOfReminderSent) {
        this.numberOfReminderSent = numberOfReminderSent;
    }

    public String getCampaignRecipientId() {
        return campaignRecipientId;
    }

    public void setCampaignRecipientId(String campaignRecipientId) {
        this.campaignRecipientId = campaignRecipientId;
    }

    public String getReminderCampaignId() {
        return reminderCampaignId;
    }

    public void setReminderCampaignId(String reminderCampaignId) {
        this.reminderCampaignId = reminderCampaignId;
    }

    public boolean isPrimaryCampaign() {
        return isPrimaryCampaign;
    }

    public void setPrimaryCampaign(boolean primaryCampaign) {
        isPrimaryCampaign = primaryCampaign;
    }

    private List<String> audiences;

    public List<String> getAudiences() {
        return audiences;
    }

    public void setAudiences(List<String> audiences) {
        this.audiences = audiences;
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

    public Send getSend() {
        return send;
    }

    public void setSend(Send send) {
        this.send = send;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getSurveyUrl() {
        return surveyUrl;
    }

    public void setSurveyUrl(String surveyUrl) {
        this.surveyUrl = surveyUrl;
    }

    public int getThemeType() {
        return themeType;
    }

    public void setThemeType(int themeType) {
        this.themeType = themeType;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
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

    private AudienceInfo audienceInfo;

    public AudienceInfo getAudienceInfo() {
        return audienceInfo;
    }

    public void setAudienceInfo(AudienceInfo audienceInfo) {
        this.audienceInfo = audienceInfo;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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

    public boolean isScheduledWithDelay() {
        return isScheduledWithDelay;
    }

    public void setScheduledWithDelay(boolean scheduledWithDelay) {
        isScheduledWithDelay = scheduledWithDelay;
    }

    public Integer getDelayInMin() {
        return delayInMin;
    }

    public void setDelayInMin(Integer delayInMin) {
        this.delayInMin = delayInMin;
    }

    public Popup getPopup() {
        return popup;
    }

    public void setPopup(Popup popup) {
        this.popup = popup;
    }

    public long getImpression() {
        return impression;
    }

    public void setImpression(long impression) {
        this.impression = impression;
    }

    public long getResponses() {
        return responses;
    }

    public void setResponses(long responses) {
        this.responses = responses;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType;
    }

    public CampaignInfo getCampaignInfo() {
        return campaignInfo;
    }

    public void setCampaignInfo(CampaignInfo campaignInfo) {
        this.campaignInfo = campaignInfo;
    }

    public List<String> getCampaignIds() {
        return campaignIds;
    }

    public void setCampaignIds(List<String> campaignIds) {
        this.campaignIds = campaignIds;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public static class Schedule {
        private String campaignRecipientId;
        private boolean isPrimaryCampaign;
        private String sendingTime;
        private String sendingDate;
        private boolean isContactLevelSending;
        private String timeZone;

        public boolean isPrimaryCampaign() {
            return isPrimaryCampaign;
        }

        public void setPrimaryCampaign(boolean primaryCampaign) {
            isPrimaryCampaign = primaryCampaign;
        }

        public String getSendingDate() {
            return sendingDate;
        }

        public void setSendingDate(String sendingDate) {
            this.sendingDate = sendingDate;
        }

        public String getCampaignRecipientId() {
            return campaignRecipientId;
        }

        public void setCampaignRecipientId(String campaignRecipientId) {
            this.campaignRecipientId = campaignRecipientId;
        }

        public String getSendingTime() {
            return sendingTime;
        }

        public void setSendingTime(String sendingTime) {
            this.sendingTime = sendingTime;
        }

        public boolean isContactLevelSending() {
            return isContactLevelSending;
        }

        public void setContactLevelSending(boolean contactLevelSending) {
            isContactLevelSending = contactLevelSending;
        }

        public String getTimeZone() {
            return timeZone;
        }

        public void setTimeZone(String timeZone) {
            this.timeZone = timeZone;
        }
    }

    public static class ReminderCampaign {
        private Long accountId;
        private Long createdBy;
        private String campaignId;
        private String campaignRecipientId;
        private String surveyDocumentId;
        private String reminderCampaignId;
        private CampaignVO.EmailInfo emailInfo;
        private String name;
        private String type;
        private String sendingTime;
        private int reminderInterval;
        private int numberOfReminder;
        private int numberOfReminderSent;

        public int getNumberOfReminderSent() {
            return numberOfReminderSent;
        }

        public void setNumberOfReminderSent(int numberOfReminderSent) {
            this.numberOfReminderSent = numberOfReminderSent;
        }

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

        public CampaignVO.EmailInfo getEmailInfo() {
            return emailInfo;
        }

        public void setEmailInfo(CampaignVO.EmailInfo emailInfo) {
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
    }


    public static class AudienceInfo {

        /**
         * name : TempAudience.Bean 1
         * id : 123
         * contacts : [{"firstName":"Venkatesh","lastName":"Gowda","contactId":1574,"contactDetailsGroupId":"c4895b62-54ae-4882-b1d1-ac4472280420","details":[{"name":"city","value":"Bangalore"}],"email":"vg9231@gmail.com"}]
         */
        private String name;
        private long id;
        private long accountId;
        private List<Campaign.AudienceInfo.Contacts> contacts;

        public long getAccountId() {
            return accountId;
        }

        public void setAccountId(long accountId) {
            this.accountId = accountId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setContacts(List<Campaign.AudienceInfo.Contacts> contacts) {
            this.contacts = contacts;
        }

        public String getName() {
            return name;
        }

        public long getId() {
            return id;
        }

        public List<Campaign.AudienceInfo.Contacts> getContacts() {
            return contacts;
        }


        public static class Contacts {
            /**
             * firstName : Venkatesh
             * lastName : Gowda
             * contactId : 1574
             * contactDetailsGroupId : c4895b62-54ae-4882-b1d1-ac4472280420
             * details : [{"name":"city","value":"Bangalore"}]
             * email : vg9231@gmail.com
             */
            private String firstName;
            private String lastName;
            private long contactId;
            private String identifier;
            private String contactDetailsGroupId;
            private List<Audience.Bean.Contacts.Details> details;
            private String email;

            public String getIdentifier() {
                return identifier;
            }

            public void setIdentifier(String identifier) {
                this.identifier = identifier;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public void setContactId(long contactId) {
                this.contactId = contactId;
            }

            public void setContactDetailsGroupId(String contactDetailsGroupId) {
                this.contactDetailsGroupId = contactDetailsGroupId;
            }

            public void setDetails(List<Audience.Bean.Contacts.Details> details) {
                this.details = details;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getFirstName() {
                return firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public long getContactId() {
                return contactId;
            }

            public String getContactDetailsGroupId() {
                return contactDetailsGroupId;
            }

            public List<Audience.Bean.Contacts.Details> getDetails() {
                return details;
            }

            public String getEmail() {
                return email;
            }

            public static class Details {
                /**
                 * name : city
                 * value : Bangalore
                 */
                private String name;
                private String value;

                public void setName(String name) {
                    this.name = name;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public String getName() {
                    return name;
                }

                public String getValue() {
                    return value;
                }
            }
        }

    }

    public static class Send {
        private boolean isPrimaryCampaign;
        private String campaignRecipientId;
        private boolean isContactLevelSending;

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

        public boolean isContactLevelSending() {
            return isContactLevelSending;
        }

        public void setContactLevelSending(boolean contactLevelSending) {
            isContactLevelSending = contactLevelSending;
        }
    }

    public static class EmailInfo {
        /**
         * preHeader : Pre-header
         * signature : Best regards,<br/>Full name of user
         * subject : Subject
         * fromName : Venkatesh
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

    public static class Template {
        private String id;
        private String name;
        private String link;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }




    public static class AutoAudienceCampaignMap {
        private Long id;
        private Long accountId;
        private String campaignId;
        private String surveyId;
        private String audienceId;
        private String sendingType;
        private Long delayInMin;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

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

        public String getSurveyId() {
            return surveyId;
        }

        public void setSurveyId(String surveyId) {
            this.surveyId = surveyId;
        }

        public String getAudienceId() {
            return audienceId;
        }

        public void setAudienceId(String audienceId) {
            this.audienceId = audienceId;
        }

        public String getSendingType() {
            return sendingType;
        }

        public void setSendingType(String sendingType) {
            this.sendingType = sendingType;
        }

        public Long getDelayInMin() {
            return delayInMin;
        }

        public void setDelayInMin(Long delayInMin) {
            this.delayInMin = delayInMin;
        }
    }

    public static class Popup{
        private int coolOfPeriodInDays;
        private Settings settings;
        private String bubbleColor;
        private String welcomeText;
        private long numberOfImpressions;
        private String position;
        private Result result;

        public void setCoolOfPeriodInDays(int coolOfPeriodInDays) {
            this.coolOfPeriodInDays = coolOfPeriodInDays;
        }


        public void setBubbleColor(String bubbleColor) {
            this.bubbleColor = bubbleColor;
        }

        public void setWelcomeText(String welcomeText) {
            this.welcomeText = welcomeText;
        }

        public long getNumberOfImpressions() {
            return numberOfImpressions;
        }

        public void setNumberOfImpressions(long numberOfImpressions) {
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


        public String getPosition() {
            return position;
        }

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
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

        public static class Result{

            private PopupDisplayConfigEntity popupDisplayConfig;
            private String surveyUrl;
            private SurveyPropertiesEntity surveyProperties;

            public void setPopupDisplayConfig(PopupDisplayConfigEntity popupDisplayConfig) {
                this.popupDisplayConfig = popupDisplayConfig;
            }

            public void setSurveyUrl(String surveyUrl) {
                this.surveyUrl = surveyUrl;
            }

            public void setSurveyProperties(SurveyPropertiesEntity surveyProperties) {
                this.surveyProperties = surveyProperties;
            }

            public PopupDisplayConfigEntity getPopupDisplayConfig() {
                return popupDisplayConfig;
            }

            public String getSurveyUrl() {
                return surveyUrl;
            }

            public SurveyPropertiesEntity getSurveyProperties() {
                return surveyProperties;
            }

            public static class PopupDisplayConfigEntity {
                private int scrollInPercent;
                private String urlContains;
                private boolean exitIntent;
                private int timeDelayInSeconds;

                public int getScrollInPercent() {
                    return scrollInPercent;
                }

                public void setScrollInPercent(int scrollInPercent) {
                    this.scrollInPercent = scrollInPercent;
                }

                public String getUrlContains() {
                    return urlContains;
                }

                public void setUrlContains(String urlContains) {
                    this.urlContains = urlContains;
                }

                public boolean isExitIntent() {
                    return exitIntent;
                }

                public void setExitIntent(boolean exitIntent) {
                    this.exitIntent = exitIntent;
                }

                public int getTimeDelayInSeconds() {
                    return timeDelayInSeconds;
                }

                public void setTimeDelayInSeconds(int timeDelayInSeconds) {
                    this.timeDelayInSeconds = timeDelayInSeconds;
                }
            }

            public static class SurveyPropertiesEntity {
                private String popupPosition;
                private int coolOfPeriodInDays;
                private String welcomeText;
                private String orgImageUrl;
                private String bubbleColor;

                public String getPopupPosition() {
                    return popupPosition;
                }

                public void setPopupPosition(String popupPosition) {
                    this.popupPosition = popupPosition;
                }

                public int getCoolOfPeriodInDays() {
                    return coolOfPeriodInDays;
                }

                public void setCoolOfPeriodInDays(int coolOfPeriodInDays) {
                    this.coolOfPeriodInDays = coolOfPeriodInDays;
                }

                public String getWelcomeText() {
                    return welcomeText;
                }

                public void setWelcomeText(String welcomeText) {
                    this.welcomeText = welcomeText;
                }

                public String getOrgImageUrl() {
                    return orgImageUrl;
                }

                public void setOrgImageUrl(String orgImageUrl) {
                    this.orgImageUrl = orgImageUrl;
                }

                public String getBubbleColor() {
                    return bubbleColor;
                }

                public void setBubbleColor(String bubbleColor) {
                    this.bubbleColor = bubbleColor;
                }
            }
        }

    }

    public static class CampaignInfo {
        private long totalNumberOfRecords;
        private List<CampaignData> campaignDataList;

        public long getTotalNumberOfRecords() {
            return totalNumberOfRecords;
        }

        public void setTotalNumberOfRecords(long totalNumberOfRecords) {
            this.totalNumberOfRecords = totalNumberOfRecords;
        }

        public List<CampaignData> getCampaignDataList() {
            return campaignDataList;
        }

        public void setCampaignDataList(List<CampaignData> campaignDataList) {
            this.campaignDataList = campaignDataList;
        }

        public static class CampaignData {

            /**
             * openRate : 78% open rate
             * campaignId : adfdfddf
             * channel : mail
             * clickedRate : 64% click rate
             * delivered : 10
             * opened : 5
             * failed : 2
             * clicked : 4
             * deliveryRate : 99% delivery rate
             * accountId : 10
             * failedRate : 0% failure rate
             * recipients : 1234
             * campaignName : First campaign
             * respondedRate : 14% resp. rate
             * responded : 1
             */
            private String openRate;
            private String campaignId;
            private String channel;
            private String clickedRate;
            private int delivered;
            private int opened;
            private int failed;
            private int clicked;
            private String deliveryRate;
            private long accountId;
            private String failedRate;
            private long recipients;
            private String campaignName;
            private String respondedRate;
            private int responded;

            public String getOpenRate() {
                return openRate;
            }

            public void setOpenRate(String openRate) {
                this.openRate = openRate;
            }

            public String getCampaignId() {
                return campaignId;
            }

            public void setCampaignId(String campaignId) {
                this.campaignId = campaignId;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getClickedRate() {
                return clickedRate;
            }

            public void setClickedRate(String clickedRate) {
                this.clickedRate = clickedRate;
            }

            public int getDelivered() {
                return delivered;
            }

            public void setDelivered(int delivered) {
                this.delivered = delivered;
            }

            public int getOpened() {
                return opened;
            }

            public void setOpened(int opened) {
                this.opened = opened;
            }

            public int getFailed() {
                return failed;
            }

            public void setFailed(int failed) {
                this.failed = failed;
            }

            public int getClicked() {
                return clicked;
            }

            public void setClicked(int clicked) {
                this.clicked = clicked;
            }

            public String getDeliveryRate() {
                return deliveryRate;
            }

            public void setDeliveryRate(String deliveryRate) {
                this.deliveryRate = deliveryRate;
            }

            public long getAccountId() {
                return accountId;
            }

            public void setAccountId(long accountId) {
                this.accountId = accountId;
            }

            public String getFailedRate() {
                return failedRate;
            }

            public void setFailedRate(String failedRate) {
                this.failedRate = failedRate;
            }

            public long getRecipients() {
                return recipients;
            }

            public void setRecipients(long recipients) {
                this.recipients = recipients;
            }

            public String getCampaignName() {
                return campaignName;
            }

            public void setCampaignName(String campaignName) {
                this.campaignName = campaignName;
            }

            public String getRespondedRate() {
                return respondedRate;
            }

            public void setRespondedRate(String respondedRate) {
                this.respondedRate = respondedRate;
            }

            public int getResponded() {
                return responded;
            }

            public void setResponded(int responded) {
                this.responded = responded;
            }
        }
    }
}
