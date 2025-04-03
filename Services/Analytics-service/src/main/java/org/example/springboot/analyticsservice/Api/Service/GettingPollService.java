package org.example.springboot.analyticsservice.Api.Service;

import lombok.RequiredArgsConstructor;

import org.example.springboot.analyticsservice.Api.DTO.RestObject.PollAnalytics;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class GettingPollService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8001/api/v1/polls/poll/";

    public PollAnalytics getPollById(Long id){
        String url = baseUrl + id;
        return restTemplate.getForObject(url,PollAnalytics.class);
    }
}
