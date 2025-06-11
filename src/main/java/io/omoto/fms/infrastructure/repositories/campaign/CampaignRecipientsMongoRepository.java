package io.omoto.fms.infrastructure.repositories.campaign;

import io.omoto.fms.infrastructure.entities.mongo.CampaignRecipientsDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CampaignRecipientsMongoRepository extends MongoRepository<CampaignRecipientsDocument,String> {
}
