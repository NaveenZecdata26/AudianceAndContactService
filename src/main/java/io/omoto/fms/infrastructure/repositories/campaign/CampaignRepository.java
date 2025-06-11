package io.omoto.fms.infrastructure.repositories.campaign;

//import com.mongodb.client.AggregateIterable;
//import com.mongodb.client.MongoCollection;
//import io.omoto.fms.domains.campaign.vo.Campaign;
//import io.omoto.fms.domains.campaign.vo.CampaignTheme;
//import io.omoto.fms.domains.reports.filter.Filter;
//import io.omoto.fms.infrastructure.entities.mongo.*;
//import io.omoto.fms.infrastructure.entities.mysql.CampaignEntity;
//import io.omoto.fms.infrastructure.entities.mysql.AutoAudienceCampaignMapEntity;
//import io.omoto.fms.infrastructure.entities.mysql.CampaignTouchPointsEntity;
//import io.omoto.fms.infrastructure.exception.custom.DoesnotExists;
//import io.omoto.fms.infrastructure.repositories.mongo.CampaignTransactionMongoRepository;
//import io.omoto.fms.utils.CommonUtil;
//import org.bson.Document;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.type.TypeReference;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.omoto.fms.domains.campaign.vo.Campaign;
import io.omoto.fms.infrastructure.entities.mongo.CampaignDocument;
import io.omoto.fms.infrastructure.entities.mongo.CampaignRecipientsDocument;
import io.omoto.fms.infrastructure.entities.mongo.CampaignReminderDocument;
import io.omoto.fms.infrastructure.entities.mongo.CampaignTransactionDocument;
import io.omoto.fms.infrastructure.entities.mysql.AutoAudienceCampaignMapEntity;
import io.omoto.fms.infrastructure.exception.custom.DoesnotExists;
//import org.codehaus.jackson.map.ObjectMapper;
import io.omoto.fms.infrastructure.repositories.mongo.CampaignTransactionMongoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static io.omoto.fms.commons.constants.MongoDBConstants.CAMPAIGN_TRANSACTION_DOCUMENT_NAME;

@Component
public class CampaignRepository {

//    @Autowired
//    private CampaignTemplateMongoRepository campaignTemplateMongoRepository;
//
    @Autowired
    private CampaignMongoRepository campaignMongoRepository;

    @Autowired
    private CampaignRecipientsMongoRepository campaignRecipientsMongoRepository;

    @Autowired
    private CampaignTransactionMongoRepository campaignTransactionMongoRepository;


    //
//    @Autowired
//    private CampaignJpaRepository campaignJpaRepository;
//
//    @Autowired
//    private CampaignThemeRepository campaignThemeRepository;
//
//    @Autowired
//    private ReminderCampaignMongoRepository reminderCampaignMongoRepository;
//
//
//    @Autowired
//    private CampaignRecipientsMongoRepository campaignRecipientsMongoRepository;
//
   @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ReminderCampaignMongoRepository reminderCampaignMongoRepository;


    //
//    @Autowired
//    private CampaignTransactionMongoRepository campaignTransactionMongoRepository;
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
     @Autowired
     private AutoAudienceCampaignMapJpaRepository autoAudienceCampaignMapJpaRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignRepository.class.getName());

    //
//    @Autowired
//    private CampaignTouchPointsJpaRepository campaignTouchPointsJpaRepository;
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignRepository.class.getName());
//
//    public List<Campaign.Template> getAllTemplates(){
//        List<CampaignTemplateDocument> campaignTemplates = campaignTemplateMongoRepository.findAll();
//        return objectMapper.convertValue(campaignTemplates, new TypeReference<List<Campaign.Template>>() {});
//    }
//
//    public String saveCampaign(Campaign campaign) {
//        CampaignDocument campaignDocument = objectMapper.convertValue(campaign, CampaignDocument.class);
//        campaignDocument.setId(campaign.getCampaignId());
//        return campaignMongoRepository.save(campaignDocument).getId();
//    }
//
   public Campaign getCampaignById(Campaign campaign) {
        CampaignDocument document = campaignMongoRepository.findById(campaign.getCampaignId()).orElse(null);
        if (document != null) {
            campaign = objectMapper.convertValue(document, Campaign.class);
            campaign.setCampaignId(document.getId());
            return campaign;
        }else{
            throw DoesnotExists.supplier("Campaign doesn't exists","getCampaignById","Get a campaign by its id").get();
        }
    }



    public Campaign.ReminderCampaign getReminderCampaignById(String reminderCampaignId) {
        Optional<CampaignReminderDocument> reminderDocument = reminderCampaignMongoRepository.findById(reminderCampaignId);
        return reminderDocument.map(campaignReminderDocument -> objectMapper.convertValue(campaignReminderDocument, Campaign.ReminderCampaign.class)).orElse(null);
    }


    public Long saveAutoAudienceCampaignMap(Campaign.AutoAudienceCampaignMap autoAudienceCampaignMap) {
        AutoAudienceCampaignMapEntity autoAudienceCampaignMapEntity = new AutoAudienceCampaignMapEntity();
        autoAudienceCampaignMapEntity.setAccountId(autoAudienceCampaignMap.getAccountId());
        autoAudienceCampaignMapEntity.setAudienceId(autoAudienceCampaignMap.getAudienceId());
        autoAudienceCampaignMapEntity.setCampaignId(autoAudienceCampaignMap.getCampaignId());
        autoAudienceCampaignMapEntity.setSurveyId(autoAudienceCampaignMap.getSurveyId());
        return autoAudienceCampaignMapJpaRepository.save(autoAudienceCampaignMapEntity).getId();

    }


