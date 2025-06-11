package io.omoto.fms.api.rest.v3.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Venkatesh Gowda on 14/2/18.
 */
public class AudienceVO implements Serializable {


    /**
     * name : AudienceService 2
     * accountId : 123
     * userId : 1231
     * contacts : sad121212321
     * createAudience : true
     * createContacts : false
     * audienceContactMap : [{"contactId":1,"contactDetailsGroupId":"14f39190-8d1e-4d47-aa96-867d5af19555"},{"contactId":2,"contactDetailsGroupId":"300ce248-d11c-40f7-b01f-adb8dcc88761"}]
     * audience : [{"id":1,"excludeContacts":[2]},{"id":2,"excludeContacts":[1,2,6]}]
     */

    private String name;
    private String description;
    private long accountId;
    private long userId;
    private String contacts;
    private boolean createAudience;
    private boolean createContacts;
    private long organisationId;
    private List<AudienceContactMapBean> audienceContactMap;
    private List<AudienceBean> audience;
    private List<MergeTagsBean> mergeTags;
    private ContactInfo contactInfo;
    private String audienceId;
    private List<String> audienceIdList;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(String audienceId) {
        this.audienceId = audienceId;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<MergeTagsBean> getMergeTags() {
        return mergeTags;
    }

    public void setMergeTags(List<MergeTagsBean> mergeTags) {
        this.mergeTags = mergeTags;
    }

    public long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(long organisationId) {
        this.organisationId = organisationId;
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

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
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

    public List<AudienceContactMapBean> getAudienceContactMap() {
        return audienceContactMap;
    }

    public void setAudienceContactMap(List<AudienceContactMapBean> audienceContactMap) {
        this.audienceContactMap = audienceContactMap;
    }

    public List<AudienceBean> getAudience() {
        return audience;
    }

    public void setAudience(List<AudienceBean> audience) {
        this.audience = audience;
    }

    public List<String> getAudienceIdList() {
        return audienceIdList;
    }

    public void setAudienceIdList(List<String> audienceIdList) {
        this.audienceIdList = audienceIdList;
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

    public static class MergeTagsBean implements Serializable {
        private String displayTagName;
        private String contactProperty;
        private String defaultValue;

        public String getDisplayTagName() {
            return displayTagName;
        }

        public void setDisplayTagName(String displayTagName) {
            this.displayTagName = displayTagName;
        }

        public String getContactProperty() {
            return contactProperty;
        }

        public void setContactProperty(String contactProperty) {
            this.contactProperty = contactProperty;
        }

        public String getDefaultValue() {
            return defaultValue;
        }

        public void setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
        }
    }

    public static class ContactInfo {
        private List<MappedFields> mappedFields;
        private List<Object> audience;
        private List<Object> createdFields ;

        public List<MappedFields> getMappedFields() {
            return mappedFields;
        }

        public void setMappedFields(List<MappedFields> mappedFields) {
            this.mappedFields = mappedFields;
        }

        public List<Object> getAudience() {
            return audience;
        }

        public void setAudience(List<Object> audience) {
            this.audience = audience;
        }

        public List<Object> getCreatedFields() {
            return createdFields;
        }

        public void setCreatedFields(List<Object> createdFields) {
            this.createdFields = createdFields;
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


        @Override
        public String toString() {
            return "ContactInfo{" +
                    "mappedFields=" + mappedFields +
                    ", audience=" + audience +
                    ", createdFields=" + createdFields +
                    '}';
        }
    }
}
