package io.omoto.fms.infrastructure.repositories.user;
//package io.omoto.fms.infrastructure.repositories.user;
//
//import io.omoto.fms.domains.account.Account;
//import io.omoto.fms.domains.user.User;
//import io.omoto.fms.infrastructure.entities.mongo.UserMetaInformationDocument;
//import io.omoto.fms.infrastructure.entities.mysql.*;
//import io.omoto.fms.infrastructure.exception.custom.DoesnotExists;
//import io.omoto.fms.infrastructure.repositories.account.AccountRepository;
//import io.omoto.fms.infrastructure.repositories.common.CommonRepository;
//import io.omoto.fms.infrastructure.repositories.mysql.IndustryJpaRepository;
//import io.omoto.fms.infrastructure.repositories.mysql.OrganisationJpaRepository;
//import io.omoto.fms.infrastructure.repositories.mysql.VendorAuthKeysJpaRepository;
//import io.omoto.fms.infrastructure.repositories.notification.NotificationRepository;
//import io.omoto.fms.utils.CommonUtil;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.type.TypeReference;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.*;
//
//import static io.omoto.fms.commons.constants.Constants.*;
//

import com.fasterxml.jackson.databind.ObjectMapper;
import io.omoto.fms.domains.user.User;
import io.omoto.fms.infrastructure.entities.mysql.UserEntity;
import io.omoto.fms.infrastructure.repositories.user.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

