package io.omoto.fms.domains.user;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String phone;
    private String identifier;
    private String registrationNumber;
    private long accountId;
    private String password;
    private boolean enabled;
    private boolean isEmailVerified;
    private boolean isPhoneVerified;
    private Date creationTime;
    private Date updatedTime;
    private Number stageId;
    private Number stepId;
    private String accessToken;
    private String refreshToken;
    private String authorizationType;
    private String accountUrl;
    private String companyName;
    private String  role;
    private String  industry;
    private String currentPassword;
    private String newPassword;
    private List<Long> userIds;


    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date createdAt;

    private Date deleteTime;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updatedAt;
    private long createdBy;
    private long deletedBy;
    private long updatedBy;
    private boolean isDeleted;
    private String verificationCode;
    private long invitedBy;
    private long roleId;
    private String status;
    private boolean isNonUser;
    private String plainPassword;
    private List<MergeTag> mergeTags;
    private Profile profile;
    private String timeZone;
    private Date lastLogin;
    private List<Notifications> notifications;

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public List<MergeTag> getMergeTags() {
        return mergeTags;
    }

    public void setMergeTags(List<MergeTag> mergeTags) {
        this.mergeTags = mergeTags;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public List<Notifications> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notifications> notifications) {
        this.notifications = notifications;
    }

    public static class MergeTag {
        private String key;
        private String value;

        public MergeTag(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isNonUser() {
        return isNonUser;
    }

    public void setNonUser(boolean nonUser) {
        isNonUser = nonUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getInvitedBy() {
        return invitedBy;
    }

    public void setInvitedBy(long invitedBy) {
        this.invitedBy = invitedBy;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }


    public String getAccountUrl() {
        return accountUrl;
    }

    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public boolean isPhoneVerified() {
        return isPhoneVerified;
    }

    public void setPhoneVerified(boolean phoneVerified) {
        isPhoneVerified = phoneVerified;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Number getStageId() {
        return stageId;
    }

    public void setStageId(Number stageId) {
        this.stageId = stageId;
    }

    public Number getStepId() {
        return stepId;
    }

    public void setStepId(Number stepId) {
        this.stepId = stepId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public long getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(long deletedBy) {
        this.deletedBy = deletedBy;
    }

    public long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    public String getAuthorizationType() {
        return authorizationType;
    }

    public void setAuthorizationType(String authorizationType) {
        this.authorizationType = authorizationType;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public static class UserNotificationDetails{
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private Long accountId;
        private Long roleId;
        private String role;
        private String status;
        private String lastLogin;
        private List<Notification> notifications;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Long getAccountId() {
            return accountId;
        }

        public void setAccountId(Long accountId) {
            this.accountId = accountId;
        }

        public Long getRoleId() {
            return roleId;
        }

        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getLastLogin() {
            return lastLogin;
        }

        public void setLastLogin(String lastLogin) {
            this.lastLogin = lastLogin;
        }

        public List<Notification> getNotifications() {
            return notifications;
        }

        public void setNotifications(List<Notification> notifications) {
            this.notifications = notifications;
        }

        public static class Notification{
            private Long id;
            private String name;
            private boolean isSubscribed;

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isSubscribed() {
                return isSubscribed;
            }

            public void setSubscribed(boolean subscribed) {
                isSubscribed = subscribed;
            }
        }
    }

    public static class Profile{

        /**
         * role : Admin
         * phone : 8217736036
         * companyName : Omoto
         * fullName : Venkatesh K
         * industry : Developer
         * email : venkatesh@omoto.io
         */
        private String role;
        private String phone;
        private String companyName;
        private String fullName;
        private String industry;
        private String email;

        public void setRole(String role) {
            this.role = role;
        }



        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRole() {
            return role;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCompanyName() {
            return companyName;
        }

        public String getFullName() {
            return fullName;
        }

        public String getIndustry() {
            return industry;
        }

        public String getEmail() {
            return email;
        }
    }


    public static class Notifications {
        private List<String> values;
        private String key;

        public void setValues(List<String> values) {
            this.values = values;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<String> getValues() {
            return values;
        }

        public String getKey() {
            return key;
        }
    }
}
