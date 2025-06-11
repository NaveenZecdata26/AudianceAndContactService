package io.omoto.fms.infrastructure.repositories.audience;

import io.omoto.fms.infrastructure.entities.mongo.AudiencesDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AudiencesDocumentMongoRepository extends MongoRepository<AudiencesDocument,String> {

    @Query(value = "{ '_id' : ?0 }")
    AudiencesDocument getById(String audienceId);

    @Query(value = "{ '_id' : ?0 }",fields = "{'_id' : 0,'contacts' : 1}")
    Page<AudiencesDocument.ContactsEntity> getContactsByAudienceId(String audienceId, Pageable pageable);

    @Query(value = "{ '_id' : ?0 }")//,fields = "{'_id' : 0,'contacts' : 1}"
    List<AudiencesDocument> getContactsListByAudienceId(String audienceId, Pageable pageable);
}
