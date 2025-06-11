package io.omoto.fms.api.rest.v3.vo;

import java.util.List;


/**
 * Todo need to make this class as the Audience after testing is completed
 */
public class AudienceNewVO {

    private String name;
    private String description;
    private Long accountId;
    private Long userId;
    private List<MappedFields> mappedFields;
    private List<Object> createdFields;
    private List<Object> contacts;
    private String audienceId;
    private String apiKey;


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public List<MappedFields> getMappedFields() {
        return mappedFields;
    }

    public void setMappedFields(List<MappedFields> mappedFields) {
        this.mappedFields = mappedFields;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "AudienceNewVO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", accountId=" + accountId +
                ", userId=" + userId +
                ", mappedFields=" + mappedFields +
                ", createdFields=" + createdFields +
                ", contacts=" + contacts +
                ", audienceId='" + audienceId + '\'' +
                ", apiKey='" + apiKey + '\'' +
                '}';
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
