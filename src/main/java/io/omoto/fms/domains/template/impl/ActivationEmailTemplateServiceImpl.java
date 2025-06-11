package io.omoto.fms.domains.template.impl;

import io.omoto.fms.domains.template.Template;
import io.omoto.fms.domains.template.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * Created by Venkatesh Gowda on 21/2/18.
 */
@Service
public class ActivationEmailTemplateServiceImpl implements TemplateService {

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Override
    public Template getTemplate(Template template) {
        Context context = new Context();
        String templateContent = templateEngine.process(template.getTemplateHtmlFileName(), context);

        for(Template.MergeTag mergeTag: template.getMergeTags()){
            templateContent = templateContent.replace(mergeTag.getKey(), mergeTag.getValue());
        }
        template.setTemplateContent(templateContent);
        return template;
    }
}
