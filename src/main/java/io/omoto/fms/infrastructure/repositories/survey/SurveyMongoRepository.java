package io.omoto.fms.infrastructure.repositories.survey;

import io.omoto.fms.infrastructure.entities.mongo.SurveyDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyMongoRepository extends MongoRepository<SurveyDocument,String> {



}
