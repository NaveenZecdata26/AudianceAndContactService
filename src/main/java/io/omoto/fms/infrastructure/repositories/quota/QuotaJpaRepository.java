package io.omoto.fms.infrastructure.repositories.quota;

import io.omoto.fms.infrastructure.entities.mysql.QuotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface QuotaJpaRepository extends JpaRepository<QuotaEntity,Long> {

    @Query(value = "select * from quota where account_id =:accountId",nativeQuery = true)
    QuotaEntity getByAccountId(@Param("accountId")long accountId);


    @Query(value = "select if(email_quota_left > 0,'true','false') as is_email_quota_left  from quota where  account_id=:accountId ;",nativeQuery = true)
    boolean isEmailQuotaLeft(@Param("accountId")long accountId);


    @Query(value = "select if(email_quota > 0,'true','false') as is_email_quota_available  from quota where  account_id=:accountId ;",nativeQuery = true)
    boolean isEmailQuotaPresent(@Param("accountId")long accountId);


    @Transactional
    @Modifying
    @Query(value = "update quota set email_quota_left = email_quota_left -:quotaReductionCount where account_id =:accountId",nativeQuery = true)
    void reduceEmailQuota(@Param("accountId")long accountId,@Param("quotaReductionCount")long quotaReductionCount);


}
