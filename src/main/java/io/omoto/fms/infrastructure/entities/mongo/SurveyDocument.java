package io.omoto.fms.infrastructure.entities.mongo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Venkatesh Gowda on 8/2/18.
 */
@Document(collection = "surveyDocument")
public class SurveyDocument {

    /**
     * surveyContent : {"pages":[{"pageName":"Welcome page","properties":{"buttonText":"Get started!","subHeadingValue":"Thank You for choosing Royal Bahrain Hospital as your healthcare partner. In order to serve you better, we would like to request you to kindly provide us with your valuable feedback on our services. The information will be strictly utilized for quality improvement purposes and shall have no bearing on your treatment in any way. Wishing You Good Health!","headingValue":"Greetings from Royal Bahrain Hospital!","backgroundImage":"Image url"}},{"questions":[{"question":"Question 1","attributes":{"image":"url","variables":[],"description":"Description of the question","vertical":true,"video":"url","multipleChoice":true,"randomize":false,"required":true,"others":false},"questionId":1,"choices":[{"questionId":1,"text":"Choice 1"},{"questionId":2,"text":"Choice 2"},{"questionId":3,"text":"Choice 3"},{"questionId":4,"text":"Choice 4"}],"questionType":"Choice"},{"question":"Question 2","attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":2,"questionType":"Yes No"},{"question":"Question 3","attributes":{"image":"url","variables":[],"maxCharacter":12,"description":"Description of the question","video":"url","required":true},"questionId":3,"questionType":"Short Text"},{"question":"Question 4","attributes":{"image":"url","variables":[],"maxCharacter":12,"description":"Description of the question","video":"url","required":true},"questionId":4,"questionType":"Long Text"},{"question":"Question 5","attributes":{"image":"url","buttonText":"Done","variables":[],"description":"Description of the question","video":"url","quotation":true,"required":true},"questionId":5,"questionType":"Statement"},{"question":"Question 6","attributes":{"image":"url","variables":[],"randomise":true,"description":"Description of the question","video":"url","multipleChoice":true,"required":true},"questionId":6,"questionType":"Picture Choice","pictures":[{"questionId":1,"picture":"Picture URL"},{"questionId":2,"picture":"Picture URL"},{"questionId":3,"picture":"Picture URL"},{"questionId":4,"picture":"Picture URL"},{"questionId":5,"picture":"Picture URL"}]},{"question":"Question 7","attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"Email"},{"question":"Question 7","attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"Rating"},{"question":"Question 8","attributes":{"image":"url","variables":[],"leftLabel":"Unlikely","description":"Description of the question","startScaleAt":0,"centerLabel":"","video":"url","rightLabel":"Likely","required":true},"questionId":6,"questionType":"Nps"},{"question":"Question 9","attributes":{"image":"url","variables":[],"shape":"Star","description":"Description of the question","video":"url","steps":5,"stepLabels":["Very good","Good","Average","Poor","Very Poor"],"required":true},"questionId":6,"questionType":"Rating"},{"question":"Question 10","attributes":{"image":"url","variables":[],"dateFormat":"DDMMYYYY","description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"Date"},{"question":"Question 12","attributes":{"image":"url","variables":[],"maximumNumber":10,"description":"Description of the question","video":"url","minimumNumber":1,"required":true},"questionId":6,"questionType":"Number"},{"question":"Question 13","attributes":{"image":"url","variables":[],"defaultCountryCode":91,"maximumNumber":10,"description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"Phone"},{"question":"Question 14","attributes":{"image":"url","variables":[],"alphabeticalSort":true,"defaultCountryCode":91,"description":"Description of the question","video":"url","required":true},"questionId":6,"choices":[{"questionId":1,"text":"Choice 1"},{"questionId":2,"text":"Choice 2"},{"questionId":3,"text":"Choice 3"},{"questionId":4,"text":"Choice 4"}],"questionType":"Drop Down"},{"question":"Question 15","attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"Legal"},{"question":"Question 15","attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"File Upload"},{"question":"Question 17","attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"website"},{"question":"Question 18","rankingItems":[{"questionId":1,"text":"Apple"},{"questionId":2,"text":"Mango"},{"questionId":3,"text":"Orange"},{"questionId":4,"text":"Grapes"},{"questionId":5,"text":"Banana"}],"attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"Ranking"},{"question":"Question 18","columns":[{"questionId":1,"label":"label 1","value":"1"},{"questionId":1,"label":"label 2","value":"2"},{"questionId":1,"label":"label 3","value":"3"},{"questionId":1,"label":"label 4","value":"4"},{"questionId":1,"label":"label 5","value":"5"}],"attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"rows":[{"questionId":1,"text":"Name 1"},{"questionId":1,"text":"Name 2"},{"questionId":1,"text":"Name 3"},{"questionId":1,"text":"Name 4"}],"questionType":"Matrix-Radio"},{"question":"Question 19","columns":[{"questionId":1,"label":"label 1","value":"1"},{"questionId":1,"label":"label 2","value":"2"},{"questionId":1,"label":"label 3","value":"3"},{"questionId":1,"label":"label 4","value":"4"},{"questionId":1,"label":"label 5","value":"5"}],"attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"rows":[{"questionId":1,"text":"Name 1"},{"questionId":1,"text":"Name 2"},{"questionId":1,"text":"Name 3"},{"questionId":1,"text":"Name 4"}],"questionType":"Matrix-Checkbox"},{"question":"Question 21","addressForm":[{"text":"Street 1","required":true},{"text":"Street 2","required":false},{"text":"City","required":false},{"text":"State","required":false},{"text":"Country","required":false},{"text":"Zip code","required":true}],"attributes":{"image":"url","variables":[],"description":"Description of the question","includeAddressForm":true,"video":"url"},"questionId":6,"questionType":"Contact Form","contactForm":[{"text":"First name","required":true},{"text":"Last name","required":false},{"text":"Email","required":true},{"text":"Phone","required":false}]},{"question":"Question 22","addressForm":[{"text":"Street 1","required":true},{"text":"Street 2","required":false},{"text":"City","required":false},{"text":"State","required":false},{"text":"Country","required":false},{"text":"Zip code","required":true}],"attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url"},"questionId":6,"questionType":"Address Form"}],"pageName":"Questionnaire page"},{"pageName":"Thank you page","properties":{"headingValue":"Thank you for your feedback. Our team will get in touch with you for any further assistance required on the feedback","backgroundImage":"Image url"}}],"name":"Name of the survey","description":"Description of the survey"}
     * themeId : Document questionId of theme saved in mongo db
     * questionId : 123
     * userId : 123233
     *
     * logoUrl : url
     */
    @Id
    private String id;
    private SurveyContentEntity surveyContent;
    private ChatBotSurveyContentBean chatBotSurveyContent;
    private String logoUrl;
    private Long accountId;
    private Long createdBy;
    private String themeId;
    private Long updatedBy;
    private Settings settings;
    private String surveyType;
    private Long impressions = 0l;

