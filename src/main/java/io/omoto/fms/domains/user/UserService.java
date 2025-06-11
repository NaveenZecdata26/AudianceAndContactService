package io.omoto.fms.domains.user;

import java.util.List;
import java.util.Optional;

/**
 * Created by Venkatesh Gowda on 24/1/18.
 */
public interface UserService{
//    User getUserByVerificationCode(String verificationCode);
//    String getActivationLinkByEmail(String email);
//    boolean isUserExists(User user);
//    boolean isUserAccountActive(User user);
//    Long createUser(User user);
//    String verifyEmail(User user);
//    List<User> getUsersByAccountId(Long user);
//    List<User> getUsersByEmail(String email);
    User getUser(Long userId);
//    void createUsers(List<User> users);
//
//    void addAccountToUser(User user);
//
//    Long createInvitedUser(User user);
//
//    String sendInvitation(User user);
//    void deleteUser(User user);
//
//    String getUserStatus(User user);
//
//    long getAccountIdOfUser(User user);
//
//    void updateStatusOfAnUser(User user);
//
//    void updateRoleOfUsers(User user);
//
//    String getAdminNameOfUser(User user);
//
//    void notifyAdminWhenEmailNotDelivered(User user);
//
//    void notifyAdminWhenEmailDelivered(User user);
//
//    void notifyAdminWhenInvitationAccepted(User user);
//
//    void sendReminderInvitationEmail(User user);
//
//    void notifyAdminWhenInvitationNotAccepted(User user);
//    User setUserNameAndPassword(User user);
//    void createNonUserOfOrganization(List<User> users);
//
//    void addAccountIdToUser(User user);
//
//    boolean isEligibleToInviteNewUser(long accountId);
//
//    List<User.UserNotificationDetails> getUserNotificationDetails(long accountId);
//
//    List<User> getActiveUsersByAccountId(long accountId);

    String sendCampaignStartedNotification(User user);

//    Long saveVendorAuthKeys(User user);
//
//    User getProfile(User user);
//
//    void updateUser(User user);
//
//    boolean updateTimezone(User user);
//    boolean updateLastLogin(User user);



//    String passwordUpdateLinkByEmail(String email);
//    Optional<User> getAUserByEmail(User user);
//    void updatePassword(User user);

}