///**
// * Created by Venkatesh Gowda on 18/4/18.
// */
@Component
public class UsersRepository {
//
   @
           Autowired
   private UserJpaRepository userJpaRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private NotificationRepository notificationRepository;
//
   @Autowired
   private ObjectMapper objectMapper;
//
//    @Autowired
//    private VendorAuthKeysJpaRepository vendorAuthKeysJpaRepository;
//
//    @Autowired
//    private UserMetaInformationMongoRepository userMetaInformationMongoRepository;
//
//    @Autowired
//    OrganisationJpaRepository organisationJpaRepository;
//
//    @Autowired
//    private IndustryJpaRepository industryJpaRepository;
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//
//    @Autowired
//    private CommonRepository commonRepository;
//
//    Map<String,String> userColumnMap = null;
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(UsersRepository.class.getName());
//
//    public void addAccountToUser(User user){
//        userJpaRepository.addAccountToUser(user.getAccountId(),user.getId(),user.getUpdatedBy());
//    }
//
//    public Long createUser(User user) {
//        if (user.getFirstName() == null && user.getFullName() != null) {
//            String[] firstAndLastName = CommonUtil.splitByFirstOccurrence(user.getFullName(), " ");
//            user.setFirstName(firstAndLastName[0]);
//            if (firstAndLastName.length > 1) {
//                user.setLastName(firstAndLastName[1]);
//            }
//        }
//        user.setIdentifier(CommonUtil.getMD5(user.getFirstName() +"_"+
//                user.getLastName()+"_"+
//                user.getRegistrationNumber()+"_"+
//                user.getEmail()+"_"+
//                user.getPhone()));
//
//        UserEntity userEntity = objectMapper.convertValue(user, UserEntity.class);
//        return userJpaRepository.save(userEntity).getId();
//    }
//
//    public String getAdminName(User user) {
//        return Objects.requireNonNull(userJpaRepository.findById(user.getInvitedBy()).orElse(null)).getFirstName();
//    }
//
//    public String getAdminEmail(User user) {
//        return Objects.requireNonNull(userJpaRepository.findById(user.getInvitedBy()).orElse(null)).getEmail();
//    }
//
//    public void deleteUser(User user) {
//        userJpaRepository.deleteUser(user.getId(),user.getUpdatedBy(),"Deleted",user.getUpdatedAt());
//    }
//
//    public String getStatus(User user) {
//        return userJpaRepository.findByIdAndAccountId(user.getId(),
//                        user.getAccountId())
//                .orElseThrow(DoesnotExists.supplier("User with given id: " + user.getId() + " and accountId: " + user.getAccountId() + " doesn't exist!", "isAccountActivated", "Is account activated"))
//                .getStatus();
//    }
//
//    public long getAccountIdByUserId(User user) {
//        return Objects.requireNonNull(userJpaRepository.findById(user.getId()).orElse(null)).getAccountId();
//    }
//
//    public User setNameAndPassword(User user) {
//        UserEntity userEntity = userJpaRepository.findById(user.getId()).orElse(null);
//        if (userEntity != null) {
//            userEntity.setPassword(user.getPassword());
//            userEntity.setUpdatedBy(user.getUpdatedBy());
//            userEntity.setStatus(ACTIVE);
//            if (user.getFullName() != null) {
//                String[] firstAndLastName = CommonUtil.splitByFirstOccurrence(user.getFullName(), " ");
//                if (firstAndLastName.length > 1) {
//                    userEntity.setFirstName(firstAndLastName[0]);
//                    userEntity.setLastName(firstAndLastName[1]);
//                }else{
//                    userEntity.setFirstName(firstAndLastName[0]);
//                }
//            }
//            userJpaRepository.save(userEntity);
//            return objectMapper.convertValue(userEntity, User.class);
//        }else{
//            throw DoesnotExists.supplier("User doesn't exists","setNameAndPassword","setNameAndPassword").get();
//        }
//    }
//
//    public void updateStatusOfAnUser(User user) {
//        UserEntity userEntity = userJpaRepository.findById(user.getId()).orElse(null);
//        assert userEntity != null;
//        userEntity.setStatus(user.getStatus());
//        userEntity.setUpdatedAt();
//        userEntity.setUpdatedBy(user.getUpdatedBy());
//        userJpaRepository.save(userEntity);
//    }
//
//    public void updateRoleOfAnUser(User user) {
//        userJpaRepository.updateRoleOfUsers(user.getRoleId(),user.getUserIds(),user.getUpdatedBy());
//    }
//
//
//    public void updateUser(User user) {
//        UserEntity userEntity = userJpaRepository.findById(user.getId()).orElse(null);
//        assert userEntity != null;
//        userEntity.setFirstName(user.getFirstName());
//        userEntity.setLastName(user.getLastName());
//        if(!Objects.isNull(user.getEmail())) {
//            userEntity.setEmail(user.getEmail());
//        }
//        userEntity.setUpdatedAt();
//        userEntity.setUpdatedBy(user.getUpdatedBy());
//        if(!Objects.isNull(user.getPhone())) {
//            userEntity.setPhone(user.getPhone());
//        }
//        if(!Objects.isNull(user.getStatus())) {
//            userEntity.setStatus(user.getStatus());
//        }
//
//        if (!Objects.isNull(user.getRole()) && !user.getRole().isEmpty()) {
//            RoleEntity roleEntity = roleRepository.findByName(user.getRole());
//            if(!Objects.isNull(roleEntity)){
//                userEntity.setRoleId(roleEntity.getId());
//            }
//        }
//        Account account = accountRepository.getAccount(userEntity.getAccountId());
//
//        if (!Objects.isNull(user.getCompanyName()) && !user.getCompanyName().isEmpty()) {
//            Optional<OrganisationEntity> optionalOrganisationEntity = organisationJpaRepository.findById(account.getOrganisationId());
//            if (optionalOrganisationEntity.isPresent()) {
//                OrganisationEntity organisationEntity = optionalOrganisationEntity.get();
//                organisationEntity.setName(user.getCompanyName());
//                organisationJpaRepository.save(organisationEntity);
//            }
//
//
//        }
//
//
//        if (!Objects.isNull(user.getIndustry()) && !user.getIndustry().isEmpty()) {
//            IndustryEntity industryEntity = industryJpaRepository.findByName(user.getIndustry());
//            Optional<OrganisationEntity> optionalOrganisationEntity = organisationJpaRepository.findById(account.getOrganisationId());
//            optionalOrganisationEntity.ifPresent(organisationEntity -> {
//                organisationEntity.setIndustryId(industryEntity.getId());
//                organisationJpaRepository.save(organisationEntity);
//            });
//
//
//        }
//
//        userJpaRepository.save(userEntity);
//        if(user.getNotifications() != null){
//            updateNotifications(user);
//        }
//    }
//
//    private void updateNotifications(User user) {
//        UserMetaInformationDocument userMetaInformationDocument = userMetaInformationMongoRepository.findByUserId(user.getId());
//
//        for (UserMetaInformationDocument.Notifications notification : userMetaInformationDocument.getNotifications()) {
//            for (User.Notifications userNotification : user.getNotifications()) {
//                if(userNotification.getKey().equalsIgnoreCase(notification.getKey())){
//                    List<String> values = userNotification.getValues();
//                    System.out.println(values.contains(NOTIFICATION_KEY_DAILY));
//                    if(values.contains(NOTIFICATION_KEY_DAILY)){
//                        notification.setIsDailySummaryEnabled(true);
//                    }else {
//                        notification.setIsDailySummaryEnabled(false);
//                    }
//                    if(values.contains(NOTIFICATION_KEY_WEEKLY)){
//                        notification.setIsWeeklySummaryEnabled(true);
//                    }else {
//                        notification.setIsWeeklySummaryEnabled(false);
//                    }
//
//                    if(values.contains(NOTIFICATION_KEY_MONTHLY)){
//                        notification.setIsMonthlySummaryEnabled(true);
//                    }else {
//                        notification.setIsMonthlySummaryEnabled(false);
//                    }
//                }
//            }
//        }
//
//        userMetaInformationMongoRepository.save(userMetaInformationDocument);
//
//    }
//
//    public User getInvitedByUserId(User user) {
//        Long invitedUserId = userJpaRepository.findInvitedByUserId(user.getId());
//        user.setInvitedBy(invitedUserId);
//        return user;
//    }
//
//    public String getNameOfUser(User user) {
//        return Objects.requireNonNull(userJpaRepository.findById(user.getId()).orElse(null)).getFirstName();
//    }
//
  public User getUser(User user) {
     UserEntity entity = userJpaRepository.findById(user.getId()).orElse(null);
        return objectMapper.convertValue(entity, User.class);
   }
//
//    public User getUserByEmail(User user) {
//        UserEntity entity = userJpaRepository.getUserByEmail(user.getEmail());
//        return objectMapper.convertValue(entity, User.class);
//    }
//
//    public void save(User user) {
//        UserEntity userEntity = objectMapper.convertValue(user, UserEntity.class);
//        userJpaRepository.save(userEntity);
//    }
//
//    public List<User> getUsersByAccountId(Long accountId) {
//        List<UserEntity> users = userJpaRepository.getUserIdByAccountId(accountId);
//        return objectMapper.convertValue(users, new TypeReference<List<User>>() {});
//    }
//
//    //Create by AbhiaySoni
//    public List<User> getUserIdByEmail(String email){
//        List<UserEntity> users = userJpaRepository.getUserIdByEmail(email);
//        return objectMapper.convertValue(users, new TypeReference<List<User>>() {});
//    }
//
//    public void createUsers(List<User> users) {
//        List<UserEntity> userEntities = objectMapper.convertValue(users, new TypeReference<List<UserEntity>>() {});
//        userJpaRepository.saveAll(userEntities);
//    }
//
//    public User getUserByVerificationCode(String verificationCode) {
//        UserEntity userEntity = userJpaRepository.getUserByVerificationCode(verificationCode);
//        return objectMapper.convertValue(userEntity, User.class);
//    }
//
//    public String verifyEmail(User user) {
//        UserEntity userEntity = userJpaRepository.findById(user.getId()).orElse(null);
//        if (userEntity != null) {
//            userEntity.setEnabled(true);
//            userEntity.setEmailVerified(true);
//            user.setStatus(ACTIVE);
//            userJpaRepository.save(userEntity);
//            return "Success";
//            //scheduleAccountActivationReminderEmail(user.getUserId());
//        }else{
//            throw DoesnotExists.supplier("User doesn't exists","verifyUser","Verifying email").get();
//        }
//    }
//
//    public void createNonUsersOfOrganization(List<User> users) {
//        users.forEach(  user -> {
//            UserEntity userEntity = new UserEntity();
//            userEntity.setFirstName(user.getFirstName());
//            userEntity.setLastName(user.getLastName());
//            userEntity.setAccountId(user.getAccountId());
//            userEntity.setEmail(user.getEmail());
//            userEntity.setPhone(user.getPhone());
//            userEntity.setCreatedBy(user.getCreatedBy());
//            userEntity.setUpdatedBy(user.getCreatedBy());
//            userEntity.setNonUser(true);
//            userJpaRepository.save(userEntity);
//        });
//    }
//
//    public String getOrganisationNameOfAnUser(long userId) {
//        return userJpaRepository.getOrganisationOfAnUser(userId);
//    }
//
//    public String getVerificationCodeByEmail(String email) {
//        return userJpaRepository.getVerificationCodeByEmail(email);
//    }
//
//    public int getUsersCountOfAnAccount(long accountId) {
//        return userJpaRepository.getUsersCountOfAnAccount(accountId);
//    }
//
//    public List<User.UserNotificationDetails> getUserNotificationDetails(long accountId) {
//        List<User.UserNotificationDetails> userNotificationDetailsList = new ArrayList<>();
//        User.UserNotificationDetails userNotificationDetails;
//        List<UserEntity> userEntities = userJpaRepository.findByAccountId(accountId);
//        for (UserEntity userEntity : userEntities) {
//            userNotificationDetails = new User.UserNotificationDetails();
//            userNotificationDetails.setId(userEntity.getId());
//            userNotificationDetails.setFirstName(userEntity.getFirstName());
//            userNotificationDetails.setLastName(userEntity.getLastName());
//            userNotificationDetails.setEmail(userEntity.getEmail());
//            userNotificationDetails.setStatus(userEntity.getStatus());
//            userNotificationDetails.setRoleId(userEntity.getRoleId());
//            userNotificationDetails.setRole(roleRepository.getRoleById(userEntity.getRoleId()));
//            userNotificationDetails.setAccountId(accountId);
//            userNotificationDetails.setNotifications(notificationRepository.getNotificationDetailsOfAnUser(userEntity.getId()));
//            userNotificationDetailsList.add(userNotificationDetails);
//        }
//        return userNotificationDetailsList;
//    }
//
//    public List<User> getActiveUsersByAccountId(long accountId) {
//        List<UserEntity> users = userJpaRepository.getActiveUsersByAccountId(accountId);
//        LOGGER.info("The number of active users are : {}  ",users.size());
//        return objectMapper.convertValue(users, new TypeReference<List<User>>() {});
//    }
//
//    public Long getActiveUsersCountByAccountId(long accountId) {
//        return userJpaRepository.getActiveUsersCountByAccountId(accountId);
//    }
//
//    public Long getUsersCountByAccountId(long accountId) {
//        return userJpaRepository.getUsersCountByAccountId(accountId);
//    }
//
//
//    public String getUserTimeZoneById(Long createdBy) {
//        return userJpaRepository.getTimeZoneOfAnUserById(createdBy);
//    }
//
//    public Long saveVendorAuthKeys(User user) {
//        VendorAuthKeys vendorAuthKeys = new VendorAuthKeys();
//        vendorAuthKeys.setAccessToken(user.getAccessToken());
//        vendorAuthKeys.setRefreshToken(user.getRefreshToken());
//        vendorAuthKeys.setType(user.getAuthorizationType());
//        vendorAuthKeys.setAccountId(user.getAccountId());
//        vendorAuthKeys.setUserId(user.getId());
//        vendorAuthKeys.setUrl(user.getAccountUrl());
//        return vendorAuthKeysJpaRepository.save(vendorAuthKeys).getId();
//    }
//
//
//    public User getVendorAuthKeysByAccessTokenAndType(String accessToken,String type) {
//        VendorAuthKeys vendorAuthKeys = vendorAuthKeysJpaRepository.getByAccessTokenAndType(accessToken,type);
//        User user = new User();
//        user.setAccountId(vendorAuthKeys.getAccountId());
//        user.setRefreshToken(vendorAuthKeys.getRefreshToken());
//        user.setAccountId(vendorAuthKeys.getAccountId());
//        user.setAuthorizationType(vendorAuthKeys.getType());
//        user.setAccessToken(vendorAuthKeys.getAccessToken());
//        return user;
//    }
//
//
//    public List<User> getUsersByNativeQuery(String query) {
//        List users = commonRepository.runSelectQueryWithType(query, UserEntity.class);
//        return objectMapper.convertValue(users, new TypeReference<List<User>>() {});
//    }
//
//
//    public Map<String ,String> getUserColumnData(){
//        if(userColumnMap != null){
//            return userColumnMap;
//        }
//        userColumnMap = new HashMap<>();
//        userColumnMap.put("status","status");
//        userColumnMap.put("firstName","first_name");
//        userColumnMap.put("email","email");
//        userColumnMap.put("phone","phone");
//        return userColumnMap;
//
//    }
//
//    public String getCurrentPasswordOfAnUser(User user) {
//        return userJpaRepository.getPasswordOfAnUser(user.getId());
//    }
//
//    public void updatePassword(User user) {
//        userJpaRepository.updatePasswordOfAnUser(user.getId(),user.getNewPassword());
//    }
//
//    public boolean updateTimeZone(User user) {
//        UserEntity userEntity = userJpaRepository.findById(user.getId()).orElse(null);
//        assert userEntity != null;
//        userEntity.setTimeZone(user.getTimeZone());
//        UserEntity save = userJpaRepository.save(userEntity);
//        return true;
//
//    }
//
//    public boolean updateLastLogin(User user) {
//        UserEntity userEntity = userJpaRepository.findById(user.getId()).orElse(null);
//        assert userEntity != null;
//        userEntity.setLastLogin(new Date());
//        userJpaRepository.save(userEntity);
//        return true;
//    }
//
//    public UserMetaInformationDocument getMetaInformation(long userId){
//        return userMetaInformationMongoRepository.findByUserId(userId);
//    }
//
//    public User getUserWithAccountInformation(User user) {
//        UserEntity entity = userJpaRepository.findById(user.getId()).orElse(null);
//        User userResult = objectMapper.convertValue(entity, User.class);
//
//        assert entity != null;
//        Account account = accountRepository.getAccount(entity.getAccountId());
//
//        Optional<OrganisationEntity> organisationEntityOptional = organisationJpaRepository.findById(account.getOrganisationId());
//        organisationEntityOptional.ifPresent(organisationEntity ->{
//            userResult.setCompanyName(organisationEntity.getName());
//            if(organisationEntity.getIndustryId() != null) {
//                Optional<IndustryEntity> industryEntityOptional = industryJpaRepository.findById(organisationEntity.getIndustryId());
//                industryEntityOptional.ifPresent(industryEntity -> userResult.setIndustry(industryEntity.getName()));
//            }
//        });
//
//        Optional<RoleEntity> roleEntityOptional = roleRepository.findById(entity.getRoleId());
//        roleEntityOptional.ifPresent(roleEntity -> userResult.setRole(roleEntity.getName()));
//
//        return userResult;
//    }
}
