package io.omoto.fms.domains.survey;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.omoto.fms.api.rest.v3.vo.SurveyVO;
import io.omoto.fms.domains.reports.filter.Filter;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Survey {
    private String surveyDocumentId;
    private String surveyName;
    private String surveyTemplateDocumentId;
    private Long accountId;
    private Long createdBy;
    private Long updatedBy;
    private String themeId;
    private SurveyContentBean surveyContent;
    private ChatBotSurveyContentBean chatBotSurveyContent;
    private String logoUrl;
    private Long token;
    private String respondentIdentifier;
    private boolean testMode;
    private String status;
    private long impressions;
    private long responses;
    private Settings settings;
    private Notification notification;
    private String surveyType;
    private Filter filter;
    private String createdAt;
    private String updatedAt;
    private Long userId;
    private List<String> surveyDocumentIds;

    public ChatBotSurveyContentBean getChatBotSurveyContent() {
        return chatBotSurveyContent;
    }

    public void setChatBotSurveyContent(ChatBotSurveyContentBean chatBotSurveyContent) {
        this.chatBotSurveyContent = chatBotSurveyContent;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getSurveyDocumentIds() {
        return surveyDocumentIds;
    }

    public void setSurveyDocumentIds(List<String> surveyDocumentIds) {
        this.surveyDocumentIds = surveyDocumentIds;
    }

    public static class ChatBotSurveyContentBean{

        private String name;
        private String description;
        private SurveyVO.ChatBotSurveyContentBean.SurveyProperties surveyProperties;
        private List<Object> surveyPages;

        public List<Object> getSurveyPages() {
            return surveyPages;
        }

        public void setSurveyPages(List<Object> surveyPages) {
            this.surveyPages = surveyPages;
        }

        public SurveyVO.ChatBotSurveyContentBean.SurveyProperties getSurveyProperties() {
            return surveyProperties;
        }

        public void setSurveyProperties(SurveyVO.ChatBotSurveyContentBean.SurveyProperties surveyProperties) {
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

            public void setSurveyAttributes(SurveyAttributesEntity surveyAttributes) {
                this.surveyAttributes = surveyAttributes;
            }

            public void setIsOmotoBrandingEnabled(boolean isOmotoBrandingEnabled) {
                this.isOmotoBrandingEnabled = isOmotoBrandingEnabled;
            }

            public void setOrganizationLogo(String organizationLogo) {
                this.organizationLogo = organizationLogo;
            }

            public void setSurveyThemes(SurveyThemesEntity surveyThemes) {
                this.surveyThemes = surveyThemes;
            }

            public SurveyAttributesEntity getSurveyAttributes() {
                return surveyAttributes;
            }

            public boolean isIsOmotoBrandingEnabled() {
                return isOmotoBrandingEnabled;
            }

            public String getOrganizationLogo() {
                return organizationLogo;
            }

            public SurveyThemesEntity getSurveyThemes() {
                return surveyThemes;
            }

            public static class SurveyAttributesEntity {
                /**
                 * npsLabels : {"leftLabel":"Unlikely","rightLabel":"Likely"}
                 */
                private NpsLabelsEntity npsLabels;

                public void setNpsLabels(NpsLabelsEntity npsLabels) {
                    this.npsLabels = npsLabels;
                }

                public NpsLabelsEntity getNpsLabels() {
                    return npsLabels;
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


    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getImpressions() {
        return impressions;
    }

    public void setImpressions(long impressions) {
        this.impressions = impressions;
    }

    public long getResponses() {
        return responses;
    }

    public void setResponses(long responses) {
        this.responses = responses;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getSurveyTemplateDocumentId() {
        return surveyTemplateDocumentId;
    }

    public void setSurveyTemplateDocumentId(String surveyTemplateDocumentId) {
        this.surveyTemplateDocumentId = surveyTemplateDocumentId;
    }

    public Long getToken() {
        return token;
    }

    public void setToken(Long token) {
        this.token = token;
    }

    public String getRespondentIdentifier() {
        return respondentIdentifier;
    }

    public void setRespondentIdentifier(String respondentIdentifier) {
        this.respondentIdentifier = respondentIdentifier;
    }

    public boolean isTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getSurveyDocumentId() {
        return surveyDocumentId;
    }

    public void setSurveyDocumentId(String surveyDocumentId) {
        this.surveyDocumentId = surveyDocumentId;
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

    public SurveyContentBean getSurveyContent() {
        return surveyContent;
    }

    public void setSurveyContent(SurveyContentBean surveyContent) {
        this.surveyContent = surveyContent;
    }

    public static class SurveyContentBean{
        private String name;
        private String description;
        private List<PagesBean> pages;
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

        public List<SurveyContentBean.PagesBean> getPages() {
            return pages;
        }

        public void setPages(List<SurveyContentBean.PagesBean> pages) {
            this.pages = pages;
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

        public static  class PagesBean{

            private String pageId;
            private String pageName;
            private PagesBean.PropertiesBean properties;
            private List<PagesBean.QuestionsBean> questions;


            public List<PagesBean.QuestionsBean> getQuestions() {
                return questions;
            }

            public void setQuestions(List<PagesBean.QuestionsBean> questions) {
                this.questions = questions;
            }

            public String getPageId() {
                return pageId;
            }

            public void setPageId(String pageId) {
                this.pageId = pageId;
            }

            public String getPageName() {
                return pageName;
            }

            public void setPageName(String pageName) {
                this.pageName = pageName;
            }

            public SurveyContentBean.PagesBean.PropertiesBean getProperties() {
                return properties;
            }

            public void setProperties(SurveyContentBean.PagesBean.PropertiesBean properties) {
                this.properties = properties;
            }


            public static class QuestionsBean{
                private Long questionId;
                private String questionType;
                private String question;
                private String identifier;

                private SurveyContentBean.PagesBean.QuestionsBean.AttributesBean attributes;
                private List<SurveyContentBean.PagesBean.QuestionsBean.ChoicesBean> choices;
                private Object logicJumps;


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

                public Long getQuestionId() {
                    return questionId;
                }

                public void setQuestionId(Long questionId) {
                    this.questionId = questionId;
                }

                public String getQuestionType() {
                    return questionType;
                }

                public void setQuestionType(String questionType) {
                    this.questionType = questionType;
                }

                public String getQuestion() {
                    return question;
                }

                public void setQuestion(String question) {
                    this.question = question;
                }

                public SurveyContentBean.PagesBean.QuestionsBean.AttributesBean getAttributes() {
                    return attributes;
                }

                public void setAttributes(SurveyContentBean.PagesBean.QuestionsBean.AttributesBean attributes) {
                    this.attributes = attributes;
                }

                public List<SurveyContentBean.PagesBean.QuestionsBean.ChoicesBean> getChoices() {
                    return choices;
                }

                public void setChoices(List<SurveyContentBean.PagesBean.QuestionsBean.ChoicesBean> choices) {
                    this.choices = choices;
                }

                public static class LogicJumpBean{
                    private List<BlockBean> blocks;
                    private Long defaultJump;
                    private int defaultJumpIndex;

                    public int getDefaultJumpIndex() {
                        return defaultJumpIndex;
                    }

                    public void setDefaultJumpIndex(int defaultJumpIndex) {
                        this.defaultJumpIndex = defaultJumpIndex;
                    }

                    public List<BlockBean> getBlocks() {
                        return blocks;
                    }

                    public void setBlocks(List<BlockBean> blocks) {
                        this.blocks = blocks;
                    }

                    public Long getDefaultJump() {
                        return defaultJump;
                    }

                    public void setDefaultJump(Long defaultJump) {
                        this.defaultJump = defaultJump;
                    }

                    public static class BlockBean{
                        public Long that;
                        private int thatIndex;
                        private List<ConditionBean> conditions;

                        public Long getThat() {
                            return that;
                        }

                        public void setThat(Long that) {
                            this.that = that;
                        }

                        public int getThatIndex() {
                            return thatIndex;
                        }

                        public void setThatIndex(int thatIndex) {
                            this.thatIndex = thatIndex;
                        }

                        public List<ConditionBean> getConditions() {
                            return conditions;
                        }

                        public void setConditions(List<ConditionBean> conditions) {
                            this.conditions = conditions;
                        }

                        public static class ConditionBean{
                            private String condition;
                            private Long _if;
                            private int _ifIndex;
                            private Object _this;
                            private int _thisIndex;
                            private String relationWithNextCondition;


                            public int get_ifIndex() {
                                return _ifIndex;
                            }

                            public void set_ifIndex(int _ifIndex) {
                                this._ifIndex = _ifIndex;
                            }

                            public int get_thisIndex() {
                                return _thisIndex;
                            }

                            public void set_thisIndex(int _thisIndex) {
                                this._thisIndex = _thisIndex;
                            }

                            public String getCondition() {
                                return condition;
                            }

                            public void setCondition(String condition) {
                                this.condition = condition;
                            }

                            public Long get_if() {
                                return _if;
                            }

                            public void set_if(Long _if) {
                                this._if = _if;
                            }

                            public Object get_this() {
                                return _this;
                            }

                            public void set_this(Object _this) {
                                this._this = _this;
                            }

                            public String getRelationWithNextCondition() {
                                return relationWithNextCondition;
                            }

                            public void setRelationWithNextCondition(String relationWithNextCondition) {
                                this.relationWithNextCondition = relationWithNextCondition;
                            }
                        }

                    }
                }

                public static class ChoicesBean{
                    private Long choiceId;
                    private String text;
                    private String identifier;

                    public String getIdentifier() {
                        return identifier;
                    }

                    public void setIdentifier(String identifier) {
                        this.identifier = identifier;
                    }

                    public Long getChoiceId() {
                        return choiceId;
                    }

                    public void setChoiceId(Long choiceId) {
                        this.choiceId = choiceId;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }
                }

                @Data
                public static class AttributesBean{
                    private boolean required;
                    private String description;
                    private String image;
                    private String video;
                    private int startScaleAt;
                    private String leftLabel;
                    private String centerLabel;
                    private String rightLabel;
                    private boolean multipleChoice;
                    private boolean randomize;
                    private boolean others;
                    private boolean vertical;
                    private boolean alphabeticalSort;
                    private String defaultCountryCode;
                    private String ratingIcon;
                    private int maxCharacter;
                    private List<Step> steps;
                    private Map selection;
                    private int maxCharacterCount;
                    private int minCharacterCount;
                    private boolean customizeSteps;
                    private String dateFormat;

                    public String getDateFormat() {
                        return dateFormat;
                    }

                    public void setDateFormat(String dateFormat) {
                        this.dateFormat = dateFormat;
                    }

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

                    public void setDescriptionEnabled(boolean isDescriptionEnabled) {
                        this.isDescriptionEnabled = isDescriptionEnabled;
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

                    public boolean isRequired() {
                        return required;
                    }

                    public void setRequired(boolean required) {
                        this.required = required;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public String getVideo() {
                        return video;
                    }

                    public void setVideo(String video) {
                        this.video = video;
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

                    public boolean isMultipleChoice() {
                        return multipleChoice;
                    }

                    public void setMultipleChoice(boolean multipleChoice) {
                        this.multipleChoice = multipleChoice;
                    }

                    public boolean isRandomize() {
                        return randomize;
                    }

                    public void setRandomize(boolean randomize) {
                        this.randomize = randomize;
                    }

                    public boolean isOthers() {
                        return others;
                    }

                    public void setOthers(boolean others) {
                        this.others = others;
                    }

                    public boolean isVertical() {
                        return vertical;
                    }

                    public void setVertical(boolean vertical) {
                        this.vertical = vertical;
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

                    public int getMaxCharacter() {
                        return maxCharacter;
                    }

                    public void setMaxCharacter(int maxCharacter) {
                        this.maxCharacter = maxCharacter;
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
            }

            public static class PropertiesBean{
                private String headingValue;
                private String subHeadingValue;
                private String backgroundImage;
                private String buttonText;

                @com.fasterxml.jackson.annotation.JsonProperty("isSocialShare")
                private String isSocialShare;

                @JsonProperty("isSocialShare")
                public String getIsSocialShare() {
                    return isSocialShare;
                }

                public void setIsSocialShare(String isSocialShare) {
                    this.isSocialShare = isSocialShare;
                }

                public String getHeadingValue() {
                    return headingValue;
                }

                public void setHeadingValue(String headingValue) {
                    this.headingValue = headingValue;
                }

                public String getSubHeadingValue() {
                    return subHeadingValue;
                }

                public void setSubHeadingValue(String subHeadingValue) {
                    this.subHeadingValue = subHeadingValue;
                }

                public String getBackgroundImage() {
                    return backgroundImage;
                }

                public void setBackgroundImage(String backgroundImage) {
                    this.backgroundImage = backgroundImage;
                }

                public String getButtonText() {
                    return buttonText;
                }

                public void setButtonText(String buttonText) {
                    this.buttonText = buttonText;
                }
            }

        }
    }

    public static class SurveyDetails {
        private String documentId;
        private String type;
        private String status;

        public SurveyDetails(String documentId, String type, String status) {
            this.documentId = documentId;
            this.type = type;
            this.status = status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDocumentId() {
            return documentId;
        }

        public String getType() {
            return type;
        }

        public String getStatus() {
            return status;
        }
    }

/*    public static class Theme {
        private String id;
        private String name;
        private String link;
        private Map properties;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Map getProperties() {
            return properties;
        }

        public void setProperties(Map properties) {
            this.properties = properties;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

    }*/

    public static class SurveyInformation {
        private String name;
        private String description;
        private String status;
        private String documentId;
        private Long accountId;
        private long impressions;
        private long responses;
        private String createDate;

        public String getShortUrl() {
            return shortUrl;
        }

        public void setShortUrl(String shortUrl) {
            this.shortUrl = shortUrl;
        }

        private String shortUrl;

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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDocumentId() {
            return documentId;
        }

        public void setDocumentId(String documentId) {
            this.documentId = documentId;
        }

        public Long getAccountId() {
            return accountId;
        }

        public void setAccountId(Long accountId) {
            this.accountId = accountId;
        }

        public long getImpressions() {
            return impressions;
        }

        public void setImpressions(long impressions) {
            this.impressions = impressions;
        }

        public long getResponses() {
            return responses;
        }

        public void setResponses(long responses) {
            this.responses = responses;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
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

    public static class Notification{
        private Settings settings;

        public Settings getSettings() {
            return settings;
        }

        public void setSettings(Settings settings) {
            this.settings = settings;
        }

        public static class Settings{

            private Long id;
            private boolean notificationOnEachResponse;
            private boolean inAppNotification;
            private boolean emailNotification;
            private String[] emailNotificationRecipients;
            private String  emailSubject;
            private boolean respondentDetailsInEmailBody;
            private String emailBody;

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public boolean isNotificationOnEachResponse() {
                return notificationOnEachResponse;
            }

            public void setNotificationOnEachResponse(boolean notificationOnEachResponse) {
                this.notificationOnEachResponse = notificationOnEachResponse;
            }

            public boolean isInAppNotification() {
                return inAppNotification;
            }

            public void setInAppNotification(boolean inAppNotification) {
                this.inAppNotification = inAppNotification;
            }

            public boolean isEmailNotification() {
                return emailNotification;
            }

            public void setEmailNotification(boolean emailNotification) {
                this.emailNotification = emailNotification;
            }

            public String[] getEmailNotificationRecipients() {
                return emailNotificationRecipients;
            }

            public void setEmailNotificationRecipients(String[] emailNotificationRecipients) {
                this.emailNotificationRecipients = emailNotificationRecipients;
            }

            public String getEmailSubject() {
                return emailSubject;
            }

            public void setEmailSubject(String emailSubject) {
                this.emailSubject = emailSubject;
            }

            public boolean isRespondentDetailsInEmailBody() {
                return respondentDetailsInEmailBody;
            }

            public void setRespondentDetailsInEmailBody(boolean respondentDetailsInEmailBody) {
                this.respondentDetailsInEmailBody = respondentDetailsInEmailBody;
            }

            public String getEmailBody() {
                return emailBody;
            }

            public void setEmailBody(String emailBody) {
                this.emailBody = emailBody;
            }
        }

    }

    public static  class ShortUrlInformation {
        private String shortUrl;
        private String title;
        private String description;
        private String imageUrl;
        private Long identifier;

        public String getShortUrl() {
            return shortUrl;
        }

        public void setShortUrl(String shortUrl) {
            this.shortUrl = shortUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Long getIdentifier() {
            return identifier;
        }

        public void setIdentifier(Long identifier) {
            this.identifier = identifier;
        }
    }

    public static class SurveyThemes {

        /**
         * surveyThemes : [{"fontFamily":"Ubuntu","name":"Athens Grey","colors":{"backgroundColor":"#f2f3f5","textColorSecondary":"#4a4a4a","primaryColorDark":"#048C96","footerBackgroundColor":"#f7f8f9","textColorPrimary":"#ffffff","primaryColor":"#37bfc9","footerPrimaryColor":"#b8b9ba","footerSecondaryColor":"#ffffff"}}]
         */
        private List<SurveyThemesEntity> surveyThemes;

        public void setSurveyThemes(List<SurveyThemesEntity> surveyThemes) {
            this.surveyThemes = surveyThemes;
        }

        public List<SurveyThemesEntity> getSurveyThemes() {
            return surveyThemes;
        }


        public static class SurveyThemesEntity {
            /**
             * fontFamily : Ubuntu
             * name : Athens Grey
             * colors : {"backgroundColor":"#f2f3f5","textColorSecondary":"#4a4a4a","primaryColorDark":"#048C96","footerBackgroundColor":"#f7f8f9","textColorPrimary":"#ffffff","primaryColor":"#37bfc9","footerPrimaryColor":"#b8b9ba","footerSecondaryColor":"#ffffff"}
             */
            private FontEntity font;
            private String name;
            private ColorsEntity colors;


            public void setName(String name) {
                this.name = name;
            }

            public void setColors(ColorsEntity colors) {
                this.colors = colors;
            }


            public String getName() {
                return name;
            }

            public ColorsEntity getColors() {
                return colors;
            }


            public FontEntity getFont() {
                return font;
            }

            public void setFont(FontEntity font) {
                this.font = font;
            }

            public static class FontEntity{
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

            public static class ColorsEntity {
                /**
                 * backgroundColor : #f2f3f5
                 * textColorSecondary : #4a4a4a
                 * primaryColorDark : #048C96
                 * footerBackgroundColor : #f7f8f9
                 * textColorPrimary : #ffffff
                 * primaryColor : #37bfc9
                 * footerPrimaryColor : #b8b9ba
                 * footerSecondaryColor : #ffffff
                 */
                private String backgroundColor;
                private String textColorSecondary;
                private String primaryColorDark;
                private String footerBackgroundColor;
                private String textColorPrimary;
                private String primaryColor;
                private String footerPrimaryColor;
                private String footerSecondaryColor;
                private String primaryButtonTextColor;

                public String getPrimaryButtonTextColor() {
                    return primaryButtonTextColor;
                }

                public void setPrimaryButtonTextColor(String primaryButtonTextColor) {
                    this.primaryButtonTextColor = primaryButtonTextColor;
                }

                public void setBackgroundColor(String backgroundColor) {
                    this.backgroundColor = backgroundColor;
                }

                public void setTextColorSecondary(String textColorSecondary) {
                    this.textColorSecondary = textColorSecondary;
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

                public void setFooterPrimaryColor(String footerPrimaryColor) {
                    this.footerPrimaryColor = footerPrimaryColor;
                }

                public void setFooterSecondaryColor(String footerSecondaryColor) {
                    this.footerSecondaryColor = footerSecondaryColor;
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

                public String getFooterBackgroundColor() {
                    return footerBackgroundColor;
                }

                public String getTextColorPrimary() {
                    return textColorPrimary;
                }

                public String getPrimaryColor() {
                    return primaryColor;
                }

                public String getFooterPrimaryColor() {
                    return footerPrimaryColor;
                }

                public String getFooterSecondaryColor() {
                    return footerSecondaryColor;
                }
            }
        }
    }
}
