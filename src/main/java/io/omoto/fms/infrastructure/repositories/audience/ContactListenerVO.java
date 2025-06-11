package io.omoto.fms.infrastructure.repositories.audience;

public class ContactListenerVO {
    private String audienceId;
    private Long accountId;
    private Long campaignId;
    private String contactId;
    private String contactGroupId;
    public String getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(String audienceId) {
        this.audienceId = audienceId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactGroupId() {
        return contactGroupId;
    }

    public void setContactGroupId(String contactGroupId) {
        this.contactGroupId = contactGroupId;
    }
}
