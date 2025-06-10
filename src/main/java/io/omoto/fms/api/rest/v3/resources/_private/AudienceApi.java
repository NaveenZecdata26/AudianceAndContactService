package io.omoto.fms.api.rest.v3.resources._private;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/private/audience")
@CrossOrigin("*")
public class AudienceApi {
    public static final String AUDIENCE_CREATION_CONTEXT = "Audience creation context";

}
