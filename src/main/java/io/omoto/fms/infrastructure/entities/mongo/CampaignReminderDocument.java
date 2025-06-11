package io.omoto.fms.infrastructure.entities.mongo;

import io.omoto.fms.api.rest.v3.vo.CampaignVO;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
public class CampaignReminderDocument {
    @Id
    private String id;
    private Long accountId;
    private Long createdBy;
    private String campaignId;
    private String campaignRecipientId;
    private String surveyDocumentId;
    private CampaignVO.EmailInfo emailInfo;
    private String name;
    private String type;
    private String sendingTime;
    private int reminderInterval;
    private int numberOfReminder;

    @CreatedDate
    private DateTime createdAt;
    @LastModifiedDate
    private DateTime updatedAt;


    public String getCampaignRecipientId() {
        return campaignRecipientId;
    }

    public void setCampaignRecipientId(String campaignRecipientId) {
        this.campaignRecipientId = campaignRecipientId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
