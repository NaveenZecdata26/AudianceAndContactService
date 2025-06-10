package io.omoto.fms.domains.audience;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Audience {

    private String name;
    private String description;
    private long accountId;
    private long userId;
    private String contactsJson;
    private boolean createAudience;
    private boolean createContacts;
    private long organisationId;
    private List<AudienceContactMapBean> audienceContactMap;
    private List<AudienceBean> audience;
    private List<MergeTagsBean> mergeTags;
    private ContactInfo contactInfo;
    private String audienceId;
    private String contactId;
    private List<String> audienceIdList;

    private List<MappedFields> mappedFields;
    private List<Object> createdFields;
    private List<Object> contacts;
    private String apiKey;
    private boolean isAutoAudience;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(String audienceId) {
        this.audienceId = audienceId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public List<String> getAudienceIdList() {
        return audienceIdList;
    }

    public void setAudienceIdList(List<String> audienceIdList) {
        this.audienceIdList = audienceIdList;
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

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public boolean isAutoAudience() {
        return isAutoAudience;
    }

    public void setAutoAudience(boolean autoAudience) {
        isAutoAudience = autoAudience;
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


    public static class Bean {

        /**
         * name : Audience 1
         * id : 123
         * contacts : [{"firstName":"Venkatesh","lastName":"Gowda","contactId":1574,"contactDetailsGroupId":"c4895b62-54ae-4882-b1d1-ac4472280420","details":[{"name":"city","value":"Bangalore"}],"email":"vg9231@gmail.com"}]
         */
        private String name;
        private String description;
        private long id;
        private long accountId;
        private List<Contacts> contacts;
        private Long noOfContacts;
        private String createdAt;
        private String updatedAt;
        private String createdBy;
        private String audienceId;
        private float percentage;
        private List<String> campaigns;

        public Bean() {
        }



        public Bean(String name) {
            this.name = name;
        }

        public float getPercentage() {
            return percentage;
        }


        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setPercentage(float percentage) {
            this.percentage = percentage;
        }

        public String getAudienceId() {
            return audienceId;
        }

        public void setAudienceId(String audienceId) {
            this.audienceId = audienceId;
        }

        public Long getNoOfContacts() {
            return noOfContacts;
        }

        public void setNoOfContacts(Long noOfContacts) {
            this.noOfContacts = noOfContacts;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }


        public long getAccountId() {
            return accountId;
        }

        public void setAccountId(long accountId) {
            this.accountId = accountId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setContacts(List<Contacts> contacts) {
            this.contacts = contacts;
        }

        public String getName() {
            return name;
        }

        public long getId() {
            return id;
        }

        public List<Contacts> getContacts() {
            return contacts;
        }

        public List<String> getCampaigns() {
            return campaigns;
        }

        public void setCampaigns(List<String> campaigns) {
            this.campaigns = campaigns;
        }

        public static class Contacts {
            private String firstName;
            private String lastName;
            private long contactId;
            private String identifier;
            private String contactDetailsGroupId;
            private List<Details> details;
            private String email;
            private String gender;
            private Long accountId;
            private Map qualifyingInfo;
            private String phone;
            private String countryCode;
            private String registrationId;
            private long createdBy;
            private long updatedBy;

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


            public String getIdentifier() {
                return identifier;
            }

            public void setIdentifier(String identifier) {
                this.identifier = identifier;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public void setContactId(long contactId) {
                this.contactId = contactId;
            }

            public void setContactDetailsGroupId(String contactDetailsGroupId) {
                this.contactDetailsGroupId = contactDetailsGroupId;
            }

            public void setDetails(List<Details> details) {
                this.details = details;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getFirstName() {
                return firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public long getContactId() {
                return contactId;
            }

            public String getContactDetailsGroupId() {
                return contactDetailsGroupId;
            }

            public List<Details> getDetails() {
                return details;
            }

            public String getEmail() {
                return email;
            }

            public static class Details {
                /**
                 * name : city
                 * value : Bangalore
                 */
                private String name;
                private String value;

                public void setName(String name) {
                    this.name = name;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public String getName() {
                    return name;
                }

                public String getValue() {
                    return value;
                }
            }
        }

    }

    public static class ContactInformation {
        private List<MappedFields> mappedFields;
        private List<Object> audience;
        private List<Object> createdFields;
        private List<ContactInfo.HeaderDataEntity> headerData;
        private Object contactsListData;
        private int totalRecords;

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

        public List<ContactInfo.HeaderDataEntity> getHeaderData() {
            return headerData;
        }

        public void setHeaderData(List<ContactInfo.HeaderDataEntity> headerData) {
            this.headerData = headerData;
        }

        public Object getContactsListData() {
            return contactsListData;
        }

        public void setContactsListData(Object contactsListData) {
            this.contactsListData = contactsListData;
        }

        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }
    }



    public static class ContactInfo {
        private List<MappedFields> mappedFields;
        private List<Object> audience;
        private List<Object> createdFields ;
        private List<HeaderDataEntity> headerData;
        private List<Map> contactsListData;
        private Long totalRecords;


        public List<HeaderDataEntity> getHeaderData() {
            return headerData;
        }

        public void setHeaderData(List<HeaderDataEntity> headerData) {
            this.headerData = headerData;
        }

        public List<Map> getContactsListData() {
            return contactsListData;
        }

        public void setContactsListData(List<Map> contactsListData) {
            this.contactsListData = contactsListData;
        }

        public Long getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(Long totalRecords) {
            this.totalRecords = totalRecords;
        }

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

        public static class HeaderDataEntity {
            private String headerName;
            private String field;
            private Integer width;
            private String valueGetter;
            private String filter;
            private boolean sortable=true;
            private String sort;

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public boolean isSortable() {
                return sortable;
            }

            public void setSortable(boolean sortable) {
                this.sortable = sortable;
            }

            public String getFilter() {
                return filter;
            }

            public void setFilter(String filter) {
                this.filter = filter;
            }

            public String getHeaderName() {
                return headerName;
            }

            public void setHeaderName(String headerName) {
                this.headerName = headerName;
            }

            public String getField() {
                return field;
            }

            public void setField(String field) {
                this.field = field;
            }

            public Integer getWidth() {
                return width;
            }

            public void setWidth(Integer width) {
                this.width = width;
            }

            public String getValueGetter() {
                return valueGetter;
            }

            public void setValueGetter(String valueGetter) {
                this.valueGetter = valueGetter;
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


    public static class UserDefinedFields
    {
        private List<String> userDefinedFields;

        public List<String> getUserDefinedFields() {
            return userDefinedFields;
        }

        public void setUserDefinedFields(List<String> userDefinedFields) {
            this.userDefinedFields = userDefinedFields;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [userDefinedFields = "+userDefinedFields+"]";
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
