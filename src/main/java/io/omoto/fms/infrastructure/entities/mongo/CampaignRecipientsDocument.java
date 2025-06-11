package io.omoto.fms.infrastructure.entities.mongo;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document
public class CampaignRecipientsDocument {
    @Id
    private String id;
    private String campaignDocumentId;
    private String reminderCampaignDocumentId;
    private String surveyDocumentId;
    private List<String> audiences;
    private Long accountId;
    private Long userId;
    @CreatedDate
    private DateTime createdAt;
    @LastModifiedDate
    private DateTime updatedAt;
    private int numberOfReminder;
    private int numberOfReminderSent;
    private int reminderInterval;
    private String contactId;

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

    public String getReminderCampaignDocumentId() {
        return reminderCampaignDocumentId;
    }

    public void setReminderCampaignDocumentId(String reminderCampaignDocumentId) {
        this.reminderCampaignDocumentId = reminderCampaignDocumentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCampaignDocumentId() {
        return campaignDocumentId;
    }

    public void setCampaignDocumentId(String campaignDocumentId) {
        this.campaignDocumentId = campaignDocumentId;
    }

    public String getSurveyDocumentId() {
        return surveyDocumentId;
    }

    public void setSurveyDocumentId(String surveyDocumentId) {
        this.surveyDocumentId = surveyDocumentId;
    }

    public List<String> getAudiences() {
        return audiences;
    }

    public void setAudiences(List<String> audiences) {
        this.audiences = audiences;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
}
