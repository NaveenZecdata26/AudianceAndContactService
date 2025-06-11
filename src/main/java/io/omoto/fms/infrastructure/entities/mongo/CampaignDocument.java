package io.omoto.fms.infrastructure.entities.mongo;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

/**
 * Created by Venkatesh Gowda on 5/2/18.
 */

@Document
public class CampaignDocument {
    @Id
    private String id;


    /**
     * organizationName : Metropolis
     * emailInfo : {"preHeader":"Pre-header","signature":"Best regards,<br/>Full name of user","subject":"Subject","fromName":"Venkatesh","salutation":{"text":"Hi ||FIRSTNAME||","mergeTags":["||FIRSTNAME||"]},"body":{"npsQuestion":"How likely is it that you would recommend ||ORGANIZATIONNAME|| to your friends and family?","mergeTags":["||ORGANIZATIONNAME||"]},"fromEmail":"venkatesh@omoto.io","footerContent":{"websiteLink":"link","csEmailId":"sucsess@omoto.io","csContactNumber":"+91-843546289+","disclaimerLink":"link","mergeTags":["||ORGANIZATIONNAME||"],"officeAddress":"address"}}
     * orgLogoLink : link
     */
    private String organizationName;
    private EmailInfoEntity emailInfo;
    private String orgLogoLink;
    private String name;
    private long accountId;
    private long createdBy;
    private long updatedBy;
    private boolean scheduleSending;
    private String sendingDate;
    private String sendingTime;
    private boolean notifyUponCompletion;
    private Popup popup;
    private String surveyId;
    private String channel;
    private String campaignType;

    public boolean isNotifyUponCompletion() {
        return notifyUponCompletion;
    }

    public void setNotifyUponCompletion(boolean notifyUponCompletion) {
        this.notifyUponCompletion = notifyUponCompletion;
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

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    @CreatedDate
    private DateTime createdAt;
    @LastModifiedDate
    private DateTime updatedAt;

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

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setEmailInfo(EmailInfoEntity emailInfo) {
        this.emailInfo = emailInfo;
    }

    public void setOrgLogoLink(String orgLogoLink) {
        this.orgLogoLink = orgLogoLink;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public EmailInfoEntity getEmailInfo() {
        return emailInfo;
    }

    public String getOrgLogoLink() {
        return orgLogoLink;
    }

    public Popup getPopup() {
        return popup;
    }

    public void setPopup(Popup popup) {
        this.popup = popup;
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

    public class EmailInfoEntity {
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
        private BodyEntity body;
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


        public void setBody(BodyEntity body) {
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


        public BodyEntity getBody() {
            return body;
        }

        public String getFromEmail() {
            return fromEmail;
        }



        public class BodyEntity {
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

    public static class Popup {
        private int coolOfPeriodInDays;
        private Settings settings;
        private String bubbleColor;
        private String welcomeText;
        private long numberOfImpressions;
        private String position;
        private long clicks;

        public void setCoolOfPeriodInDays(int coolOfPeriodInDays) {
            this.coolOfPeriodInDays = coolOfPeriodInDays;
        }

        public void setSettings(Settings settings) {
            this.settings = settings;
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

        public long getClicks() {
            return clicks;
        }

        public void setClicks(long clicks) {
            this.clicks = clicks;
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

        public String getBubbleColor() {
            return bubbleColor;
        }

        public String getWelcomeText() {
            return welcomeText;
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
}
