package io.omoto.fms.domains.campaign;//package io.omoto.fms.domains.campaign;
//
//import io.omoto.fms.domains.campaign.vo.Campaign;
////import io.omoto.fms.domains.campaign.vo.CampaignTheme;
//import java.util.List;
//

import io.omoto.fms.domains.campaign.vo.Campaign;

///**
// * Created by Venkatesh Gowda on 11/12/17.
// */
//
public interface CampaignService {
//
//    List<Campaign.Template> getAllTemplates();
//  String saveCampaign(Campaign campaign);
  Campaign getCampaign(Campaign campaign);
//    Campaign getCampaignRecipients(Campaign campaign);
//
//  // CampaignTheme getCampaignTheme(Campaign campaign);
//
//    List<Campaign> getAllCampaigns(Campaign campaign);
//
   String saveCampaignRecipients(Campaign campaign);//
//
//    String saveReminderCampaign(Campaign.ReminderCampaign reminderCampaign);
    String scheduleCampaign(Campaign.Schedule schedule);
//
//    Campaign.ReminderCampaign getReminderCampaign(Campaign.ReminderCampaign reminderCampaign);
//
//    List<String> getAudienceFromCampaignRecipients(Campaign campaign);
//
    String sendCampaign(Campaign.Send send);
//
//    List<String> getTouchPoints(Long type);
//
//    boolean updateImpression(Campaign campaign);
//
//    boolean updateClicks(Campaign campaign);
//
//    Campaign geCampaignInfo(Campaign campaign);
//
 Campaign mapCampaignAndAudiences(Campaign campaign);
//
//    Campaign getImpression(Campaign campaign);
//
//    Campaign getResponse(Campaign campaign);
//
//    Campaign getCampaignInfo(Campaign campaign);
//
//    boolean deleteCampaigns(Campaign campaign);
}
