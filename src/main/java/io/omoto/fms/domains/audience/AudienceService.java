package io.omoto.fms.domains.audience;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AudienceService {
    boolean isHeadersAreValid(MultipartFile file) throws IOException;

    Audience saveAsDocument(Audience audience);

    Audience.ContactInfo getContacts(Audience audience);

    Audience.ContactInformation getContactsByAudience(Audience audience);

}