//
//    public long createCampaign(Campaign campaign) {
//        CampaignEntity campaignEntity = new CampaignEntity();
//        campaignEntity.setAccountId(campaign.getAccountId());
//        campaignEntity.setDocumentId(campaign.getCampaignId());
//        campaignEntity.setName(campaign.getName());
//        campaignEntity.setType("NPS");
//        return campaignJpaRepository.save(campaignEntity).getId();
//
//    }
//
//    public CampaignTheme getCampaignTheme(Campaign campaign){
//        return objectMapper.convertValue(campaignThemeRepository.findById(campaign.getThemeId()).orElse(null), CampaignTheme.class);
//    }
//
//    public List<Campaign> getAllCampaignsByAccountId(Campaign campaign) {
//        List<CampaignDocument> campaignDocuments = campaignMongoRepository.findByAccountId(campaign.getAccountId());
//        return objectMapper.convertValue(campaignDocuments, new TypeReference<List<Campaign>>() {});
//    }



    public List<CampaignTransactionDocument> getCampaignTransactionByAudienceId(String audienceId) {
        return campaignTransactionMongoRepository.findByAudienceId(audienceId);
    }

    public String saveCampaignRecipients(Campaign campaign) {
        CampaignRecipientsDocument campaignRecipientsDocument = new CampaignRecipientsDocument();
        campaignRecipientsDocument.setId(campaign.getCampaignRecipientId());
        campaignRecipientsDocument.setAccountId(campaign.getAccountId());
        campaignRecipientsDocument.setUserId(campaign.getUserId());
        campaignRecipientsDocument.setCampaignDocumentId(campaign.getCampaignId());
        campaignRecipientsDocument.setReminderCampaignDocumentId(campaign.getReminderCampaignId());
        campaignRecipientsDocument.setSurveyDocumentId(campaign.getSurveyId());
        campaignRecipientsDocument.setAudiences(campaign.getAudiences());
        campaignRecipientsDocument.setNumberOfReminder(campaign.getNumberOfReminder());
        campaignRecipientsDocument.setNumberOfReminderSent(campaign.getNumberOfReminderSent());
        campaignRecipientsDocument.setReminderInterval(campaign.getReminderInterval());
        campaignRecipientsDocument.setContactId(campaign.getContactId());
        return campaignRecipientsMongoRepository.save(campaignRecipientsDocument).getId();
    }


    public void updateContactTransactionStatus(Campaign campaign,String groupId, String contactIdentifier,String channel,String status,String sendStatus) {
        LOGGER.debug("Group id is : {}, Contact identifier : {} ",groupId,contactIdentifier);
        CampaignTransactionDocument campaignTransactionDocument = campaignTransactionMongoRepository.getByGroupIdAndContactIdentifier(groupId, contactIdentifier);
        campaignTransactionDocument.setCampaignDocumentId(campaign.getCampaignId());
        campaignTransactionDocument.setSurveyDocumentId(campaign.getSurveyId());
        campaignTransactionDocument.setChannel(channel);
        campaignTransactionDocument.setStatus(status);
        campaignTransactionDocument.setSendStatus(sendStatus);
        campaignTransactionMongoRepository.save(campaignTransactionDocument);
    }


    //    public String saveReminderCampaign(Campaign.ReminderCampaign reminderCampaign) {
