package io.omoto.fms.infrastructure.repositories.user;//package io.omoto.fms.infrastructure.repositories.user;
//
//import io.omoto.fms.infrastructure.entities.mysql.UserEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//

import io.omoto.fms.infrastructure.entities.mysql.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

///**
// * Created by Venkatesh Gowda on 18/4/18.
// */
@Repository
interface UserJpaRepository extends JpaRepository<UserEntity,Long> {
//
//    @Transactional
//    @Modifying
//    @Query(value = "update users set account_id =:account_id,updated_by =:updated_by where id =:id",nativeQuery = true)
//    void addAccountToUser(@Param("account_id") long accountId, @Param("id") long userId, @Param("updated_by") long updatedBy);
//
//    @Transactional
//    @Modifying
//    @Query(value = "update users set is_deleted = true , updated_by =:updated_by , status =:status, updated_at =:updated_at  where id =:id ")
//    void deleteUser(@Param("id") long id, @Param("updated_by") long updatedBy, @Param("status") String status, @Param("updated_at")Date date);
//
//    @Query(value = "select invited_by from users where id =:id",nativeQuery = true)
//    Long findInvitedByUserId(@Param("id") long id);
//
//    @Query(value = "select * from users where account_id =:account_id",nativeQuery = true)
//    List<UserEntity> getUserIdByAccountId(@Param("account_id")Long accountId);
//
//    @Query(value = "select * from users where email =:email",nativeQuery = true)
//    List<UserEntity> getUserIdByEmail(@Param("email")String email);
//
//    UserEntity getUserByEmail(String email);
//
//    @Query(value = "select email from users where id =:id", nativeQuery = true)
//    String getEmailById(@Param("id") long id);
//
//    UserEntity getUserByVerificationCode(String verificationCode);
//
//
//    @Query(nativeQuery = true,value = "select name from organisation where id = (select organisation_id from account where id = (select account_id from users where id =:userId))")
//    String getOrganisationOfAnUser(@Param("userId") long userId);
//
//    @Query(nativeQuery = true,value = "select verification_code from users where email =:email")
//    String getVerificationCodeByEmail(@Param("email") String email);
//
//
//    @Query(nativeQuery = true,value = "select time_zone from users where id =:id")
//    String getTimeZoneOfAnUserById(@Param("id") Long email);
//
//    @Query(nativeQuery = true, value = "Select count(*) from users where account_id = :account_id")
//    Integer getUsersCountOfAnAccount(@Param("account_id") long accountId);
//
//    List<UserEntity> findByAccountId(long accountId);
//
//    Optional<UserEntity> findByIdAndAccountId(long id, long accountId);
//
//    @Query(value = "select * from users where account_id =:account_id and enabled=true",nativeQuery = true)
//    List<UserEntity> getActiveUsersByAccountId(@Param("account_id")Long accountId);
//
//    @Query(nativeQuery = true,value = "select password from users where id =:id")
//    String getPasswordOfAnUser(@Param("id") Long id);
//
//    @Transactional
//    @Modifying
//    @Query(value = "update users set password =:password where id =:id ")
//    void updatePasswordOfAnUser(@Param("id") long id, @Param("password") String password);
//
//    @Transactional
//    @Modifying
//    @Query(value = "update users set role_id =:role_id, updated_by = :updated_by where id in :user_ids")
//    void updateRoleOfUsers(@Param("role_id") long roleId, @Param("user_ids") List<Long> userIds, @Param("updated_by") Long updatedBy);
//
//    @Query(value = "select count(*) from users where account_id =:account_id and enabled=true",nativeQuery = true)
//    Long getActiveUsersCountByAccountId(@Param("account_id")Long accountId);
//
//    @Query(value = "select count(*) from users where account_id =:account_id ",nativeQuery = true)
//    Long getUsersCountByAccountId(@Param("account_id")Long accountId);
}
