package io.omoto.fms.infrastructure.entities.mysql;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by omoto on 11/1/18.
 */

@Entity(name = "users")
@Table(name = "users")
public class UserEntity{
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(columnDefinition="VARCHAR(256)")
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "zone_id")
    private Long zoneId;

    @Column(name="is_email_verified", nullable = false,columnDefinition = "boolean default false")
    private boolean isEmailVerified;

    @Column(name="is_phone_verified",nullable = false,columnDefinition = "boolean default false")
    private boolean isPhoneVerified;

    @Column(name = "stage_id")
    private Long stageId;

    @Column(name = "step_id")
    private Long stepId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "status")
    private String status;

    @Column(name = "invited_by", nullable = false, columnDefinition = "int default 0")
    private Long invitedBy;

    @Column(name = "created_by",nullable = false,columnDefinition = "int default 0")
    private Long createdBy;

    @Column(name = "deleted_by", columnDefinition = "int default 0")
    private Long deletedBy;

    @Column(name = "updated_by", columnDefinition = "int default 0")
    private Long updatedBy ;

    @Column(name="is_deleted",columnDefinition = "boolean default false")
    private boolean isDeleted;

    @Column(name="is_non_user",columnDefinition = "boolean default false")
    private boolean isNonUser;

    @Column(name = "verification_code")
    private String verificationCode;

    @Column(name = "role_id",nullable = false)
    private Long roleId;

    @Column(name = "time_zone")
    private String timeZone;

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getZoneId() {

        return zoneId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public boolean isNonUser() {
        return isNonUser;
    }

    public void setNonUser(boolean nonUser) {
        isNonUser = nonUser;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Long getInvitedBy() {
        return invitedBy;
    }

    public void setInvitedBy(Long invitedBy) {
        this.invitedBy = invitedBy;
    }
}
