package io.omoto.fms.infrastructure.entities.mysql;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "audience_user_defined_fields")
@Table(name = "audience_user_defined_fields",
        uniqueConstraints= @UniqueConstraint(columnNames={"account_id", "field_name", "audience_id", "field_display_name"}))

public class AudienceUserDefinedFields {

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

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "audience_id")
    private String audienceId;

    @Column(name = "field_name")
    private String fieldName;

    @Column(name = "field_display_name")
    private String fieldDisplayName;


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

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldDisplayName() {
        return fieldDisplayName;
    }

    public void setFieldDisplayName(String fieldDisplayName) {
        this.fieldDisplayName = fieldDisplayName;
    }

    public String getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(String audienceId) {
        this.audienceId = audienceId;
    }
}