//        CampaignReminderDocument campaignReminderDocument = objectMapper.convertValue(reminderCampaign, CampaignReminderDocument.class);
//        campaignReminderDocument.setId(reminderCampaign.getReminderCampaignId());
//        return reminderCampaignMongoRepository.save(campaignReminderDocument).getId();
//    }
//
//    public Campaign.ReminderCampaign getReminderCampaignById(String reminderCampaignId) {
//        Optional<CampaignReminderDocument> reminderDocument = reminderCampaignMongoRepository.findById(reminderCampaignId);
//        return reminderDocument.map(campaignReminderDocument -> objectMapper.convertValue(campaignReminderDocument, Campaign.ReminderCampaign.class)).orElse(null);
//    }
//
//    public List<String> getAudienceFromCampaignRecipients(Campaign campaign) {
//        Optional<CampaignRecipientsDocument> campaignRecipientsDocument = campaignRecipientsMongoRepository.findById(campaign.getCampaignRecipientId());
//        return campaignRecipientsDocument.map(CampaignRecipientsDocument::getAudiences).orElse(null);
//    }
//
    public Campaign getCampaignRecipientsById(String campaignRecipientId) {
        Optional<CampaignRecipientsDocument> campaignRecipientsOptional = campaignRecipientsMongoRepository.findById(campaignRecipientId);
        if (campaignRecipientsOptional.isPresent()) {
            Campaign campaign = objectMapper.convertValue(campaignRecipientsOptional.get(), Campaign.class);
            campaign.setCampaignRecipientId(campaignRecipientId);
            campaign.setCampaignId(campaignRecipientsOptional.get().getCampaignDocumentId());
            campaign.setSurveyId(campaignRecipientsOptional.get().getSurveyDocumentId());
            campaign.setContactId(campaignRecipientsOptional.get().getContactId());
            return campaign;
        }else return null;

    }
