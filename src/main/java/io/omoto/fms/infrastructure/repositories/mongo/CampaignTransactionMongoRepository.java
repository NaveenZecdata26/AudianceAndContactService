package io.omoto.fms.infrastructure.repositories.mongo;

import io.omoto.fms.infrastructure.entities.mongo.CampaignTransactionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignTransactionMongoRepository extends MongoRepository<CampaignTransactionDocument, String> {

    @Query(value = "{ 'contactsGroupId' : ?0 , 'identifier' : ?1 }")
    CampaignTransactionDocument getByGroupIdAndContactIdentifier(String groupId,String identifier);

    @Query(value = "{ 'contactIdentifier' : ?0 }")
    List<CampaignTransactionDocument> getByContactIdentifier(String identifier);

    @Query(value = "{ 'contactsGroupId' : ?0 }")
    CampaignTransactionDocument getByGroupId(String groupId);

    @Query(value = "{ 'contactsGroupId' : ?0 , 'contactIdentifier' : ?1 }")
    CampaignTransactionDocument getByRespondentAndContactIdentifier(String groupId,String identifier);

    @Query(value = "{ 'contactIdentifier' : ?0, 'isResponseReceived' : true }")
    List<CampaignTransactionDocument> getByContactIdentifierAndResponseReceived(String identifier);

    // @Query(value = "{ 'responseId' : ?0 , 'surveyDocumentId' : ?1 }")
    CampaignTransactionDocument getByResponseIdAndSurveyDocumentId(String responseId,String surveyDocumentId);


    //  Optional<CampaignTransactionDocument> findByResponseIdAndSurveyDocumentId(String responseId, String surveyDocumentId);


    List<CampaignTransactionDocument> findByAudienceId(String audienceId);


}
