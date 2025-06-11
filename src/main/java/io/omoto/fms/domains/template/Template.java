package io.omoto.fms.domains.template;

import java.util.List;

/**
 * Created by Venkatesh Gowda on 21/2/18.
 */
public class Template {
    private String fullName;
    private String email;
    private String type;
    private String templateContent;
    private String fromEmail;
    private String subject;
    private String templateHtmlFileName;
    private List<MergeTag> mergeTags;
    private String templateLink;

    public String getTemplateLink() {
        return templateLink;
    }

    public void setTemplateLink(String templateLink) {
        this.templateLink = templateLink;
    }

    public List<MergeTag> getMergeTags() {
        return mergeTags;
    }

    public void setMergeTags(List<MergeTag> mergeTags) {
        this.mergeTags = mergeTags;
    }

    public String getTemplateHtmlFileName() {
        return templateHtmlFileName;
    }

    public void setTemplateHtmlFileName(String templateHtmlFileName) {
        this.templateHtmlFileName = templateHtmlFileName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class MergeTag {
        private String key;
        private String value;

        public MergeTag(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}