//
//
//    public void updateContactTransaction(Campaign campaign,String groupId, String contactIdentifier,String channel) {
//        LOGGER.debug("Group id is : {}, Contact identifier : {} ",groupId,contactIdentifier);
//        CampaignTransactionDocument campaignTransactionDocument = campaignTransactionMongoRepository.getByGroupIdAndContactIdentifier(groupId, contactIdentifier);
//        campaignTransactionDocument.setCampaignDocumentId(campaign.getCampaignId());
//        campaignTransactionDocument.setSurveyDocumentId(campaign.getSurveyId());
//        campaignTransactionDocument.setChannel(channel);
//        campaignTransactionMongoRepository.save(campaignTransactionDocument);
//    }
//
//    public void updateContactTransactionStatus(Campaign campaign,String groupId, String contactIdentifier,String channel,String status,String sendStatus) {
//        LOGGER.debug("Group id is : {}, Contact identifier : {} ",groupId,contactIdentifier);
//        CampaignTransactionDocument campaignTransactionDocument = campaignTransactionMongoRepository.getByGroupIdAndContactIdentifier(groupId, contactIdentifier);
//        campaignTransactionDocument.setCampaignDocumentId(campaign.getCampaignId());
//        campaignTransactionDocument.setSurveyDocumentId(campaign.getSurveyId());
//        campaignTransactionDocument.setChannel(channel);
//        campaignTransactionDocument.setStatus(status);
//        campaignTransactionDocument.setSendStatus(sendStatus);
//        campaignTransactionMongoRepository.save(campaignTransactionDocument);
//    }
//
//
//
//    public List<CampaignTransactionDocument> getByContactIdentifier(String contactIdentifier){
//        return campaignTransactionMongoRepository.getByContactIdentifier(contactIdentifier);
//    }
//
//    public CampaignTransactionDocument getByContactIdentifierAndResponseIdentifier(String responseIdentifier,String contactIdentifier){
//        return campaignTransactionMongoRepository.getByRespondentAndContactIdentifier(responseIdentifier,contactIdentifier);
//    }
//
//    public boolean deleteCampaignTransaction(String responseId,String surveyDocumentId) {
//        LOGGER.info("Deleting the Campaign transaction with responseId : {}  ",responseId);
//        CampaignTransactionDocument campaignTransactionDocument = campaignTransactionMongoRepository.getByResponseIdAndSurveyDocumentId(responseId,surveyDocumentId);
//        if(campaignTransactionDocument == null){
//            return false;
//        }
//        campaignTransactionMongoRepository.delete(campaignTransactionDocument);
//        return true;
//    }
//
//    public boolean favouriteCampaignTransaction(String responseId, String surveyDocumentId, Boolean favorite) {
//        CampaignTransactionDocument campaignTransactionDocument = campaignTransactionMongoRepository.getByResponseIdAndSurveyDocumentId(responseId,surveyDocumentId);
//        campaignTransactionDocument.setFavourite(favorite);
//        campaignTransactionMongoRepository.save(campaignTransactionDocument);
//        return true;
//    }
//
//    public List<CampaignTransactionDocument> getResponseReceivedCampaignTransactionByContactIdentifier(String contactIdentifier){
//        return campaignTransactionMongoRepository.getByContactIdentifierAndResponseReceived(contactIdentifier);
//    }
//
//    public boolean addTagToCampaignTransaction(String responseId, String surveyDocumentId, String tag) {
//        LOGGER.info("Response id : {} ,Survey Document id : {} , Tag : {}  ",responseId,surveyDocumentId,tag);
//        CampaignTransactionDocument campaignTransactionDocument = campaignTransactionMongoRepository.getByResponseIdAndSurveyDocumentId(responseId,surveyDocumentId);
//        if (campaignTransactionDocument.getTags() == null) {
//            Set<String> tags= new HashSet<>(1);
//            tags.add(tag);
//            campaignTransactionDocument.setTags(tags);
//        }else {
//            campaignTransactionDocument.getTags().add(tag);
//        }
//        campaignTransactionMongoRepository.save(campaignTransactionDocument);
//        return true;
//    }
//
//    public boolean deleteTagFromCampaignTransaction(String responseId, String surveyDocumentId, String tag) {
//        CampaignTransactionDocument campaignTransactionDocument = campaignTransactionMongoRepository.getByResponseIdAndSurveyDocumentId(responseId,surveyDocumentId);
//        if (campaignTransactionDocument.getTags() == null) {
//            return false;
//        }
//        campaignTransactionDocument.getTags().remove(tag);
//        campaignTransactionMongoRepository.save(campaignTransactionDocument);
//        return true;
//    }
//
//
//    public Long saveAutoAudienceCampaignMap(Campaign.AutoAudienceCampaignMap autoAudienceCampaignMap) {
//        AutoAudienceCampaignMapEntity autoAudienceCampaignMapEntity = new AutoAudienceCampaignMapEntity();
//        autoAudienceCampaignMapEntity.setAccountId(autoAudienceCampaignMap.getAccountId());
//        autoAudienceCampaignMapEntity.setAudienceId(autoAudienceCampaignMap.getAudienceId());
//        autoAudienceCampaignMapEntity.setCampaignId(autoAudienceCampaignMap.getCampaignId());
//        autoAudienceCampaignMapEntity.setSurveyId(autoAudienceCampaignMap.getSurveyId());
//        return autoAudienceCampaignMapJpaRepository.save(autoAudienceCampaignMapEntity).getId();
//
//    }
//
//    public Campaign.AutoAudienceCampaignMap getAutoAudienceCampaignMapByAccountIdAudienceIdAndCampaignId(Campaign.AutoAudienceCampaignMap autoAudienceCampaignMap) {
//        AutoAudienceCampaignMapEntity autoAudienceCampaignMapEntity =  autoAudienceCampaignMapJpaRepository.getByAccountIdAudienceIdAndCampaignId(autoAudienceCampaignMap.getAccountId(), autoAudienceCampaignMap.getAudienceId(), autoAudienceCampaignMap.getCampaignId());
//        return objectMapper.convertValue(autoAudienceCampaignMapEntity, Campaign.AutoAudienceCampaignMap.class);
//
//    }
//
    public List<Campaign.AutoAudienceCampaignMap> getAutoAudienceCampaignMapByAccountIdAudienceId(Campaign.AutoAudienceCampaignMap autoAudienceCampaignMap) {
        List<AutoAudienceCampaignMapEntity> audienceCampaignMapEntityList = autoAudienceCampaignMapJpaRepository.getByAccountIdAudienceId(autoAudienceCampaignMap.getAccountId(), autoAudienceCampaignMap.getAudienceId());
        List<Campaign.AutoAudienceCampaignMap> autoAudienceCampaignMapList = new ArrayList<>(audienceCampaignMapEntityList.size());
        audienceCampaignMapEntityList.forEach(autoAudienceCampaignMapEntity -> {
            autoAudienceCampaignMapList.add(objectMapper.convertValue(autoAudienceCampaignMapEntity, Campaign.AutoAudienceCampaignMap.class));
        });
        return autoAudienceCampaignMapList;

    }
