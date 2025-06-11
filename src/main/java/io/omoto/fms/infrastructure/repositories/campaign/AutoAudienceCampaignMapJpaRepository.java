package io.omoto.fms.infrastructure.repositories.campaign;

import io.omoto.fms.infrastructure.entities.mysql.AutoAudienceCampaignMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutoAudienceCampaignMapJpaRepository extends JpaRepository<AutoAudienceCampaignMapEntity,Long> {

    @Query(value = "select * from auto_audience_campaign_map where account_id =:accountId and audience_id =:audienceId and campaign_id =:campaignId",nativeQuery = true)
    AutoAudienceCampaignMapEntity getByAccountIdAudienceIdAndCampaignId(@Param("accountId")Long accountId, @Param("audienceId") String audienceId, @Param("campaignId") String campaignId);

    @Query(value = "select * from auto_audience_campaign_map where account_id =:accountId and audience_id =:audienceId",nativeQuery = true)
    List<AutoAudienceCampaignMapEntity> getByAccountIdAudienceId(@Param("accountId")Long accountId, @Param("audienceId") String audienceId);

    List<AutoAudienceCampaignMapEntity> findByAccountIdAndSurveyId(@Param("accountId")Long accountId, @Param("surveyId") String surveyId);
}
