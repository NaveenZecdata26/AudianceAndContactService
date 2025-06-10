package io.omoto.fms.infrastructure.repositories.audience;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import io.omoto.fms.api.rest.v3.vo.ViewContactProjection;
import io.omoto.fms.domains.audience.Audience;
import io.omoto.fms.infrastructure.entities.mongo.AudienceDocument;
import io.omoto.fms.infrastructure.entities.mysql.AudienceUserDefinedFields;
import io.omoto.fms.infrastructure.repositories.mongo.AudienceMongoRepository;
import io.omoto.fms.infrastructure.repositories.mongo.ContactsMongoRepository;
import io.omoto.fms.infrastructure.repositories.mysql.AudienceUserDefinedFieldsJpaRepository;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

import static io.omoto.fms.commons.constants.MongoDBConstants.AUDIENCE_DOCUMENT_NAME;

@Component
public class AudienceRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(AudienceRepository.class.getName());

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private AudienceUserDefinedFieldsJpaRepository audienceUserDefinedFieldsRepository;
    @Autowired
    private ContactsMongoRepository contactsMongoRepository;
    @Autowired
    private AudienceMongoRepository audienceMongoRepository;

    public Audience saveDocument(Audience audience) {
        AudienceDocument audienceDocument = objectMapper.convertValue(audience, AudienceDocument.class);
        audienceDocument = audienceMongoRepository.save(audienceDocument);
        Audience audience1 = new Audience();
        audience1.setApiKey(audienceDocument.getApiKey());
        audience1.setAudienceId(audienceDocument.getId());
        return audience1;
    }

    public Audience.ContactInfo getContactInfo(Audience audience) {
        Audience.ContactInfo contactInfo = new Audience.ContactInfo();
        MongoCollection<Document> collection = mongoTemplate.getCollection(AUDIENCE_DOCUMENT_NAME);
        List<Document> pipeline = Arrays.asList(new Document()
                .append("$match", new Document()
                        .append("_id", new ObjectId(audience.getAudienceId()))), new Document()
                .append("$unwind", "$contacts"), new Document()
                .append("$project", new Document().append("contacts", 1).append("_id", 0)), new Document()
                .append("$skip", 0), new Document()
                .append("$limit", 100));

        AggregateIterable<Document> aggregate1 = collection.aggregate(pipeline);
        List<Audience.ContactInfo> contacts = new ArrayList<>();

        List<Map> contactsListData = new ArrayList<>(contacts.size());
        for (Document document : aggregate1) {
            Map contactMap = new HashMap();
            Document contactDocument = (Document) document.get("contacts");
            contactDocument.entrySet().forEach(entry -> {
                if (entry.getKey().equalsIgnoreCase("qualifyingInfo")) {
                    Document qualifyingInfo = (Document) entry.getValue();
                    qualifyingInfo.entrySet().forEach(qualifyingInfoEntry -> {
                        contactMap.put(qualifyingInfoEntry.getKey(), qualifyingInfoEntry.getValue());
                    });
                } else {
                    contactMap.put(entry.getKey(), entry.getValue());
                }

            });
            contactsListData.add(contactMap);
        }
        contactInfo.setContactsListData(contactsListData);
        return contactInfo;
    }

    public List<AudienceUserDefinedFields> getUserDefinedFields(Audience audience) {
        return audienceUserDefinedFieldsRepository.getByAccountIdAndAudienceId(audience.getAccountId(), audience.getAudienceId());
    }

    public Audience.ContactInformation getContactInfoByAudience(Audience audience) {
        Audience.ContactInformation contactInfo = new Audience.ContactInformation();
        MongoCollection<Document> collection = mongoTemplate.getCollection(AUDIENCE_DOCUMENT_NAME);
        List<Document> pipeline = Arrays.asList(new Document()
                .append("$match", new Document()
                        .append("_id", new ObjectId(audience.getAudienceId()))), new Document()
                .append("$unwind", "$contacts"), new Document()
                .append("$project", new Document().append("contacts", 1).append("_id", 0)), new Document()
                .append("$skip", 0), new Document()
                .append("$limit", 100));

        List<ViewContactProjection> viewContactProjections = contactsMongoRepository.findByAudienceId(audience.getAudienceId(), audience.getAccountId());
        contactInfo.setContactsListData(viewContactProjections);
        contactInfo.setTotalRecords(viewContactProjections.size());
        return contactInfo;
    }

}
