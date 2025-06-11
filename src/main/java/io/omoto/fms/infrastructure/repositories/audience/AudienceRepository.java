package io.omoto.fms.infrastructure.repositories.audience;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import io.omoto.fms.commons.constants.Constants;
import io.omoto.fms.domains.audience.Audience;
import io.omoto.fms.domains.user.User;
import io.omoto.fms.infrastructure.entities.mongo.AudienceDocument;
import io.omoto.fms.infrastructure.entities.mongo.AudiencesDocument;
import io.omoto.fms.infrastructure.entities.mongo.CampaignTransactionDocument;
import io.omoto.fms.infrastructure.entities.mongo.ContactsDocument;
import io.omoto.fms.infrastructure.entities.mysql.AudienceUserDefinedFields;
import io.omoto.fms.infrastructure.repositories.campaign.CampaignRepository;
import io.omoto.fms.infrastructure.repositories.mongo.AudienceMongoRepository;
//import org.codehaus.jackson.map.ObjectMapper;

import io.omoto.fms.infrastructure.repositories.mongo.CampaignTransactionMongoRepository;
import io.omoto.fms.infrastructure.repositories.mongo.ContactsMongoRepository;
import io.omoto.fms.infrastructure.repositories.mysql.AudienceUserDefinedFieldsJpaRepository;
import io.omoto.fms.infrastructure.repositories.user.UsersRepository;
import io.omoto.fms.utils.CommonUtil;
import io.omoto.fms.utils.DateUtil;
import io.omoto.fms.utils.EncryptUtil;
import io.omoto.fms.utils.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

import static io.omoto.fms.commons.constants.Constants.CONTACT_QUALIFYING_INFO_GROUP_ID;
import static io.omoto.fms.commons.constants.MongoDBConstants.AUDIENCE_DOCUMENT_NAME;
import static io.omoto.fms.utils.StringUtils.isNumeric;


@Component
public class AudienceRepository {



    private static final Logger LOGGER = LoggerFactory.getLogger(AudienceRepository.class.getName());


    @Autowired
    private AudienceMongoRepository audienceMongoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AudienceUserDefinedFieldsJpaRepository audienceUserDefinedFieldsRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ContactsMongoRepository contactsMongoRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private EncryptUtil encryptUtil;

    @Autowired
    private CampaignTrigger campaignTrigger;


    @Autowired
    private AudiencesDocumentMongoRepository audiencesDocumentMongoRepository;

    @Autowired
    private CampaignTransactionMongoRepository campaignTransactionMongoRepository;

    private  List<ContactListener> contactListenersList = new ArrayList<>();

    public Audience saveDocument(Audience audience) {
        AudienceDocument audienceDocument = objectMapper.convertValue(audience, AudienceDocument.class);
        audienceDocument = audienceMongoRepository.save(audienceDocument);
        Audience audience1 = new Audience();
        audience1.setApiKey(audienceDocument.getApiKey());
        audience1.setAudienceId(audienceDocument.getId());
        return audience1;
    }

    public List<Audience.Bean> getAllAudienceOfAnAccount(Audience audienceBean) {
        User user = new User();
        user.setId(audienceBean.getUserId());
        String timeZone = usersRepository.getUser(user).getTimeZone();
        MongoCollection<Document> collection = mongoTemplate.getCollection(AUDIENCE_DOCUMENT_NAME);

        List<Document> pipeline = Arrays.asList(
                new Document()
                        .append("$match", new Document()
                                .append("accountId", audienceBean.getAccountId())
                        )/*,
                new Document()
                        .append("$addFields", new Document()
                                .append("contactsSize", new Document()
                                        .append("$size", "$contacts")
                                )
                        ),
                new Document()
                        .append("$project", new Document()
                                .append("contacts", 0)
                        )*/
        );

        AggregateIterable<Document> aggregate = collection.aggregate(pipeline);

        List<Audience.Bean> beanList = new ArrayList<>();
        for (Document document : aggregate) {
            Audience.Bean bean = new Audience.Bean();
            bean.setAccountId(document.getLong("accountId"));
            bean.setName(document.getString("audienceName"));
            bean.setDescription(document.getString("description"));
            Long contactsSize = contactsMongoRepository.countByAudienceIds(document.getObjectId("_id").toString());
            bean.setNoOfContacts(contactsSize);
            bean.setCreatedAt(DateUtil.getDateByTimeZone(document.get("createdAt"), timeZone).toString());
            bean.setUpdatedAt(DateUtil.getDateByTimeZone(document.get("updatedAt"), timeZone).toString());

            bean.setCampaigns(campaignRepository.getCampaignNamesByAudienceId(document.getObjectId("_id").toString(),document.getLong("accountId")));

            User createdUser= new User();
            createdUser.setId(document.getLong("createdBy"));
            User createdUserInfo = usersRepository.getUser(createdUser);
            bean.setCreatedBy(createdUserInfo.getFirstName()+" "+ StringUtils.notNull(createdUserInfo.getLastName()));
            bean.setAudienceId(document.get("_id").toString());
            bean.setPercentage(100);
            beanList.add(bean);
        }
        return beanList;
    }

