package io.omoto.fms.domains.campaign.impl;

import io.omoto.fms.commons.constants.UrlConstants;
import io.omoto.fms.domains.campaign.CampaignService;
import io.omoto.fms.domains.campaign.vo.Campaign;
import io.omoto.fms.domains.survey.Survey;
import io.omoto.fms.domains.survey.SurveyUrl;
import io.omoto.fms.infrastructure.repositories.campaign.CampaignRepository;
import io.omoto.fms.infrastructure.repositories.survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class PopupCampaignService implements CampaignService {


    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private SurveyRepository surveyRepository;





    @Override
    public Campaign getCampaign(Campaign campaign) {

        Campaign campaign1 = campaignRepository.getCampaignById(campaign);
        Campaign.Popup popup = campaign1.getPopup();
        Campaign.Popup.Result result = new Campaign.Popup.Result();

        Campaign.Popup.Result.SurveyPropertiesEntity surveyPropertiesEntity  = new Campaign.Popup.Result.SurveyPropertiesEntity();
        surveyPropertiesEntity.setCoolOfPeriodInDays(popup.getCoolOfPeriodInDays());
        surveyPropertiesEntity.setOrgImageUrl(campaign1.getOrgLogoLink());
        surveyPropertiesEntity.setPopupPosition(popup.getPosition());
        surveyPropertiesEntity.setWelcomeText(popup.getWelcomeText());
        surveyPropertiesEntity.setBubbleColor(popup.getBubbleColor());
        result.setSurveyProperties(surveyPropertiesEntity);


        Campaign.Popup.Result.PopupDisplayConfigEntity popupDisplayConfigEntity  = new Campaign.Popup.Result.PopupDisplayConfigEntity();
        Campaign.Popup.Settings settings = popup.getSettings();
        popupDisplayConfigEntity.setUrlContains( settings.getUrls());
        popupDisplayConfigEntity.setExitIntent(settings.isExitIntent());
        popupDisplayConfigEntity.setScrollInPercent(settings.getScrollInPercentage());
        popupDisplayConfigEntity.setTimeDelayInSeconds(settings.getTimeInSeconds());
        result.setPopupDisplayConfig(popupDisplayConfigEntity);

        Survey survey = new Survey();
        survey.setSurveyDocumentId(campaign1.getSurveyId());
        SurveyUrl surveyUrl = surveyRepository.getActiveSurveyUrlBySurveyDocumentId(survey);
        //result.setSurveyUrl(surveyUrl.getShortUrl());
        result.setSurveyUrl(UrlConstants.REGULAR_SURVEY_FEEDBACK_LINK+surveyUrl.getToken());
        Campaign campaign2 = new Campaign();
        Campaign.Popup popup1 = new Campaign.Popup();
        popup1.setResult(result);
        campaign2.setPopup(popup1);


        return campaign2;
    }

    @Override
    public String saveCampaignRecipients(Campaign campaign) {
        return null;
    }

    @Override
    public String scheduleCampaign(Campaign.Schedule schedule) {
        return null;
    }

    @Override
    public String sendCampaign(Campaign.Send send) {
        return null;
    }

    @Override
    public Campaign mapCampaignAndAudiences(Campaign campaign) {

        return null;
    }












}
