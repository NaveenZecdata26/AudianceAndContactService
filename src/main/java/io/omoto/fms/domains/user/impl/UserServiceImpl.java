package io.omoto.fms.domains.user.impl;


import io.omoto.fms.commons.constants.CampaignConstants;
import io.omoto.fms.commons.constants.MergeTagConstants;
import io.omoto.fms.commons.constants.TemplateConstants;
import io.omoto.fms.domains.communication.Communication;
import io.omoto.fms.domains.communication.CommunicationService;
import io.omoto.fms.domains.communication.factory.CommunicationFactory;
import io.omoto.fms.domains.template.Template;
import io.omoto.fms.domains.template.TemplateService;
import io.omoto.fms.domains.template.factory.TemplatesFactory;
import io.omoto.fms.domains.user.User;
import io.omoto.fms.domains.user.UserService;
import io.omoto.fms.infrastructure.repositories.user.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UsersRepository userRepository;


    @Autowired
    private TemplatesFactory templateFactory;

    @Autowired
    private CommunicationFactory communicationFactory;






    @Override
    public User getUser(Long userId) {
        User user = new User();
        user.setId(userId);
        return userRepository.getUser(user);
    }

    @Override
    public String sendCampaignStartedNotification(User user) {
        user = userRepository.getUser(user);
        List<Template.MergeTag> mergeTags = new ArrayList<>();
        mergeTags.add(new Template.MergeTag(MergeTagConstants.FIRST_NAME,user.getFirstName()));
        for (User.MergeTag mergeTag : user.getMergeTags()) {
            mergeTags.add(new Template.MergeTag(mergeTag.getKey(),mergeTag.getValue()));
        }
        Template template = new Template();
        template.setMergeTags(mergeTags);
        template.setEmail(user.getEmail());
        TemplateService templateService = templateFactory.getTemplate(TemplateConstants.CAMPAIGN_STARTED_EMAIL_TEMPLATE_HTML_FILE_NAME);
        Communication communication = new Communication();
        communication.setType(CampaignConstants.CHANNEL_MAIL);
        communication.setTemplate(templateService.getTemplate(template));
        CommunicationService communicationService = communicationFactory.provides(communication.getType());
        return communicationService.send(communication);
    }




}
