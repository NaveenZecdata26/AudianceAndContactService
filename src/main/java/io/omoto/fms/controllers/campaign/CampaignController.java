package io.omoto.fms.controllers.campaign;

import io.omoto.fms.api.rest.v3.vo.CampaignVO;
import io.omoto.fms.commons.constants.MergeTagConstants;
import io.omoto.fms.domains.campaign.CampaignService;
import io.omoto.fms.domains.campaign.vo.Campaign;
import io.omoto.fms.domains.user.User;
import io.omoto.fms.domains.user.UserService;
import io.omoto.fms.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;


@Service
public class CampaignController {


    @Autowired
    @Qualifier("emailCampaignServiceImpl")
    private CampaignService campaignService;

    @Autowired
    private UserService userService;




    public String sendCampaign(CampaignVO.Send sendVO) {
        Campaign campaign = new Campaign();
        campaign.setCampaignId(sendVO.getCampaignId());
        campaign = campaignService.getCampaign(campaign);
        campaign.setSurveyId(sendVO.getSurveyId());
        campaign.setAudiences(sendVO.getAudiences());
        campaign.setContactId(sendVO.getContactId());


        String campaignRecipientIdentifier = campaignService.saveCampaignRecipients(campaign);
        System.out.println("Campaign recipient identifier: "+ campaignRecipientIdentifier);

        if (!campaign.isScheduleSending()) {
            Campaign.Send send = new Campaign.Send();
            send.setPrimaryCampaign(true);
            send.setCampaignRecipientId(campaignRecipientIdentifier);
            send.setContactLevelSending(sendVO.isContactLevelSending());
            campaignService.sendCampaign(send);
            if (campaign.isNotifyUponCompletion()) {
                User user = new User();
                user.setId(campaign.getCreatedBy());
                user.setMergeTags(new ArrayList<>(Collections.singletonList(new User.MergeTag(MergeTagConstants.CAMPAIGN_NAME_MERGE_TAG, campaign.getName()))));
                userService.sendCampaignStartedNotification(user);
            }
        }else{
            Campaign.Schedule schedule = new Campaign.Schedule();
            if(campaign.isScheduledWithDelay()){
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.MINUTE,campaign.getDelayInMin());
                Date date = calendar.getTime();
                schedule.setSendingDate(DateUtil.getDateInYYMMDDFormat(date));
                schedule.setSendingTime(DateUtil.getDateInHHMM(date));
            }else {
                schedule.setSendingDate(campaign.getSendingDate());
                schedule.setSendingTime(campaign.getSendingTime());
            }
            schedule.setCampaignRecipientId(campaignRecipientIdentifier);
            schedule.setPrimaryCampaign(true);
            schedule.setContactLevelSending(sendVO.isContactLevelSending());
            User user = userService.getUser(sendVO.getUserId());
            schedule.setTimeZone(user.getTimeZone());
            campaignService.scheduleCampaign(schedule);
        }

        return campaignRecipientIdentifier;
    }


}
