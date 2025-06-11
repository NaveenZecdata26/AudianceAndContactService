package io.omoto.fms.infrastructure.adapters.scheduler.impl;

import com.google.gson.Gson;
import io.omoto.fms.commons.constants.UrlConstants;
import io.omoto.fms.infrastructure.adapters.scheduler.Schedule;
import io.omoto.fms.infrastructure.adapters.scheduler.Scheduler;
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
public class FlowSchedulerImpl implements Scheduler {

    @Override
    public String schedule(Schedule schedule) {
        //System.out.println("Inside schedule impl!!!!!!!!!!!");
        System.out.println(new Gson().toJson(schedule));
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        HttpEntity request = new HttpEntity(schedule, headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(UrlConstants.FLOW_BASE_URL +"/scheduler/schedule");

        ResponseEntity<String> apiResponse = restTemplate.exchange(builder.build().encode().toUri(),
                HttpMethod.POST,
                request, String.class);
        HttpStatus statusCode = apiResponse.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            return "Success";
        } else return "Failure";
    }
}
