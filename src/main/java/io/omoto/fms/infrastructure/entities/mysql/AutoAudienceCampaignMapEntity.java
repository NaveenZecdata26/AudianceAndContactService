package io.omoto.fms.infrastructure.entities.mysql;

import javax.persistence.*;

@Entity(name = "auto_audience_campaign_map")
@Table(name = "auto_audience_campaign_map")
public class AutoAudienceCampaignMapEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "account_id",nullable = false)
    private Long accountId;

    @Column(name = "campaign_id",nullable = false)
    private String campaignId;

    @Column(name = "audience_id",nullable = false)
    private String audienceId;

    @Column(name = "survey_id",nullable = false)
    private String surveyId;

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

    public String getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(String audienceId) {
        this.audienceId = audienceId;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }
}
