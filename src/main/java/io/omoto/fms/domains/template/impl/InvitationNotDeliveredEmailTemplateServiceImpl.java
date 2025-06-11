package io.omoto.fms.domains.template.impl;

import io.omoto.fms.commons.constants.SubjectConstants;
import io.omoto.fms.commons.constants.TemplateConstants;
import io.omoto.fms.domains.template.Template;
import io.omoto.fms.domains.template.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import java.util.List;

import static io.omoto.fms.commons.constants.TemplateConstants.OMOTO_LEVEL_1_EMAIL;

/**
 * Created by Venkatesh Gowda on 21/2/18.
 */
@Component
public class InvitationNotDeliveredEmailTemplateServiceImpl implements TemplateService{

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Override
    public Template getTemplate(Template template) {
        template.setTemplateContent(getTemplateContent(template));
        template.setSubject(getSubject(template.getMergeTags()));
        template.setFromEmail(OMOTO_LEVEL_1_EMAIL);
        return template;
    }

    private String getSubject(List<Template.MergeTag> mergeTags){
        String subject = SubjectConstants.INVITATION_NOT_DELIVERED_EMAIL;
        for (Template.MergeTag tag : mergeTags) {
            subject = subject.replace(tag.getKey(), tag.getValue());
        }
        return subject;
    }

    private String getTemplateContent(Template template){
        Context context = new Context();
        String templateContent = templateEngine.process(TemplateConstants.INVITATION_NOT_DELIVERED_EMAIL_TEMPLATE_HTML_FILE_NAME, context);
        for (Template.MergeTag mergeTag : template.getMergeTags()) {
            templateContent = templateContent.replace(mergeTag.getKey(),mergeTag.getValue());
        }
        return templateContent;
    }
}