//
//
//    public List<String> getCampaignTouchPoints(String touchPointType){
//        List<CampaignTouchPointsEntity> campaignTouchPointsEntityList = campaignTouchPointsJpaRepository.getByTouchPointType(touchPointType);
//        List<String> touchPointsList = new ArrayList<>(campaignTouchPointsEntityList.size());
//        campaignTouchPointsEntityList.forEach(campaignTouchPointsEntity -> {
//            touchPointsList.add(campaignTouchPointsEntity.getTouchPoint());
//        });
//        return touchPointsList;
//    }
//
//
//    public boolean updateImpression(Campaign campaign) {
//        CampaignDocument campaignDocument = campaignMongoRepository.findById(campaign.getCampaignId()).orElse(null);
//        assert campaignDocument != null;
//        CampaignDocument.Popup popup = campaignDocument.getPopup();
//        popup.setNumberOfImpressions(popup.getNumberOfImpressions()+1);
//        campaignMongoRepository.save(campaignDocument);
//        return true;
//
//    }
//
//    public boolean updatePopupClicks(Campaign campaign) {
//        CampaignDocument campaignDocument = campaignMongoRepository.findById(campaign.getCampaignId()).orElse(null);
//        assert campaignDocument != null;
//        CampaignDocument.Popup popup = campaignDocument.getPopup();
//        popup.setClicks(popup.getClicks()+1);
//        campaignMongoRepository.save(campaignDocument);
//        return true;
//    }

    public List<String> getCampaignNamesByAudienceId(String audienceId, Long accountId) {
        List<AutoAudienceCampaignMapEntity> autoAudienceCampaignMapEntityList = autoAudienceCampaignMapJpaRepository.getByAccountIdAudienceId(accountId, audienceId);
        if (Objects.isNull(autoAudienceCampaignMapEntityList)) {
            return  new ArrayList<>(1);
        }
        List<String> campaignNameList = new ArrayList<>(autoAudienceCampaignMapEntityList.size());
        autoAudienceCampaignMapEntityList.parallelStream().forEach(autoAudienceCampaignMapEntity -> {
            Campaign campaign = new Campaign();
            campaign.setCampaignId(autoAudienceCampaignMapEntity.getCampaignId());
            campaignNameList.add(getCampaignById(campaign).getName());
        });
        return campaignNameList;
    }


    public void updateContactTransaction(Campaign campaign,String groupId, String contactIdentifier,String channel) {
        LOGGER.debug("Group id is : {}, Contact identifier : {} ",groupId,contactIdentifier);
        CampaignTransactionDocument campaignTransactionDocument = campaignTransactionMongoRepository.getByGroupIdAndContactIdentifier(groupId, contactIdentifier);
        campaignTransactionDocument.setCampaignDocumentId(campaign.getCampaignId());
        campaignTransactionDocument.setSurveyDocumentId(campaign.getSurveyId());
        campaignTransactionDocument.setChannel(channel);
        campaignTransactionMongoRepository.save(campaignTransactionDocument);
    }


