package io.omoto.fms.infrastructure.entities.mongo;

import io.omoto.fms.api.rest.v3.vo.AudienceVO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Document
public class AudienceDocument {

    @Id
    private String id;
    private String name;
    private long accountId;
    private long userId;
    private String contactsJson;
    private boolean createAudience;
    private boolean createContacts;
    private List<AudienceVO.AudienceContactMapBean> audienceContactMap;
    private List<AudienceVO.AudienceBean> audience;

    private String description;
    private List<MappedFields> mappedFields;
    private List<Object> createdFields;
    private List<Object> contacts;
    private String audienceId;
    private String apiKey;
    private long createdBy;
    private long updatedBy;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getContactsJson() {
        return contactsJson;
    }

    public void setContactsJson(String contactsJson) {
        this.contactsJson = contactsJson;
    }

    public boolean isCreateAudience() {
        return createAudience;
    }

    public void setCreateAudience(boolean createAudience) {
        this.createAudience = createAudience;
    }

    public boolean isCreateContacts() {
        return createContacts;
    }

    public void setCreateContacts(boolean createContacts) {
        this.createContacts = createContacts;
    }

    public List<AudienceVO.AudienceContactMapBean> getAudienceContactMap() {
        return audienceContactMap;
    }

    public void setAudienceContactMap(List<AudienceVO.AudienceContactMapBean> audienceContactMap) {
        this.audienceContactMap = audienceContactMap;
    }

    public List<AudienceVO.AudienceBean> getAudience() {
        return audience;
    }

    public void setAudience(List<AudienceVO.AudienceBean> audience) {
        this.audience = audience;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MappedFields> getMappedFields() {
        return mappedFields;
    }

    public void setMappedFields(List<MappedFields> mappedFields) {
        this.mappedFields = mappedFields;
    }

    public List<Object> getCreatedFields() {
        return createdFields;
    }

    public void setCreatedFields(List<Object> createdFields) {
        this.createdFields = createdFields;
    }

    public List<Object> getContacts() {
        return contacts;
    }

    public void setContacts(List<Object> contacts) {
        this.contacts = contacts;
    }

    public String getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(String audienceId) {
        this.audienceId = audienceId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
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

    public static class AudienceContactMapBean implements Serializable {
        /**
         * contactId : 1
         * contactDetailsGroupId : 14f39190-8d1e-4d47-aa96-867d5af19555
         */

        private long contactId;
        private String contactDetailsGroupId;

        public long getContactId() {
            return contactId;
        }

        public void setContactId(long contactId) {
            this.contactId = contactId;
        }

        public String getContactDetailsGroupId() {
            return contactDetailsGroupId;
        }

        public void setContactDetailsGroupId(String contactDetailsGroupId) {
            this.contactDetailsGroupId = contactDetailsGroupId;
        }
    }

    public static class AudienceBean implements Serializable {
        /**
         * id : 1
         * excludeContacts : [2]
         */

        private long id;
        private List<Long> excludeContacts;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public List<Long> getExcludeContacts() {
            return excludeContacts;
        }

        public void setExcludeContacts(List<Long> excludeContacts) {
            this.excludeContacts = excludeContacts;
        }
    }

    public static class MappedFields {
        private String field;

        private String mappedTo;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMappedTo() {
            return mappedTo;
        }

        public void setMappedTo(String mappedTo) {
            this.mappedTo = mappedTo;
        }

        @Override
        public String toString() {
            return "MappedFields{" +
                    "field='" + field + '\'' +
                    ", mappedTo='" + mappedTo + '\'' +
                    '}';
        }
    }
}
