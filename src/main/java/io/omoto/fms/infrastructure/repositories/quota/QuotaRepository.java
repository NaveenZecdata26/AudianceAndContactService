package io.omoto.fms.infrastructure.repositories.quota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuotaRepository {


    @Autowired
    private QuotaJpaRepository quotaJpaRepository;


    public int getEmailQuotaLeft(long accountId){
        return quotaJpaRepository.getByAccountId(accountId).getEmailQuotaLeft();
    }


    public int getEmailQuota(long accountId){
        return quotaJpaRepository.getByAccountId(accountId).getEmailQuota();
    }

    public boolean isEmailQuotaLeft(long accountId){
        return quotaJpaRepository.isEmailQuotaLeft(accountId);
    }

    public boolean isEmailQuotaPresent(long accountId){
        return quotaJpaRepository.isEmailQuotaPresent(accountId);
    }


    public void reduceEmailQuota(long accountId,int quotaReductionCount) {
        quotaJpaRepository.reduceEmailQuota(accountId,quotaReductionCount);
    }
}
