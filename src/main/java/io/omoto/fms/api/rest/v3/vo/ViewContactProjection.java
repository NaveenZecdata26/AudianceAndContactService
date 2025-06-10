package io.omoto.fms.api.rest.v3.vo;

public interface ViewContactProjection {
    String getFirstName();
    String getLastName();
    String getPhone();
    String getEmail();

    default String getPhoneNumber() {
        return getPhone();
    }

    default String getEmailID() {
        return getEmail();
    }
}