    public Audience getByApiKey(String apiKey) {
        AudienceDocument audienceDocument = audienceMongoRepository.findByApiKey(apiKey);
        Audience audience = new Audience();
        audience.setAudienceId(audienceDocument.getId());
        return audience;
    }


    public String save(Audience audience) {
        LOGGER.info("Inserting the audiences document ");
        AudiencesDocument audiencesDocument = new AudiencesDocument();
        audiencesDocument.setAudienceName(audience.getName());
        audiencesDocument.setDescription(audience.getDescription());
        audiencesDocument.setCreatedBy(audience.getUserId());
        audiencesDocument.setUpdatedBy(audience.getUserId());
        audiencesDocument.setAccountId(audience.getAccountId());
        return audiencesDocumentMongoRepository.save(audiencesDocument).get_id();
    }

    public void saveAudienceMappedFields(List<Object> createdFields, Audience audience, List<Audience.MappedFields> mappedFields, String audienceId) {
        //todo remove this after below solution found efficient
        /*for (Audience.MappedFields mappedField : mappedFields) {
            if (createdFields.contains(mappedField.getMappedTo().trim())) {
                AudienceUserDefinedFields audienceUserDefinedFields = new AudienceUserDefinedFields();
                audienceUserDefinedFields.setAccountId(audience.getAccountId());
                audienceUserDefinedFields.setFieldName(mappedField.getField());
                audienceUserDefinedFields.setFieldDisplayName(mappedField.getMappedTo());
                audienceUserDefinedFields.setAudienceId(audienceId);
                try {
                    audienceUserDefinedFieldsRepository.save(audienceUserDefinedFields);
                }catch (DataIntegrityViolationException e){
                    continue;
                }
            }
        }*/

        for (Audience.MappedFields mappedField : mappedFields) {
            AudienceUserDefinedFields audienceUserDefinedFields = new AudienceUserDefinedFields();
            audienceUserDefinedFields.setAccountId(audience.getAccountId());
            audienceUserDefinedFields.setFieldName(mappedField.getField());
            audienceUserDefinedFields.setFieldDisplayName(mappedField.getMappedTo());
            audienceUserDefinedFields.setAudienceId(audienceId);
            try {
                audienceUserDefinedFieldsRepository.save(audienceUserDefinedFields);
            } catch (DataIntegrityViolationException e) {
                continue;
            }
        }

    }


    public Audience.ContactInfo getNonRespondedContacts(Audience audience) {
        Audience.ContactInfo contactInfo = new Audience.ContactInfo();
        MongoCollection<Document> collection = mongoTemplate.getCollection(AUDIENCE_DOCUMENT_NAME);
        List<Document> pipeline = Arrays.asList(new Document()
                .append("$match", new Document()
                        .append("_id", new ObjectId(audience.getAudienceId()))), new Document()
                .append("$unwind", "$contacts"), new Document()
                .append("$project", new Document().append("contacts", 1).append("_id", 0)));

        AggregateIterable<Document> aggregate1 = collection.aggregate(pipeline);
        List<Audience.ContactInfo> contacts = new ArrayList<>();

        List<Map> contactsListData = new ArrayList<>(contacts.size());
        for (Document document : aggregate1) {
            Map contactMap = new HashMap();
            Document contactDocument = (Document) document.get("contacts");
            contactDocument.entrySet().forEach(entry -> {
                contactMap.put(entry.getKey(), entry.getValue());
            });

            contactsListData.add(contactMap);
        }
        contactInfo.setContactsListData(contactsListData);
        return contactInfo;
    }



