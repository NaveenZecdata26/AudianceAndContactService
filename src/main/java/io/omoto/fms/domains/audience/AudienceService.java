package io.omoto.fms.domains.audience;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AudienceService {
    Audience saveAsDocument(Audience audience);
    boolean isHeadersAreValid(MultipartFile file) throws IOException;
    List<Audience.Bean> getAllAudience(Audience audience);
    Audience getAudienceByApiKey(Audience audience);
    void saveAudience(Audience audience);
    Audience.UserDefinedFields getUserDefinedFields(long accountId);
    void updateAudience(Audience audience);
    void deleteAudience(Audience audience);



}
