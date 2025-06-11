package io.omoto.fms.infrastructure.repositories.audience;

public interface ContactListener {
    void process(ContactListenerVO contactListenerVO);
}
