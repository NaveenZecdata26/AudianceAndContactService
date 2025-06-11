package io.omoto.fms.infrastructure.adapters.email;

public interface EmailAdapter<V> {
    //void convertToEmailProvider(V v);
    //String sendEmail();
    String sendEmail(Email email);
}