    public Long getImpressions() {
        return impressions;
    }

    public void setImpressions(Long impressions) {
        this.impressions = impressions;
    }

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @Override
    public String toString() {
        return "SurveyDocument{" +
                "id='" + id + '\'' +
                ", surveyContent=" + surveyContent +
                ", chatBotSurveyContent=" + chatBotSurveyContent +
                ", logoUrl='" + logoUrl + '\'' +
                ", accountId=" + accountId +
                ", createdBy=" + createdBy +
                ", themeId='" + themeId + '\'' +
                ", updatedBy=" + updatedBy +
                ", settings=" + settings +
                ", surveyType='" + surveyType + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    public ChatBotSurveyContentBean getChatBotSurveyContent() {
        return chatBotSurveyContent;
    }

    public void setChatBotSurveyContent(ChatBotSurveyContentBean chatBotSurveyContent) {
        this.chatBotSurveyContent = chatBotSurveyContent;
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

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static class ChatBotSurveyContentBean{

        private String name;
        private String description;
        private SurveyProperties surveyProperties;
        private List<Object> surveyPages;

        public List<Object> getSurveyPages() {
            return surveyPages;
        }

        public void setSurveyPages(List<Object> surveyPages) {
            this.surveyPages = surveyPages;
        }

        public SurveyProperties getSurveyProperties() {
            return surveyProperties;
        }

        public void setSurveyProperties(SurveyProperties surveyProperties) {
            this.surveyProperties = surveyProperties;
        }

        public static  class SurveyProperties{

            /**
             * surveyAttributes : {"npsLabels":{"leftLabel":"Unlikely","rightLabel":"Likely"}}
             * isOmotoBrandingEnabled : true
             * organizationLogo : https://cdn.omoto.io/Omoto_circles_logo.png
             * surveyThemes : {"backgroundColor":"#f2f3f5","textColorSecondary":"#4a4a4a","primaryColorDark":"#048C96","textColorPrimary":"#ffffff","primaryColor":"#37bfc9","primaryButtonTextColor":"#ffffff"}
             */
            private SurveyAttributesEntity surveyAttributes;
            private boolean isOmotoBrandingEnabled;
            private String organizationLogo;
            private SurveyThemesEntity surveyThemes;


            public void setIsOmotoBrandingEnabled(boolean isOmotoBrandingEnabled) {
                this.isOmotoBrandingEnabled = isOmotoBrandingEnabled;
            }

            public void setOrganizationLogo(String organizationLogo) {
                this.organizationLogo = organizationLogo;
            }

            public boolean isIsOmotoBrandingEnabled() {
                return isOmotoBrandingEnabled;
            }

            public String getOrganizationLogo() {
                return organizationLogo;
            }

            public SurveyAttributesEntity getSurveyAttributes() {
                return surveyAttributes;
            }

            public void setSurveyAttributes(SurveyAttributesEntity surveyAttributes) {
                this.surveyAttributes = surveyAttributes;
            }

            public boolean isOmotoBrandingEnabled() {
                return isOmotoBrandingEnabled;
            }

            public void setOmotoBrandingEnabled(boolean omotoBrandingEnabled) {
                isOmotoBrandingEnabled = omotoBrandingEnabled;
            }

            public SurveyThemesEntity getSurveyThemes() {
                return surveyThemes;
            }

            public void setSurveyThemes(SurveyThemesEntity surveyThemes) {
                this.surveyThemes = surveyThemes;
            }

            public static class SurveyAttributesEntity {
                /**
                 * npsLabels : {"leftLabel":"Unlikely","rightLabel":"Likely"}
                 */
                private NpsLabelsEntity npsLabels;

                public NpsLabelsEntity getNpsLabels() {
                    return npsLabels;
                }

                public void setNpsLabels(NpsLabelsEntity npsLabels) {
                    this.npsLabels = npsLabels;
                }

                public static class NpsLabelsEntity {
                    /**
                     * leftLabel : Unlikely
                     * rightLabel : Likely
                     */
                    private String leftLabel;
                    private String rightLabel;

                    public void setLeftLabel(String leftLabel) {
                        this.leftLabel = leftLabel;
                    }

                    public void setRightLabel(String rightLabel) {
                        this.rightLabel = rightLabel;
                    }

                    public String getLeftLabel() {
                        return leftLabel;
                    }

                    public String getRightLabel() {
                        return rightLabel;
                    }
                }
            }

            public static class SurveyThemesEntity {
                /**
                 * backgroundColor : #f2f3f5
                 * textColorSecondary : #4a4a4a
                 * primaryColorDark : #048C96
                 * textColorPrimary : #ffffff
                 * primaryColor : #37bfc9
                 * primaryButtonTextColor : #ffffff
                 */
                private String backgroundColor;
                private String textColorSecondary;
                private String primaryColorDark;
                private String textColorPrimary;
                private String primaryColor;
                private String primaryButtonTextColor;

                public void setBackgroundColor(String backgroundColor) {
                    this.backgroundColor = backgroundColor;
                }

                public void setTextColorSecondary(String textColorSecondary) {
                    this.textColorSecondary = textColorSecondary;
                }

                public void setPrimaryColorDark(String primaryColorDark) {
                    this.primaryColorDark = primaryColorDark;
                }

                public void setTextColorPrimary(String textColorPrimary) {
                    this.textColorPrimary = textColorPrimary;
                }

                public void setPrimaryColor(String primaryColor) {
                    this.primaryColor = primaryColor;
                }

                public void setPrimaryButtonTextColor(String primaryButtonTextColor) {
                    this.primaryButtonTextColor = primaryButtonTextColor;
                }

                public String getBackgroundColor() {
                    return backgroundColor;
                }

                public String getTextColorSecondary() {
                    return textColorSecondary;
                }

                public String getPrimaryColorDark() {
                    return primaryColorDark;
                }

                public String getTextColorPrimary() {
                    return textColorPrimary;
                }

                public String getPrimaryColor() {
                    return primaryColor;
                }

                public String getPrimaryButtonTextColor() {
                    return primaryButtonTextColor;
                }
            }
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

    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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

    public void setSurveyContent(SurveyContentEntity surveyContent) {
        this.surveyContent = surveyContent;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public SurveyContentEntity getSurveyContent() {
        return surveyContent;
    }

    public String getId() {
        return id;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public static class SurveyContentEntity {
        /**
         * pages : [{"pageName":"Welcome page","properties":{"buttonText":"Get started!","subHeadingValue":"Thank You for choosing Royal Bahrain Hospital as your healthcare partner. In order to serve you better, we would like to request you to kindly provide us with your valuable feedback on our services. The information will be strictly utilized for quality improvement purposes and shall have no bearing on your treatment in any way. Wishing You Good Health!","headingValue":"Greetings from Royal Bahrain Hospital!","backgroundImage":"Image url"}},{"questions":[{"question":"Question 1","attributes":{"image":"url","variables":[],"description":"Description of the question","vertical":true,"video":"url","multipleChoice":true,"randomize":false,"required":true,"others":false},"questionId":1,"choices":[{"questionId":1,"text":"Choice 1"},{"questionId":2,"text":"Choice 2"},{"questionId":3,"text":"Choice 3"},{"questionId":4,"text":"Choice 4"}],"questionType":"Choice"},{"question":"Question 2","attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":2,"questionType":"Yes No"},{"question":"Question 3","attributes":{"image":"url","variables":[],"maxCharacter":12,"description":"Description of the question","video":"url","required":true},"questionId":3,"questionType":"Short Text"},{"question":"Question 4","attributes":{"image":"url","variables":[],"maxCharacter":12,"description":"Description of the question","video":"url","required":true},"questionId":4,"questionType":"Long Text"},{"question":"Question 5","attributes":{"image":"url","buttonText":"Done","variables":[],"description":"Description of the question","video":"url","quotation":true,"required":true},"questionId":5,"questionType":"Statement"},{"question":"Question 6","attributes":{"image":"url","variables":[],"randomise":true,"description":"Description of the question","video":"url","multipleChoice":true,"required":true},"questionId":6,"questionType":"Picture Choice","pictures":[{"questionId":1,"picture":"Picture URL"},{"questionId":2,"picture":"Picture URL"},{"questionId":3,"picture":"Picture URL"},{"questionId":4,"picture":"Picture URL"},{"questionId":5,"picture":"Picture URL"}]},{"question":"Question 7","attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"Email"},{"question":"Question 7","attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"Rating"},{"question":"Question 8","attributes":{"image":"url","variables":[],"leftLabel":"Unlikely","description":"Description of the question","startScaleAt":0,"centerLabel":"","video":"url","rightLabel":"Likely","required":true},"questionId":6,"questionType":"Nps"},{"question":"Question 9","attributes":{"image":"url","variables":[],"shape":"Star","description":"Description of the question","video":"url","steps":5,"stepLabels":["Very good","Good","Average","Poor","Very Poor"],"required":true},"questionId":6,"questionType":"Rating"},{"question":"Question 10","attributes":{"image":"url","variables":[],"dateFormat":"DDMMYYYY","description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"Date"},{"question":"Question 12","attributes":{"image":"url","variables":[],"maximumNumber":10,"description":"Description of the question","video":"url","minimumNumber":1,"required":true},"questionId":6,"questionType":"Number"},{"question":"Question 13","attributes":{"image":"url","variables":[],"defaultCountryCode":91,"maximumNumber":10,"description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"Phone"},{"question":"Question 14","attributes":{"image":"url","variables":[],"alphabeticalSort":true,"defaultCountryCode":91,"description":"Description of the question","video":"url","required":true},"questionId":6,"choices":[{"questionId":1,"text":"Choice 1"},{"questionId":2,"text":"Choice 2"},{"questionId":3,"text":"Choice 3"},{"questionId":4,"text":"Choice 4"}],"questionType":"Drop Down"},{"question":"Question 15","attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"Legal"},{"question":"Question 15","attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"File Upload"},{"question":"Question 17","attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"website"},{"question":"Question 18","rankingItems":[{"questionId":1,"text":"Apple"},{"questionId":2,"text":"Mango"},{"questionId":3,"text":"Orange"},{"questionId":4,"text":"Grapes"},{"questionId":5,"text":"Banana"}],"attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"questionType":"Ranking"},{"question":"Question 18","columns":[{"questionId":1,"label":"label 1","value":"1"},{"questionId":1,"label":"label 2","value":"2"},{"questionId":1,"label":"label 3","value":"3"},{"questionId":1,"label":"label 4","value":"4"},{"questionId":1,"label":"label 5","value":"5"}],"attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"rows":[{"questionId":1,"text":"Name 1"},{"questionId":1,"text":"Name 2"},{"questionId":1,"text":"Name 3"},{"questionId":1,"text":"Name 4"}],"questionType":"Matrix-Radio"},{"question":"Question 19","columns":[{"questionId":1,"label":"label 1","value":"1"},{"questionId":1,"label":"label 2","value":"2"},{"questionId":1,"label":"label 3","value":"3"},{"questionId":1,"label":"label 4","value":"4"},{"questionId":1,"label":"label 5","value":"5"}],"attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url","required":true},"questionId":6,"rows":[{"questionId":1,"text":"Name 1"},{"questionId":1,"text":"Name 2"},{"questionId":1,"text":"Name 3"},{"questionId":1,"text":"Name 4"}],"questionType":"Matrix-Checkbox"},{"question":"Question 21","addressForm":[{"text":"Street 1","required":true},{"text":"Street 2","required":false},{"text":"City","required":false},{"text":"State","required":false},{"text":"Country","required":false},{"text":"Zip code","required":true}],"attributes":{"image":"url","variables":[],"description":"Description of the question","includeAddressForm":true,"video":"url"},"questionId":6,"questionType":"Contact Form","contactForm":[{"text":"First name","required":true},{"text":"Last name","required":false},{"text":"Email","required":true},{"text":"Phone","required":false}]},{"question":"Question 22","addressForm":[{"text":"Street 1","required":true},{"text":"Street 2","required":false},{"text":"City","required":false},{"text":"State","required":false},{"text":"Country","required":false},{"text":"Zip code","required":true}],"attributes":{"image":"url","variables":[],"description":"Description of the question","video":"url"},"questionId":6,"questionType":"Address Form"}],"pageName":"Questionnaire page"},{"pageName":"Thank you page","properties":{"headingValue":"Thank you for your feedback. Our team will get in touch with you for any further assistance required on the feedback","backgroundImage":"Image url"}}]
         * name : Name of the survey
         * description : Description of the survey
         */

        private List<PagesEntity> pages;
        private String name;
        private String description;
        private SelectedTheme selectedTheme;
        private String organizationLogo;

        public String getOrganizationLogo() {
            return organizationLogo;
        }

        public void setOrganizationLogo(String organizationLogo) {
            this.organizationLogo = organizationLogo;
        }

        public SelectedTheme getSelectedTheme() {
            return selectedTheme;
        }

        public void setSelectedTheme(SelectedTheme selectedTheme) {
            this.selectedTheme = selectedTheme;
        }

        public void setPages(List<PagesEntity> pages) {
            this.pages = pages;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<PagesEntity> getPages() {
            return pages;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public static class SelectedTheme{

            /**
             * fontFamily : Muli
             * name : Athens Grey
             * isSelected : true
             * colors : {"backgroundColor":"#f2f3f5","textColorSecondary":"#4a4a4a","footerSecondaryColor":"#ffffff","primaryColorDark":"#048C96","footerBackgroundColor":"#f7f8f9","textColorPrimary":"#ffffff","primaryColor":"#37bfc9","primaryButtonTextColor":"#ffffff","footerPrimaryColor":"#b8b9ba"}
             */
            private String name;
            private boolean isSelected;
            private ColorsEntity colors;
            private Font font;
            public Font getFont() {
                return font;
            }

            public void setFont(Font font) {
                this.font = font;
            }

            public static class Font {
                private String name;
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
            public void setName(String name) {
                this.name = name;
            }

            public void setIsSelected(boolean isSelected) {
                this.isSelected = isSelected;
            }

            public void setColors(ColorsEntity colors) {
                this.colors = colors;
            }

            public String getName() {
                return name;
            }

            public boolean isIsSelected() {
                return isSelected;
            }

            public ColorsEntity getColors() {
                return colors;
            }

            public class ColorsEntity {
                /**
                 * backgroundColor : #f2f3f5
                 * textColorSecondary : #4a4a4a
                 * footerSecondaryColor : #ffffff
                 * primaryColorDark : #048C96
                 * footerBackgroundColor : #f7f8f9
                 * textColorPrimary : #ffffff
                 * primaryColor : #37bfc9
                 * primaryButtonTextColor : #ffffff
                 * footerPrimaryColor : #b8b9ba
                 */
                private String backgroundColor;
                private String textColorSecondary;
                private String footerSecondaryColor;
                private String primaryColorDark;
                private String footerBackgroundColor;
                private String textColorPrimary;
                private String primaryColor;
                private String primaryButtonTextColor;
                private String footerPrimaryColor;

                public void setBackgroundColor(String backgroundColor) {
                    this.backgroundColor = backgroundColor;
                }

                public void setTextColorSecondary(String textColorSecondary) {
                    this.textColorSecondary = textColorSecondary;
                }

                public void setFooterSecondaryColor(String footerSecondaryColor) {
                    this.footerSecondaryColor = footerSecondaryColor;
                }

                public void setPrimaryColorDark(String primaryColorDark) {
                    this.primaryColorDark = primaryColorDark;
                }

                public void setFooterBackgroundColor(String footerBackgroundColor) {
                    this.footerBackgroundColor = footerBackgroundColor;
                }

                public void setTextColorPrimary(String textColorPrimary) {
                    this.textColorPrimary = textColorPrimary;
                }

                public void setPrimaryColor(String primaryColor) {
                    this.primaryColor = primaryColor;
                }

                public void setPrimaryButtonTextColor(String primaryButtonTextColor) {
                    this.primaryButtonTextColor = primaryButtonTextColor;
                }

                public void setFooterPrimaryColor(String footerPrimaryColor) {
                    this.footerPrimaryColor = footerPrimaryColor;
                }

                public String getBackgroundColor() {
                    return backgroundColor;
                }

                public String getTextColorSecondary() {
                    return textColorSecondary;
                }

                public String getFooterSecondaryColor() {
                    return footerSecondaryColor;
                }

                public String getPrimaryColorDark() {
                    return primaryColorDark;
                }

                public String getFooterBackgroundColor() {
                    return footerBackgroundColor;
                }

                public String getTextColorPrimary() {
                    return textColorPrimary;
                }

                public String getPrimaryColor() {
                    return primaryColor;
                }

                public String getPrimaryButtonTextColor() {
                    return primaryButtonTextColor;
                }

                public String getFooterPrimaryColor() {
                    return footerPrimaryColor;
                }
            }
        }

        public static class PagesEntity {
            /**
             * pageName : Welcome page
             * properties : {"buttonText":"Get started!","subHeadingValue":"Thank You for choosing Royal Bahrain Hospital as your healthcare partner. In order to serve you better, we would like to request you to kindly provide us with your valuable feedback on our services. The information will be strictly utilized for quality improvement purposes and shall have no bearing on your treatment in any way. Wishing You Good Health!","headingValue":"Greetings from Royal Bahrain Hospital!","backgroundImage":"Image url"}
             */
            @Id
            private String id;
            private String pageName;
            private PropertiesEntity properties;
            private List<QuestionsEntity> questions;

            public List<QuestionsEntity> getQuestions() {
                return questions;
            }

            public void setQuestions(List<QuestionsEntity> questions) {
                this.questions = questions;
            }

            public void setPageName(String pageName) {
                this.pageName = pageName;
            }

            public void setProperties(PropertiesEntity properties) {
                this.properties = properties;
            }

            public String getPageName() {
                return pageName;
            }

            public PropertiesEntity getProperties() {
                return properties;
            }

            public static class PropertiesEntity {
                /**
                 * buttonText : Get started!
                 * subHeadingValue : Thank You for choosing Royal Bahrain Hospital as your healthcare partner. In order to serve you better, we would like to request you to kindly provide us with your valuable feedback on our services. The information will be strictly utilized for quality improvement purposes and shall have no bearing on your treatment in any way. Wishing You Good Health!
                 * headingValue : Greetings from Royal Bahrain Hospital!
                 * backgroundImage : Image url
                 */
                private String buttonText;
                private String subHeadingValue;
                private String headingValue;
                private String backgroundImage;

                @JsonProperty("isSocialShare")
                private String isSocialShare;

                @JsonProperty("isSocialShare")
                public String getIsSocialShare() {
                    return isSocialShare;
                }

                public void setIsSocialShare(String isSocialShare) {
                    this.isSocialShare = isSocialShare;
                }

                public void setButtonText(String buttonText) {
                    this.buttonText = buttonText;
                }

                public void setSubHeadingValue(String subHeadingValue) {
                    this.subHeadingValue = subHeadingValue;
                }

                public void setHeadingValue(String headingValue) {
                    this.headingValue = headingValue;
                }

                public void setBackgroundImage(String backgroundImage) {
                    this.backgroundImage = backgroundImage;
                }

                public String getButtonText() {
                    return buttonText;
                }

                public String getSubHeadingValue() {
                    return subHeadingValue;
                }

                public String getHeadingValue() {
                    return headingValue;
                }

                public String getBackgroundImage() {
                    return backgroundImage;
                }
            }

            public static class QuestionsEntity{

                /**
                 * question : Question 1
                 * attributes : {"image":"url","variables":[],"description":"Description of the question","vertical":true,"video":"url","multipleChoice":true,"randomize":false,"required":true,"others":false}
                 * questionId : 1
                 * choices : [{"questionId":1,"text":"Choice 1"},{"questionId":2,"text":"Choice 2"},{"questionId":3,"text":"Choice 3"},{"questionId":4,"text":"Choice 4"}]
                 * questionType : Choice
                 */
                private String question;
                private String identifier;
                private AttributesEntity attributes;
                private Object logicJumps;
                private List<RowsEntity> rows;
                private List<ColumnsEntity> columns;
                private List<RankingItemsEntity> rankingItems;
                private int questionId;
                private List<ChoicesEntity> choices;
                private List<PicturesEntity> pictures;
                private String questionType;
                private List<ContactFormEntity> contactForm;
                private List<ContactFormEntity> addressForm;

                public String getIdentifier() {
                    return identifier;
                }

                public void setIdentifier(String identifier) {
                    this.identifier = identifier;
                }

                public Object getLogicJumps() {
                    return logicJumps;
                }

                public void setLogicJumps(Object logicJumps) {
                    this.logicJumps = logicJumps;
                }

                public List<ContactFormEntity> getContactForm() {
                    return contactForm;
                }

                public void setContactForm(List<ContactFormEntity> contactForm) {
                    this.contactForm = contactForm;
                }

                public List<ContactFormEntity> getAddressForm() {
                    return addressForm;
                }

                public void setAddressForm(List<ContactFormEntity> addressForm) {
                    this.addressForm = addressForm;
                }

                public List<ColumnsEntity> getColumns() {
                    return columns;
                }

                public void setColumns(List<ColumnsEntity> columns) {
                    this.columns = columns;
                }

                public List<RankingItemsEntity> getRankingItems() {
                    return rankingItems;
                }

                public void setRankingItems(List<RankingItemsEntity> rankingItems) {
                    this.rankingItems = rankingItems;
                }

                public List<RowsEntity> getRows() {
                    return rows;
                }

                public void setRows(List<RowsEntity> rows) {
                    this.rows = rows;
                }

                public List<PicturesEntity> getPictures() {
                    return pictures;
                }

                public void setPictures(List<PicturesEntity> pictures) {
                    this.pictures = pictures;
                }

                public void setQuestion(String question) {
                    this.question = question;
                }

                public void setAttributes(AttributesEntity attributes) {
                    this.attributes = attributes;
                }

                public void setQuestionId(int questionId) {
                    this.questionId = questionId;
                }

                public void setChoices(List<ChoicesEntity> choices) {
                    this.choices = choices;
                }

                public void setQuestionType(String questionType) {
                    this.questionType = questionType;
                }

                public String getQuestion() {
                    return question;
                }

                public AttributesEntity getAttributes() {
                    return attributes;
                }

                public int getQuestionId() {
                    return questionId;
                }

                public List<ChoicesEntity> getChoices() {
                    return choices;
                }

                public String getQuestionType() {
                    return questionType;
                }

                private static class ColumnsEntity{
                    private int columnId;
                    private String label;
                    private String value;

                    public int getColumnId() {
                        return columnId;
                    }

                    public void setColumnId(int columnId) {
                        this.columnId = columnId;
                    }

                    public String getLabel() {
                        return label;
                    }

                    public void setLabel(String label) {
                        this.label = label;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class PicturesEntity {

                    /**
                     * questionId : 1
                     * picture : Picture URL
                     */
                    private int pictureId;
                    private String picture;

                    public void setPictureId(int pictureId) {
                        this.pictureId = pictureId;
                    }

                    public void setPicture(String picture) {
                        this.picture = picture;
                    }

                    public int getPictureId() {
                        return pictureId;
                    }

                    public String getPicture() {
                        return picture;
                    }
                }

                public static class ContactFormEntity{
                    private String label;
                    private String type;
                    private String value;
                    private String keyName;
                    private Validation validation;

                    public String getKeyName() {
                        return keyName;
                    }

                    public void setKeyName(String keyName) {
                        this.keyName = keyName;
                    }

                    public String getLabel() {
                        return label;
                    }

                    public void setLabel(String label) {
                        this.label = label;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }

                    public Validation getValidation() {
                        return validation;
                    }

                    public void setValidation(Validation validation) {
                        this.validation = validation;
                    }

                    private static class Validation{
                        private boolean required;

                        public boolean isRequired() {
                            return required;
                        }

                        public void setRequired(boolean required) {
                            this.required = required;
                        }
                    }

                }

                public static class AddressFormEntity{
                    private String text;
                    private boolean required;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public boolean isRequired() {
                        return required;
                    }

                    public void setRequired(boolean required) {
                        this.required = required;
                    }
                }


                public static class RowsEntity{
                    private int rowId;
                    private String text;

                    public int getRowId() {
                        return rowId;
                    }

                    public void setRowId(int rowId) {
                        this.rowId = rowId;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class RankingItemsEntity{
                    private int itemId;
                    private String text;

                    public int getItemId() {
                        return itemId;
                    }

                    public void setItemId(int itemId) {
                        this.itemId = itemId;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                public static class Step{
                    private String shape;
                    private String label;
                    private int value;
                    private String shapeFill;

                    public String getShapeFill() {
                        return shapeFill;
                    }

                    public void setShapeFill(String shapeFill) {
                        this.shapeFill = shapeFill;
                    }

                    public String getShape() {
                        return shape;
                    }

                    public void setShape(String shape) {
                        this.shape = shape;
                    }

                    public String getLabel() {
                        return label;
                    }

                    public void setLabel(String label) {
                        this.label = label;
                    }

                    public int getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }
                }

                @Data
                public static class AttributesEntity {
                    /**
                     * image : url
                     * variables : []
                     * description : Description of the question
                     * vertical : true
                     * video : url
                     * multipleChoice : true
                     * randomize : false
                     * required : true
                     * others : false
                     */
                    private String image;
                    private List<?> variables;
                    private String description;
                    private boolean vertical;
                    private String video;
                    private boolean multipleChoice;
                    private boolean randomize;
                    private boolean required;
                    private boolean others;
                    private int maxCharacter;
                    private String buttonText;
                    private boolean quotation;
                    private String shape;
                    private List<String> stepLabels;
                    private String dateFormat;
                    private int minimumNumber;
                    private int maximumNumber;
                    private String defaultCountryCode;
                    private boolean alphabeticalSort;
                    private boolean includeAddressForm;
                    private int startScaleAt;
                    private String leftLabel;
                    private String centerLabel;
                    private String rightLabel;
                    private String ratingIcon;
                    private List<Step> steps;
                    private Map selection;
                    private int maxCharacterCount;
                    private int minCharacterCount;
                    private boolean customizeSteps;


                    public boolean isCustomizeSteps() {
                        return customizeSteps;
                    }

                    public void setCustomizeSteps(boolean customizeSteps) {
                        this.customizeSteps = customizeSteps;
                    }

                    @com.fasterxml.jackson.annotation.JsonProperty("isDescriptionEnabled")
                    private boolean isDescriptionEnabled;
                    private String requiredErrorMessage;

                    @com.fasterxml.jackson.annotation.JsonProperty("isDescriptionEnabled")
                    public boolean isDescriptionEnabled() {
                        return isDescriptionEnabled;
                    }

                    public void setDescriptionEnabled(boolean descriptionEnabled) {
                        isDescriptionEnabled = descriptionEnabled;
                    }

                    public String getRequiredErrorMessage() {
                        return requiredErrorMessage;
                    }

                    public void setRequiredErrorMessage(String requiredErrorMessage) {
                        this.requiredErrorMessage = requiredErrorMessage;
                    }

                    public int getMaxCharacterCount() {
                        return maxCharacterCount;
                    }

                    public void setMaxCharacterCount(int maxCharacterCount) {
                        this.maxCharacterCount = maxCharacterCount;
                    }

                    public int getMinCharacterCount() {
                        return minCharacterCount;
                    }

                    public void setMinCharacterCount(int minCharacterCount) {
                        this.minCharacterCount = minCharacterCount;
                    }

                    public Map getSelection() {
                        return selection;
                    }

                    public void setSelection(Map selection) {
                        this.selection = selection;
                    }

                    public String getRatingIcon() {
                        return ratingIcon;
                    }

                    public void setRatingIcon(String ratingIcon) {
                        this.ratingIcon = ratingIcon;
                    }

                    public List<Step> getSteps() {
                        return steps;
                    }

                    public void setSteps(List<Step> steps) {
                        this.steps = steps;
                    }

                    public int getStartScaleAt() {
                        return startScaleAt;
                    }

                    public void setStartScaleAt(int startScaleAt) {
                        this.startScaleAt = startScaleAt;
                    }

                    public String getLeftLabel() {
                        return leftLabel;
                    }

                    public void setLeftLabel(String leftLabel) {
                        this.leftLabel = leftLabel;
                    }

                    public String getCenterLabel() {
                        return centerLabel;
                    }

                    public void setCenterLabel(String centerLabel) {
                        this.centerLabel = centerLabel;
                    }

                    public String getRightLabel() {
                        return rightLabel;
                    }

                    public void setRightLabel(String rightLabel) {
                        this.rightLabel = rightLabel;
                    }

                    public boolean isIncludeAddressForm() {
                        return includeAddressForm;
                    }

                    public void setIncludeAddressForm(boolean includeAddressForm) {
                        this.includeAddressForm = includeAddressForm;
                    }

                    public boolean isAlphabeticalSort() {
                        return alphabeticalSort;
                    }

                    public void setAlphabeticalSort(boolean alphabeticalSort) {
                        this.alphabeticalSort = alphabeticalSort;
                    }

                    public String getDefaultCountryCode() {
                        return defaultCountryCode;
                    }

                    public void setDefaultCountryCode(String defaultCountryCode) {
                        this.defaultCountryCode = defaultCountryCode;
                    }

                    public int getMinimumNumber() {
                        return minimumNumber;
                    }

                    public void setMinimumNumber(int minimumNumber) {
                        this.minimumNumber = minimumNumber;
                    }

                    public int getMaximumNumber() {
                        return maximumNumber;
                    }

                    public void setMaximumNumber(int maximumNumber) {
                        this.maximumNumber = maximumNumber;
                    }

                    public String getDateFormat() {
                        return dateFormat;
                    }

                    public void setDateFormat(String dateFormat) {
                        this.dateFormat = dateFormat;
                    }

                    public List<String> getStepLabels() {
                        return stepLabels;
                    }

                    public void setStepLabels(List<String> stepLabels) {
                        this.stepLabels = stepLabels;
                    }

                    public String getShape() {
                        return shape;
                    }

                    public void setShape(String shape) {
                        this.shape = shape;
                    }

                    public String getButtonText() {
                        return buttonText;
                    }

                    public void setButtonText(String buttonText) {
                        this.buttonText = buttonText;
                    }

                    public boolean isQuotation() {
                        return quotation;
                    }

                    public void setQuotation(boolean quotation) {
                        this.quotation = quotation;
                    }

                    public int getMaxCharacter() {
                        return maxCharacter;
                    }

                    public void setMaxCharacter(int maxCharacter) {
                        this.maxCharacter = maxCharacter;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public void setVariables(List<?> variables) {
                        this.variables = variables;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public void setVertical(boolean vertical) {
                        this.vertical = vertical;
                    }

                    public void setVideo(String video) {
                        this.video = video;
                    }

                    public void setMultipleChoice(boolean multipleChoice) {
                        this.multipleChoice = multipleChoice;
                    }

                    public void setRandomize(boolean randomize) {
                        this.randomize = randomize;
                    }

                    public void setRequired(boolean required) {
                        this.required = required;
                    }

                    public void setOthers(boolean others) {
                        this.others = others;
                    }

                    public String getImage() {
                        return image;
                    }

                    public List<?> getVariables() {
                        return variables;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public boolean isVertical() {
                        return vertical;
                    }

                    public String getVideo() {
                        return video;
                    }

                    public boolean isMultipleChoice() {
                        return multipleChoice;
                    }

                    public boolean isRandomize() {
                        return randomize;
                    }

                    public boolean isRequired() {
                        return required;
                    }

                    public boolean isOthers() {
                        return others;
                    }
                }

                public static class LogicJumpsEntity{


                    /**
                     * blocks : [{"that":3,"conditions":[{"relationWithNextCondition":"&&","this":1,"_if":"=="},{"relationWithNextCondition":null,"this":2,"_if":"=="}]}]
                     */
                    private List<BlocksEntity> blocks;
                    private int defaultJump;
                    private int defaultJumpIndex;

                    public int getDefaultJumpIndex() {
                        return defaultJumpIndex;
                    }

                    public void setDefaultJumpIndex(int defaultJumpIndex) {
                        this.defaultJumpIndex = defaultJumpIndex;
                    }

                    public int getDefaultJump() {
                        return defaultJump;
                    }

                    public void setDefaultJump(int defaultJump) {
                        this.defaultJump = defaultJump;
                    }

                    public void setBlocks(List<BlocksEntity> blocks) {
                        this.blocks = blocks;
                    }

                    public List<BlocksEntity> getBlocks() {
                        return blocks;
                    }

                    public static class BlocksEntity {
                        /**
                         * that : 3
                         * conditions : [{"relationWithNextCondition":"&&","this":1,"_if":"=="},{"relationWithNextCondition":null,"this":2,"_if":"=="}]
                         */
                        private int that;
                        private int thatIndex;
                        private List<ConditionsEntity> conditions;

                        public int getThatIndex() {
                            return thatIndex;
                        }

                        public void setThatIndex(int thatIndex) {
                            this.thatIndex = thatIndex;
                        }

                        public void setThat(int that) {
                            this.that = that;
                        }

                        public void setConditions(List<ConditionsEntity> conditions) {
                            this.conditions = conditions;
                        }

                        public int getThat() {
                            return that;
                        }

                        public List<ConditionsEntity> getConditions() {
                            return conditions;
                        }

                        public static class ConditionsEntity {
                            /**
                             * relationWithNextCondition : &&
                             * this : 1
                             * if : ==
                             */

                            private String relationWithNextCondition;

                            private String _this;

                            private int _thisIndex;

                            private int _if;

                            private int _ifIndex;

                            private String condition;

                            public int get_thisIndex() {
                                return _thisIndex;
                            }

                            public void set_thisIndex(int _thisIndex) {
                                this._thisIndex = _thisIndex;
                            }

                            public int get_ifIndex() {
                                return _ifIndex;
                            }

                            public void set_ifIndex(int _ifIndex) {
                                this._ifIndex = _ifIndex;
                            }

                            public String getRelationWithNextCondition() {
                                return relationWithNextCondition;
                            }

                            public void setRelationWithNextCondition(String relationWithNextCondition) {
                                this.relationWithNextCondition = relationWithNextCondition;
                            }

                            public String get_this() {
                                return _this;
                            }

                            public void set_this(String _this) {
                                this._this = _this;
                            }

                            public int get_if() {
                                return _if;
                            }

                            public void set_if(int _if) {
                                this._if = _if;
                            }

                            public String getCondition() {
                                return condition;
                            }

                            public void setCondition(String condition) {
                                this.condition = condition;
                            }
                        }
                    }
                }

                public static class ChoicesEntity {
                    /**
                     * questionId : 1
                     * text : Choice 1
                     */
                    private int choiceId;
                    private String text;
                    private String identifier;

                    public String getIdentifier() {
                        return identifier;
                    }

                    public void setIdentifier(String identifier) {
                        this.identifier = identifier;
                    }

                    public void setChoiceId(int choiceId) {
                        this.choiceId = choiceId;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public int getChoiceId() {
                        return choiceId;
                    }

                    public String getText() {
                        return text;
                    }
                }
            }
        }
    }

    public static class Settings{

        private String surveyDocumentId;

        private SurveySettings surveySettings;

        private NotificationSettings notificationSettings;

        public String getSurveyDocumentId() {
            return surveyDocumentId;
        }

        public void setSurveyDocumentId(String surveyDocumentId) {
            this.surveyDocumentId = surveyDocumentId;
        }

        public SurveySettings getSurveySettings ()
        {
            return surveySettings;
        }

        public void setSurveySettings (SurveySettings surveySettings)
        {
            this.surveySettings = surveySettings;
        }

        public NotificationSettings getNotificationSettings ()
        {
            return notificationSettings;
        }

        public void setNotificationSettings (NotificationSettings notificationSettings)
        {
            this.notificationSettings = notificationSettings;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [surveySettings = "+surveySettings+", notificationSettings = "+notificationSettings+"]";
        }


        public class NotificationSettings
        {
            private boolean addRespondentDetailsToEmailBody;

            private boolean getNotificationOnEachResponse;

            private String emailBody;

            private boolean getInAppNotification;

            private String[] emailNotificationRecipients;

            private boolean getEmailNotification;

            public boolean isAddRespondentDetailsToEmailBody() {
                return addRespondentDetailsToEmailBody;
            }

            public void setAddRespondentDetailsToEmailBody(boolean addRespondentDetailsToEmailBody) {
                this.addRespondentDetailsToEmailBody = addRespondentDetailsToEmailBody;
            }

            public boolean isGetNotificationOnEachResponse() {
                return getNotificationOnEachResponse;
            }

            public void setGetNotificationOnEachResponse(boolean getNotificationOnEachResponse) {
                this.getNotificationOnEachResponse = getNotificationOnEachResponse;
            }

            public String getEmailBody() {
                return emailBody;
            }

            public void setEmailBody(String emailBody) {
                this.emailBody = emailBody;
            }

            public boolean isGetInAppNotification() {
                return getInAppNotification;
            }

            public void setGetInAppNotification(boolean getInAppNotification) {
                this.getInAppNotification = getInAppNotification;
            }

            public String[] getEmailNotificationRecipients() {
                return emailNotificationRecipients;
            }

            public void setEmailNotificationRecipients(String[] emailNotificationRecipients) {
                this.emailNotificationRecipients = emailNotificationRecipients;
            }

            public boolean isGetEmailNotification() {
                return getEmailNotification;
            }

            public void setGetEmailNotification(boolean getEmailNotification) {
                this.getEmailNotification = getEmailNotification;
            }

            @Override
            public String toString() {
                return "NotificationSettings{" +
                        "addRespondentDetailsToEmailBody=" + addRespondentDetailsToEmailBody +
                        ", getNotificationOnEachResponse=" + getNotificationOnEachResponse +
                        ", emailBody='" + emailBody + '\'' +
                        ", getInAppNotification=" + getInAppNotification +
                        ", emailNotificationRecipients=" + Arrays.toString(emailNotificationRecipients) +
                        ", getEmailNotification=" + getEmailNotification +
                        '}';
            }
        }

        public class SurveySettings {
            private Integer coolOfPeriod;

            private boolean redirectionOnCompletion;

            private boolean isOmotoBranding;

            private boolean allowMultipleResponses;

            private String redirectionUrl;

            public Integer getCoolOfPeriod() {
                return coolOfPeriod;
            }

            public void setCoolOfPeriod(Integer coolOfPeriod) {
                this.coolOfPeriod = coolOfPeriod;
            }

            public boolean isRedirectionOnCompletion() {
                return redirectionOnCompletion;
            }

            public void setRedirectionOnCompletion(boolean redirectionOnCompletion) {
                this.redirectionOnCompletion = redirectionOnCompletion;
            }

            public boolean isOmotoBranding() {
                return isOmotoBranding;
            }

            public void setOmotoBranding(boolean omotoBranding) {
                isOmotoBranding = omotoBranding;
            }

            public boolean isAllowMultipleResponses() {
                return allowMultipleResponses;
            }

            public void setAllowMultipleResponses(boolean allowMultipleResponses) {
                this.allowMultipleResponses = allowMultipleResponses;
            }

            public String getRedirectionUrl() {
                return redirectionUrl;
            }

            public void setRedirectionUrl(String redirectionUrl) {
                this.redirectionUrl = redirectionUrl;
            }

            @Override
            public String toString() {
                return "SurveySettings{" +
                        "coolOfPeriod=" + coolOfPeriod +
                        ", redirectionOnCompletion=" + redirectionOnCompletion +
                        ", isOmotoBranding=" + isOmotoBranding +
                        ", allowMultipleResponses=" + allowMultipleResponses +
                        ", redirectionUrl='" + redirectionUrl + '\'' +
                        '}';
            }
        }


    }
}
