package io.omoto.fms.infrastructure.repositories.campaign;


import io.omoto.fms.infrastructure.entities.mongo.CampaignDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

interface CampaignMongoRepository extends MongoRepository<CampaignDocument,String> {
    List<CampaignDocument> findByAccountId(long accountId);

    void deleteByIdIn(List<String> ids);

    List<CampaignDocument> findByAccountIdAndChannel(long accountId, String channel);
}
