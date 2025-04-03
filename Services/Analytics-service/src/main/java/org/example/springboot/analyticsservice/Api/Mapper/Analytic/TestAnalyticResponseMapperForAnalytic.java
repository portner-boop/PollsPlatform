package org.example.springboot.analyticsservice.Api.Mapper.Analytic;

import lombok.RequiredArgsConstructor;
import org.example.springboot.analyticsservice.Api.DTO.Analytic.QuestionAnalytic;
import org.example.springboot.analyticsservice.Api.DTO.Analytic.TestAnalyticResponse;
import org.example.springboot.analyticsservice.Api.DTO.RestObject.PollAnalytics;
import org.example.springboot.analyticsservice.Api.Mapper.Test.QuestionAnalyticMapperForTest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestAnalyticResponseMapperForAnalytic {

    private final QuestionAnalyticMapperForAnalytic questionAnalyticMapperForAnalytic;

    public TestAnalyticResponse toTestAnalyticResponse(PollAnalytics pollAnalytics) {
        List<QuestionAnalytic> questionAnalytics = pollAnalytics
                .questions()
                .stream()
                .map(questionAnalyticMapperForAnalytic::toQuestionAnalytic)
                .toList();

        return TestAnalyticResponse
                .builder()
                .pollId(pollAnalytics.id())
                .questionAnalyticList(questionAnalytics)
                .build();
    }


}