    public static boolean isPersonalInfoField(String field) {
        switch (field) {
            case Constants.FIRST_NAME_FIELD:
            case Constants.LAST_NAME_FIELD:
            case Constants.PHONE_FIELD:
            case Constants.CONTACT_EMAIL_FIELD:
            case Constants.REGISTRATION_ID_FIELD:
            case Constants.GENDER_FIELD:
                return true;
            default:
                return false;
        }

    }

    private void addContactListeners() {
        if (contactListenersList.isEmpty()) {
            contactListenersList.add(campaignTrigger);
        }
    }


    public void sendNewContactAddedEvent(ContactListenerVO contactListenerVO) {
        addContactListeners();
        for(ContactListener contactListener : contactListenersList){
            contactListener.process(contactListenerVO);
        }
    }


    private void insertCampaignTransaction(AudiencesDocument.ContactsEntity contactsEntity, String audienceId, String groupId) {
        CampaignTransactionDocument campaignTransactionDocument = objectMapper.convertValue(contactsEntity, CampaignTransactionDocument.class);
        campaignTransactionDocument.set_id(null);//to create new id value
        campaignTransactionDocument.setAudienceId(audienceId);
        campaignTransactionDocument.setContactsGroupId(groupId);
        campaignTransactionDocument.setContactIdentifier(contactsEntity.getIdentifier());
        campaignTransactionDocument.setEmail(contactsEntity.getEmail());
        campaignTransactionMongoRepository.save(campaignTransactionDocument);

    }


