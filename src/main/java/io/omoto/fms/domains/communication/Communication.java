package io.omoto.fms.domains.communication;

import io.omoto.fms.domains.campaign.vo.Campaign;
import io.omoto.fms.domains.template.Template;

/**
 * Created by Venkatesh Gowda on 20/2/18.
 */
public class Communication {
    private String type;
    private Template template;
    private Campaign campaign;

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
}
