package io.omoto.fms.infrastructure.adapters.email.impl;

import com.google.gson.Gson;
import io.omoto.fms.commons.constants.UrlConstants;
import io.omoto.fms.domains.campaign.vo.Campaign;
import io.omoto.fms.infrastructure.adapters.email.Email;
import io.omoto.fms.infrastructure.adapters.email.EmailAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class FlowEmailAdapter implements EmailAdapter<Campaign> {



    private static final Logger LOGGER = LoggerFactory.getLogger(FlowEmailAdapter.class.getName());


    @Override
    public String sendEmail(Email email) {
        LOGGER.info("Sending email");
        System.out.println(new Gson().toJson(email));
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        HttpEntity request = new HttpEntity(email, headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(UrlConstants.FLOW_BASE_URL+"/email/sendEmail");
        builder.queryParam("userId",1);
        builder.queryParam("integrationProviderId",1);

        ResponseEntity<String> apiResponse = restTemplate.exchange(builder.build().encode().toUri(),
                HttpMethod.POST,
                request, String.class);
        LOGGER.info("Api response is : {} ",apiResponse);

        HttpStatus statusCode = apiResponse.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            return "Success";
        } else return "Failure";
    }

}
