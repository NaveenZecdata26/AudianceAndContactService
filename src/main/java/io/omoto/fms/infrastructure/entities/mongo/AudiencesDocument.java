package io.omoto.fms.infrastructure.entities.mongo;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document
public class AudiencesDocument {

    @Id
    private String _id;
    private String audienceName;
    private String audienceId;
    private Long accountId;
    private String description;
    private List<ContactsEntity> contacts;
    private String apiKey;
    private String status;
    private long createdBy;
    private long updatedBy;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ContactsEntity> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactsEntity> contacts) {
        this.contacts = contacts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAudienceName() {
        return audienceName;
    }

    public void setAudienceName(String audienceName) {
        this.audienceName = audienceName;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(String audienceId) {
        this.audienceId = audienceId;
    }

    @Document
    public static class ContactsEntity {
        @Id
        private String _id;
        private String identifier;
        private String lastName;
        private String gender;
        private Long accountId;
        private String firstName;
        private Map qualifyingInfo;
        private String phone;
        private String countryCode;
        private String registrationId;
        private String email;
        private Long createdBy;
        private Long updatedBy;
        @CreatedDate
        private LocalDateTime createdAt;
        @LastModifiedDate
        private LocalDateTime updatedAt;

        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }


        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Long getAccountId() {
            return accountId;
        }

        public void setAccountId(Long accountId) {
            this.accountId = accountId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }


        public Map getQualifyingInfo() {
            return qualifyingInfo;
        }

        public void setQualifyingInfo(Map qualifyingInfo) {
            this.qualifyingInfo = qualifyingInfo;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }


        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getRegistrationId() {
            return registrationId;
        }

        public void setRegistrationId(String registrationId) {
            this.registrationId = registrationId;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Long getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Long createdBy) {
            this.createdBy = createdBy;
        }

        public Long getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(Long updatedBy) {
            this.updatedBy = updatedBy;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}
