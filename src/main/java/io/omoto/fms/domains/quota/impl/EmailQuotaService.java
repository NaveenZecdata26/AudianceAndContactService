package io.omoto.fms.domains.quota.impl;

import io.omoto.fms.domains.quota.Quota;
import io.omoto.fms.domains.quota.QuotaService;
import io.omoto.fms.infrastructure.repositories.quota.QuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailQuotaService implements QuotaService {

    @Autowired
    private QuotaRepository quotaRepository;


    @Override
    public boolean isQuotaAvailable(Quota quota) {
        boolean emailQuotaLeft = quotaRepository.isEmailQuotaLeft(quota.getAccountId());
        System.out.println("Email quota left "+emailQuotaLeft);
        return emailQuotaLeft;
        // return quotaRepository.isEmailQuotaLeft(quota.getAccountId());
    }

    @Override
    public boolean isQuotaPresent(Quota quota) {
        return quotaRepository.isEmailQuotaPresent(quota.getAccountId());
    }

//    @Override
//    public boolean sendQuotaNotificationEmail(Quota quota) {
//        int emailQuotaLeft = quotaRepository.getEmailQuotaLeft(quota.getAccountId());
//        int emailQuota = quotaRepository.getEmailQuota(quota.getAccountId());
//        if(emailQuota == 0){
//            return false;
//        }
//        int percentageOfQuotaLeft = (emailQuotaLeft*100)/emailQuota;
//
//
//
//        return false;
//    }
//
   @Override
    public boolean reduceQuota(Quota quota) {
        quotaRepository.reduceEmailQuota(quota.getAccountId(),quota.getQuotaReductionCount());
        return true;
    }

}
