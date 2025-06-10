package io.omoto.fms.infrastructure.repositories.mongo;

import io.omoto.fms.api.rest.v3.vo.ViewContactProjection;
import io.omoto.fms.infrastructure.entities.mongo.ContactsDocument;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
@Document
public interface ContactsMongoRepository extends MongoRepository<ContactsDocument, String> {
    @Query("{ 'identifier' : ?0 }")
    ContactsDocument findByIdentifier(String identifier);

    @Query("{ '_id' : ?0 }")
    ContactsDocument getById(String id);

    Long countByAudienceIds(String audienceIds);


    @Query("{ 'audienceIds': ?0 }, 'accountId': ?1 }")
    List<ViewContactProjection> findByAudienceId(String audienceIds, Long accountId);
}
