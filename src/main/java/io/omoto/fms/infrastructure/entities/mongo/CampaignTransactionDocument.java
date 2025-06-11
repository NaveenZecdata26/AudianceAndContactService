package io.omoto.fms.infrastructure.entities.mongo;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Document
public class CampaignTransactionDocument {
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
    private String campaignDocumentId;
    private String surveyDocumentId;
    private String audienceId;
    private String contactsGroupId;
    private long createdBy;
    private long updatedBy;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    private List<ResponsesEntity> responses;
    private List<QuestionAndAnswer> questionAnsAnswers;
    private boolean isResponseReceived;

    private LocalDateTime responseDate;
    private Long responseDateEpoch;

    private boolean isFavourite;

    public boolean getIsFavourite() {
        return isFavourite;
    }

    private String contactIdentifier;
    private String channel;
    private String responseId;
    private Set<String> tags;
    private String status;
    private String sendStatus;

    @Override
    public String toString() {
        return "CampaignTransactionDocument{" +
                "_id='" + _id + '\'' +
                ", identifier='" + identifier + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", accountId=" + accountId +
                ", firstName='" + firstName + '\'' +
                ", qualifyingInfo=" + qualifyingInfo +
                ", phone='" + phone + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", registrationId='" + registrationId + '\'' +
                ", email='" + email + '\'' +
                ", campaignDocumentId='" + campaignDocumentId + '\'' +
                ", surveyDocumentId='" + surveyDocumentId + '\'' +
                ", audienceId='" + audienceId + '\'' +
                ", contactsGroupId='" + contactsGroupId + '\'' +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", responses=" + responses +
                ", questionAnsAnswers=" + questionAnsAnswers +
                ", isResponseReceived=" + isResponseReceived +
                ", responseDate=" + responseDate +
                ", responseDateEpoch=" + responseDateEpoch +
                ", isFavourite=" + isFavourite +
                ", contactIdentifier='" + contactIdentifier + '\'' +
                ", channel='" + channel + '\'' +
                ", responseId='" + responseId + '\'' +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                ", sendStatus='" + sendStatus + '\'' +
                '}';
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getContactIdentifier() {
        return contactIdentifier;
    }

    public void setContactIdentifier(String contactIdentifier) {
        this.contactIdentifier = contactIdentifier;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
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

    public String getCampaignDocumentId() {
        return campaignDocumentId;
    }

    public void setCampaignDocumentId(String campaignDocumentId) {
        this.campaignDocumentId = campaignDocumentId;
    }

    public String getSurveyDocumentId() {
        return surveyDocumentId;
    }

    public void setSurveyDocumentId(String surveyDocumentId) {
        this.surveyDocumentId = surveyDocumentId;
    }

    public String getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(String audienceId) {
        this.audienceId = audienceId;
    }

    public List<ResponsesEntity> getResponses() {
        return responses;
    }

    public void setResponses(List<ResponsesEntity> responses) {
        this.responses = responses;
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

    public String getContactsGroupId() {
        return contactsGroupId;
    }

    public void setContactsGroupId(String contactsGroupId) {
        this.contactsGroupId = contactsGroupId;
    }

    public List<QuestionAndAnswer> getQuestionAnsAnswers() {
        return questionAnsAnswers;
    }

    public void setQuestionAnsAnswers(List<QuestionAndAnswer> questionAnsAnswers) {
        this.questionAnsAnswers = questionAnsAnswers;
    }

    public boolean isResponseReceived() {
        return isResponseReceived;
    }

    public void setResponseReceived(boolean responseReceived) {
        isResponseReceived = responseReceived;
    }


    public LocalDateTime getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(LocalDateTime responseDate) {
        this.responseDate = responseDate;
    }

    public Long getResponseDateEpoch() {
        return responseDateEpoch;
    }

    public void setResponseDateEpoch(Long responseDateEpoch) {
        this.responseDateEpoch = responseDateEpoch;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public static class ResponsesEntity {
        private Long id;
        private Long questionId;
        private Long questionFamilyId;
        private Integer rating;
        private String ratingText;
        private String answer;
        private String url;
        private Date dateTime;
        private Long surveyResponseId;
        List<QuestionOptions> questionOptions;
        private String question;
        private String countryCode;
        private String questionType;
        private List<ResponsesEntity> matrix;


        public List<ResponsesEntity> getMatrix() {
            return matrix;
        }

        public void setMatrix(List<ResponsesEntity> matrix) {
            this.matrix = matrix;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getQuestionType() {
            return questionType;
        }

        public void setQuestionType(String questionType) {
            this.questionType = questionType;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }

        public Long getQuestionFamilyId() {
            return questionFamilyId;
        }

        public void setQuestionFamilyId(Long questionFamilyId) {
            this.questionFamilyId = questionFamilyId;
        }


        public Integer getRating() {
            return rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }

        public String getRatingText() {
            return ratingText;
        }

        public void setRatingText(String ratingText) {
            this.ratingText = ratingText;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Date getDateTime() {
            return dateTime;
        }

        public void setDateTime(Date dateTime) {
            this.dateTime = dateTime;
        }

        public Long getSurveyResponseId() {
            return surveyResponseId;
        }

        public void setSurveyResponseId(Long surveyResponseId) {
            this.surveyResponseId = surveyResponseId;
        }

        public List<QuestionOptions> getQuestionOptions() {
            return questionOptions;
        }

        public void setQuestionOptions(List<QuestionOptions> questionOptions) {
            this.questionOptions = questionOptions;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public static class QuestionOptions{
            private Long questionOptionId;
            private String option;

            public Long getQuestionOptionId() {
                return questionOptionId;
            }

            public void setQuestionOptionId(Long questionOptionId) {
                this.questionOptionId = questionOptionId;
            }

            public String getOption() {
                return option;
            }

            public void setOption(String option) {
                this.option = option;
            }
        }

        @Override
        public String toString() {
            return "ResponsesEntity{" +
                    "id=" + id +
                    ", questionId=" + questionId +
                    ", questionFamilyId=" + questionFamilyId +
                    ", rating=" + rating +
                    ", ratingText='" + ratingText + '\'' +
                    ", answer='" + answer + '\'' +
                    ", url='" + url + '\'' +
                    ", dateTime=" + dateTime +
                    ", surveyResponseId=" + surveyResponseId +
                    ", questionOptions=" + questionOptions +
                    ", question='" + question + '\'' +
                    ", countryCode='" + countryCode + '\'' +
                    ", questionType='" + questionType + '\'' +
                    ", matrix=" + matrix +
                    '}';
        }
    }

    public static class QuestionAndAnswer{
        private String questionId;
        private String question;
        private Object answer;
        private String type;
        private List answers;

        public List getAnswers() {
            return answers;
        }

        public void setAnswers(List answers) {
            this.answers = answers;
        }


        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getQuestionId() {
            return questionId;
        }

        public void setQuestionId(String questionId) {
            this.questionId = questionId;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public Object getAnswer() {
            return answer;
        }

        public void setAnswer(Object answer) {
            this.answer = answer;
        }
    }


}
