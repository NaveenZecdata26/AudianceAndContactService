package io.omoto.fms.infrastructure.repositories.campaign;

import io.omoto.fms.infrastructure.entities.mongo.CampaignReminderDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReminderCampaignMongoRepository extends MongoRepository<CampaignReminderDocument,String> {
}
