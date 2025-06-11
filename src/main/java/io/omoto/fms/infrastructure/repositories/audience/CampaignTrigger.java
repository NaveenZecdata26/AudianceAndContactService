package io.omoto.fms.infrastructure.repositories.audience;

import io.omoto.fms.api.rest.v3.vo.CampaignVO;
import io.omoto.fms.controllers.campaign.CampaignController;
import io.omoto.fms.domains.campaign.vo.Campaign;
import io.omoto.fms.infrastructure.repositories.campaign.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CampaignTrigger implements ContactListener {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    private CampaignController campaignController;

    @Override
    public void process(ContactListenerVO contactListenerVO) {
        Campaign.AutoAudienceCampaignMap autoAudienceCampaignMap =new Campaign.AutoAudienceCampaignMap();
        autoAudienceCampaignMap.setAccountId(contactListenerVO.getAccountId());
        autoAudienceCampaignMap.setAudienceId(contactListenerVO.getAudienceId());
        List<Campaign.AutoAudienceCampaignMap> autoAudienceCampaignMapList= campaignRepository.getAutoAudienceCampaignMapByAccountIdAudienceId(autoAudienceCampaignMap);
        autoAudienceCampaignMapList.forEach(autoAudienceCampaignMap1 -> {
            CampaignVO.Send send = new CampaignVO.Send();
            send.setAccountId(autoAudienceCampaignMap1.getAccountId());
            send.setContactId(contactListenerVO.getContactId());
            send.setCampaignId(autoAudienceCampaignMap1.getCampaignId());
            send.setSurveyId(autoAudienceCampaignMap1.getSurveyId());
            send.setContactLevelSending(true);
            campaignController.sendCampaign(send);
        });


    }
}
