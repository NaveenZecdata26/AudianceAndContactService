package io.omoto.fms.commons.constants;

/**
 * Created by Ashwin Thakre on 15/2/18.
 */
public class CampaignConstants {

    private CampaignConstants() {
    }

    public static final String CAMPAIGN_TYPE_MAIL="mail";
    public static final String CAMPAIGN_TYPE_SMS="sms";
    public static final String CAMPAIGN_TYPE_POPUP="popup";

    public static final String CHANNEL_MAIL ="mail";
    public static final String CHANNEL_SMS ="sms";
    public static final String CHANNEL_POPUP ="popup";

    //mail send status
    public static final String CAMPAIGN_CHANNEL_MAIL_STATUS_SUCCESS="success";
    public static final String CAMPAIGN_CHANNEL_MAIL_STATUS_FAILED="failed";
}
