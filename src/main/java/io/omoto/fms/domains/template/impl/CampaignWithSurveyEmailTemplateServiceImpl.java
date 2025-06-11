package io.omoto.fms.domains.template.impl;

import io.omoto.fms.domains.template.Template;
import io.omoto.fms.domains.template.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * Created by Ashwin Thakre on 15/2/18.
 */

@Component
public class CampaignWithSurveyEmailTemplateServiceImpl implements TemplateService{

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Override
    public Template getTemplate(Template template) {
        Context context = new Context();
        String templateContent = templateEngine.process(template.getTemplateHtmlFileName(), context);
        template.setTemplateContent(templateContent);
        return template;
    }
}
