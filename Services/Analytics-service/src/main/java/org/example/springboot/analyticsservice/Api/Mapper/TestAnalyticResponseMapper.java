package org.example.springboot.analyticsservice.Api.Mapper;

import lombok.RequiredArgsConstructor;
import org.example.springboot.analyticsservice.Api.DTO.Analytic.QuestionAnalytic;
import org.example.springboot.analyticsservice.Api.DTO.Analytic.TestAnalyticResponse;
import org.example.springboot.analyticsservice.Api.DTO.RestObject.PollAnalytics;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestAnalyticResponseMapper {

    private final QuestionAnalyticMapper questionAnalyticMapper;

    public TestAnalyticResponse toTestAnalyticResponse(PollAnalytics pollAnalytics) {
        List<QuestionAnalytic> questionAnalytics = pollAnalytics
                .questions()
                .stream()
                .map(questionAnalyticMapper::toQuestionAnalytic)
                .toList();

        return TestAnalyticResponse
                .builder()
                .pollId(pollAnalytics.id())
                .questionAnalyticList(questionAnalytics)
                .build();
    }


}
