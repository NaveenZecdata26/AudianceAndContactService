package io.omoto.fms.infrastructure.entities.mysql;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "quota")
@Table(name = "quota")
public class QuotaEntity {

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

    @Column(name = "account_id",unique = true,nullable = false)
    private Long accountId;

    @Column(name = "email_quota",columnDefinition = "int default 0",nullable = false)
    private Integer emailQuota;

    @Column(name = "email_quota_left",columnDefinition = "int default 0",nullable = false)
    private Integer emailQuotaLeft;

    @Column(name = "sms_quota",columnDefinition = "int default 0",nullable = false)
    private Integer smsQuota;

    @Column(name = "sms_quota_left",columnDefinition = "int default 0",nullable = false)
    private Integer smsQuotaLeft;

    @Column(name = "whatsapp_quota",columnDefinition = "int default 0",nullable = false)
    private Integer whatsAppQuota;

    @Column(name = "whatsapp_quota_left",columnDefinition = "int default 0",nullable = false)
    private Integer whatsAppQuotaLeft;

    @Column(name = "push_notification_quota",columnDefinition = "int default 0",nullable = false)
    private Integer pushNotificationQuota;

    @Column(name = "push_notification_quota_left",columnDefinition = "int default 0",nullable = false)
    private Integer pushNotificationQuotaLeft;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getEmailQuota() {
        return emailQuota;
    }

    public void setEmailQuota(Integer emailQuota) {
        this.emailQuota = emailQuota;
    }

    public Integer getEmailQuotaLeft() {
        return emailQuotaLeft;
    }

    public void setEmailQuotaLeft(Integer emailQuotaLeft) {
        this.emailQuotaLeft = emailQuotaLeft;
    }

    public Integer getSmsQuota() {
        return smsQuota;
    }

    public void setSmsQuota(Integer smsQuota) {
        this.smsQuota = smsQuota;
    }

    public Integer getSmsQuotaLeft() {
        return smsQuotaLeft;
    }

    public void setSmsQuotaLeft(Integer smsQuotaLeft) {
        this.smsQuotaLeft = smsQuotaLeft;
    }

    public Integer getWhatsAppQuota() {
        return whatsAppQuota;
    }

    public void setWhatsAppQuota(Integer whatsAppQuota) {
        this.whatsAppQuota = whatsAppQuota;
    }

    public Integer getWhatsAppQuotaLeft() {
        return whatsAppQuotaLeft;
    }

    public void setWhatsAppQuotaLeft(Integer whatsAppQuotaLeft) {
        this.whatsAppQuotaLeft = whatsAppQuotaLeft;
    }

    public Integer getPushNotificationQuota() {
        return pushNotificationQuota;
    }

    public void setPushNotificationQuota(Integer pushNotificationQuota) {
        this.pushNotificationQuota = pushNotificationQuota;
    }

    public Integer getPushNotificationQuotaLeft() {
        return pushNotificationQuotaLeft;
    }

    public void setPushNotificationQuotaLeft(Integer pushNotificationQuotaLeft) {
        this.pushNotificationQuotaLeft = pushNotificationQuotaLeft;
    }
}