//    public long getEmailCampaignOpenCount(Campaign campaign) {
//        MongoCollection<Document> collection = mongoTemplate.getCollection(CAMPAIGN_TRANSACTION_DOCUMENT_NAME);
//        List<Document> pipeline = Arrays.asList(new Document()
//                .append("$match", new Document()
//                        .append("campaignDocumentId", campaign.getCampaignId())
//                        .append("sendStatus", "OPEN")), new Document()
//                .append("$count", "numberOfOpen"));
//
//        AggregateIterable<Document> aggregate = collection.aggregate(pipeline);
//        for (Document document : aggregate) {
//            return Long.valueOf(document.getInteger("numberOfOpen"));//There will be always only one result so getting the first document from list
//        }
//        return 0;
//    }
//
//    public long getResponseCount(Campaign campaign) {
//        MongoCollection<Document> collection = mongoTemplate.getCollection(CAMPAIGN_TRANSACTION_DOCUMENT_NAME);
//        List<Document> pipeline = Arrays.asList(new Document()
//                .append("$match", new Document()
//                        .append("campaignDocumentId", campaign.getCampaignId())
//                        .append("isResponseReceived", true)), new Document()
//                .append("$count", "numberOfResponses"));
//
//        AggregateIterable<Document> aggregate = collection.aggregate(pipeline);
//        for (Document document : aggregate) {
//            return Long.valueOf(document.getInteger("numberOfResponses"));//There will be always only one result so getting the first document from list
//        }
//        return 0;
//    }
//
//    public List<Campaign> getCampaignsBySurveyId(Campaign campaign){
//        List<AutoAudienceCampaignMapEntity> autoAudienceCampaignMapEntityList = autoAudienceCampaignMapJpaRepository.findByAccountIdAndSurveyId(campaign.getAccountId(), campaign.getSurveyId());
//        List<Campaign> campaignsList = new ArrayList<>(autoAudienceCampaignMapEntityList.size());
//        for (AutoAudienceCampaignMapEntity autoAudienceCampaignMapEntity : autoAudienceCampaignMapEntityList) {
//            Campaign campaign1 = new Campaign();
//            campaign1.setCampaignId(autoAudienceCampaignMapEntity.getCampaignId());
//            campaignsList.add(getCampaignById(campaign1));
//        }
//        return campaignsList;
//    }
//
//    public Campaign getCampaignInfo(Campaign campaign) {
//        List<CampaignDocument> campaignDocumentList;
//        if(!Objects.isNull(campaign.getFilter()) && !Objects.isNull(campaign.getFilter().getFilters())){
//            List<Filter.FiltersEntity> filters = campaign.getFilter().getFilters();
//            String channelValue = filters.get(0).getValue();
//            campaignDocumentList = campaignMongoRepository.findByAccountIdAndChannel(campaign.getAccountId(),channelValue);
//        }else {
//            campaignDocumentList = campaignMongoRepository.findByAccountId(campaign.getAccountId());
//        }
//        Campaign campaignResult = new Campaign();
//        if(Objects.isNull(campaignDocumentList)){
//            LOGGER.warn("Campaign document list is empty : for account Id : {} ",campaign.getAccountId());
//            Campaign.CampaignInfo emptyCampaignInfo = new Campaign.CampaignInfo();
//            List<Campaign.CampaignInfo.CampaignData> emptyCampaignData = new ArrayList<>(1);
//            emptyCampaignInfo.setCampaignDataList(emptyCampaignData);
//            campaignResult.setCampaignInfo(emptyCampaignInfo);
//            return campaignResult;
//        }
//
//
//        Campaign.CampaignInfo campaignInfo = new Campaign.CampaignInfo();
//        List<Campaign.CampaignInfo.CampaignData> campaignDataList = new ArrayList<>(campaignDocumentList.size());
//        campaignDocumentList.parallelStream().forEach(campaignDocument -> {
//            Campaign.CampaignInfo.CampaignData campaignData = new Campaign.CampaignInfo.CampaignData();
//            campaignData.setAccountId(campaignDocument.getAccountId());
//            campaignData.setCampaignId(campaignDocument.getId());
//            campaignData.setCampaignName(campaignDocument.getName());
//            campaignData.setChannel(campaignDocument.getChannel());
//
//            //Todo this is for testing, Need to add real logic here
//            campaignData.setRecipients(CommonUtil.getRandomNumberBetween10000To12000());
//            campaignData.setDelivered(CommonUtil.getRandomNumberBetween0To1000());
//            campaignData.setDeliveryRate(CommonUtil.getRandomNumberBetween0To100() + "% delivery rate");
//            campaignData.setOpened(CommonUtil.getRandomNumberBetween0To1000());
//            campaignData.setOpenRate(CommonUtil.getRandomNumberBetween0To100() + "% open rate");
//            campaignData.setClicked(CommonUtil.getRandomNumberBetween0To1000());
//            campaignData.setClickedRate(CommonUtil.getRandomNumberBetween0To100() + "% click rate");
//
//            campaignData.setResponded(CommonUtil.getRandomNumberBetween0To1000());
//            campaignData.setRespondedRate(CommonUtil.getRandomNumberBetween0To100() + "% resp. rate");
//            campaignData.setFailed(CommonUtil.getRandomNumberBetween0To1000());
//            campaignData.setFailedRate(CommonUtil.getRandomNumberBetween0To100() + "% failure rate");
//
//            //End of todo
//
//            campaignDataList.add(campaignData);
//
//        });
//
//        campaignInfo.setCampaignDataList(campaignDataList);
//        campaignResult.setCampaignInfo(campaignInfo);
//        return campaignResult;
//    }
//
//    public boolean deleteCampaign(Campaign campaign) {
//        campaignMongoRepository.deleteByIdIn(campaign.getCampaignIds());
//        return true;
//    }
//
//    public List<CampaignTransactionDocument> getCampaignTransactionByAudienceId(String audienceId) {
//        return campaignTransactionMongoRepository.findByAudienceId(audienceId);
//    }
}
