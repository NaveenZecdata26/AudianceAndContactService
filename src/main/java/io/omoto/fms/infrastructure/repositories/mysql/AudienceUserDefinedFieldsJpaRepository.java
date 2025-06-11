package io.omoto.fms.infrastructure.repositories.mysql;

import io.omoto.fms.infrastructure.entities.mysql.AudienceUserDefinedFields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AudienceUserDefinedFieldsJpaRepository extends JpaRepository<AudienceUserDefinedFields, Long> {

    @Query(value = "select * from audience_user_defined_fields where account_id =:accountId",nativeQuery = true)
    List<AudienceUserDefinedFields> getByAccountId(@Param("accountId")long accountId);


    @Query(value = "select * from audience_user_defined_fields where account_id =:accountId and audience_id =:audienceId ",nativeQuery = true)
    List<AudienceUserDefinedFields> getByAccountIdAndAudienceId(@Param("accountId")long accountId,@Param("audienceId")String audienceId);


    @Query(value ="select * from audience_user_defined_fields where audience_id in :audienceIdList group by field_name,field_display_name",nativeQuery = true)
    List<AudienceUserDefinedFields> getDistinctFieldNameAndDisplayNameByAudienceIdsList(@Param("audienceIdList")List<String> audienceIdsList);

}
