package io.omoto.fms.infrastructure.repositories.mongo;

import io.omoto.fms.infrastructure.entities.mongo.AudienceDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AudienceMongoRepository extends MongoRepository<AudienceDocument, String>  {
    @Query(value = "{ 'apiKey' : ?0 }")
    AudienceDocument findByApiKey(String apiKey);
}