    public String saveContactAndUpdateAudience(Map contactInfoMap, Long accountId, Long userId, String audienceId) {
        LOGGER.debug("Saving contacts");
        ContactsDocument contactsDocument = new ContactsDocument();
        contactsDocument.setFirstName(((String) contactInfoMap.get(Constants.FIRST_NAME_FIELD)));
        contactsDocument.setLastName(((String) contactInfoMap.get(Constants.LAST_NAME_FIELD)));
        contactsDocument.setPhone(((String) contactInfoMap.get(Constants.PHONE_FIELD)));
        contactsDocument.setEmail(((String) contactInfoMap.get(Constants.CONTACT_EMAIL_FIELD)));
        contactsDocument.setRegistrationId(((String) contactInfoMap.get(Constants.REGISTRATION_ID_FIELD)));
        contactsDocument.setGender((String) contactInfoMap.get(Constants.GENDER_FIELD));
        contactsDocument.setAccountId(accountId);
        contactsDocument.setCreatedBy(userId);
        contactsDocument.setUpdatedBy(userId);
        if (contactInfoMap.containsKey(Constants.REGISTRATION_ID_FIELD) &&
                !((String) contactInfoMap.get(Constants.REGISTRATION_ID_FIELD)).equalsIgnoreCase(Constants.EMPTY_STRING)) {
            try {
                contactsDocument.setIdentifier(encryptUtil.encryptBase64(contactsDocument.getAccountId() + "_" + contactsDocument.getRegistrationId()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                contactsDocument.setIdentifier(encryptUtil.encryptBase64(contactsDocument.getAccountId() + "_" +
                        contactsDocument.getPhone() + "_" +
                        contactsDocument.getEmail()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<Map> qualifyingInfoMapList = new ArrayList<>();
        boolean isContactPresent = false;

        Set<String> audienceIds =new HashSet<>(1);
        audienceIds.add(audienceId);
        contactsDocument.setAudienceIds(audienceIds);
        try {
            contactsDocument = contactsMongoRepository.save(contactsDocument);
            LOGGER.debug("First time contact insertion");
        } catch (DataIntegrityViolationException e) {
            LOGGER.debug("Contact already present");
            contactsDocument = contactsMongoRepository.findByIdentifier(contactsDocument.getIdentifier());
            contactsDocument.getAudienceIds().add(audienceId);
            contactsMongoRepository.save(contactsDocument);
            isContactPresent = true;
        }

        if (isContactPresent) {
            qualifyingInfoMapList = contactsDocument.getQualifyingInfo();
        }

        Map qualifyingInfoMap = new HashMap();
        Iterator iterator = contactInfoMap.entrySet().iterator();
        Map.Entry pair;
        String groupId = CommonUtil.getUUID();
        qualifyingInfoMap.put(CONTACT_QUALIFYING_INFO_GROUP_ID, groupId);


        while (iterator.hasNext()) {
            pair = ((Map.Entry) iterator.next());
            if(isPersonalInfoField(pair.getKey().toString())){
                continue;
            }
            if (pair.getValue() == null) {
                continue;
            }
            if (isNumeric(pair.getValue().toString())) {
                qualifyingInfoMap.put(pair.getKey().toString(), Double.parseDouble(pair.getValue().toString()));
            } else {
                qualifyingInfoMap.put(pair.getKey().toString(), pair.getValue().toString());

            }
        }

        qualifyingInfoMapList.add(qualifyingInfoMap);
        contactsDocument.setQualifyingInfo(qualifyingInfoMapList);
        contactsDocument = contactsMongoRepository.save(contactsDocument);

        AudiencesDocument.ContactsEntity contactsEntity = new AudiencesDocument.ContactsEntity();
        contactsEntity.setFirstName(((String) contactInfoMap.get(Constants.FIRST_NAME_FIELD)));
        contactsEntity.setLastName(((String) contactInfoMap.get(Constants.LAST_NAME_FIELD)));
        contactsEntity.setPhone(((String) contactInfoMap.get(Constants.PHONE_FIELD)));
        contactsEntity.setEmail(((String) contactInfoMap.get(Constants.CONTACT_EMAIL_FIELD)));
        contactsEntity.setRegistrationId(((String) contactInfoMap.get(Constants.REGISTRATION_ID_FIELD)));
        contactsEntity.setGender((String) contactInfoMap.get(Constants.GENDER_FIELD));
        contactsEntity.setAccountId(accountId);
        contactsEntity.setCreatedBy(userId);
        contactsEntity.setUpdatedBy(userId);

        contactsEntity.setIdentifier(contactsDocument.getIdentifier());
        contactsEntity.setQualifyingInfo(qualifyingInfoMap);


        //todo remove this
        /*
        Query query = new Query(Criteria.where("_id").is(audienceId));
        Update update = new Update();
        update.push("contacts", contactsEntity);

        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, AudienceDocument.class);
        query = new Query(Criteria.where("audienceId").is(audienceId));
        UpdateResult updateResult2 = mongoTemplate.updateFirst(query, update, AudiencesDocument.class);
          */

        insertCampaignTransaction(contactsEntity, audienceId,groupId);

        ContactListenerVO contactListenerVO = new ContactListenerVO();
        contactListenerVO.setAccountId(accountId);
        contactListenerVO.setAudienceId(audienceId);
        contactListenerVO.setContactId(contactsDocument.get_id());
        contactListenerVO.setContactGroupId(groupId);
        sendNewContactAddedEvent(contactListenerVO);


        return contactsDocument.get_id();

    }

    public ContactsDocument getContactDocument(Audience audience){
        return  contactsMongoRepository.getById(audience.getContactId());
    }

    public List<AudienceUserDefinedFields> getUserDefinedFields(long accountId) {
        return audienceUserDefinedFieldsRepository.getByAccountId(accountId);
    }

    public void updateNameAndDescription(Audience audience) {
        MongoCollection<Document> collection = mongoTemplate.getCollection(AUDIENCE_DOCUMENT_NAME);
        Document updateDocument = new Document();
        Document updateValues = new Document();
        updateValues.append("audienceName", audience.getName());
        updateValues.append("description", audience.getDescription());
        updateDocument.append("$set", updateValues);
        Document searchQuery = new Document().append("_id", new ObjectId(audience.getAudienceId()));
        collection.updateOne(searchQuery, updateDocument);
    }




    public void deleteAudienceById(String audienceId) {
        MongoCollection<Document> collection = mongoTemplate.getCollection(AUDIENCE_DOCUMENT_NAME);
        Document document = new Document();
        document.append("_id", new ObjectId(audienceId));
        collection.deleteOne(document);

    }

    public void deleteAudienceByIdsList(List<String> audienceIdList) {
        if (Objects.isNull(audienceIdList)) {
            LOGGER.warn("Audiences list is  null");
            return;
        }

        List<ObjectId> objectIdList = new ArrayList<>(audienceIdList.size());
        audienceIdList.parallelStream().forEach(audienceId ->{
            objectIdList.add(new ObjectId(audienceId));
        });

        MongoCollection<Document> collection = mongoTemplate.getCollection(AUDIENCE_DOCUMENT_NAME);
        Document document = new Document();

        document.append("_id",new Document().append("$in",objectIdList));
        collection.deleteMany(document);

    }














}
