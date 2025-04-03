package org.example.springboot.analyticsservice.Api.Mapper.Analytic;


import lombok.RequiredArgsConstructor;
import org.example.springboot.analyticsservice.Api.DTO.Analytic.AnalyticAnswer;
import org.example.springboot.analyticsservice.Api.DTO.Analytic.QuestionAnalytic;
import org.example.springboot.analyticsservice.Api.DTO.RestObject.QuestionAnalytics;
import org.example.springboot.analyticsservice.Api.Mapper.Test.AnalyticAnswerMapperForTest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionAnalyticMapperForAnalytic {
    private final AnalyticAnswerMapperForAnalytic analyticAnswerMapperForAnalytic;


    public QuestionAnalytic toQuestionAnalytic(QuestionAnalytics questionAnalytics) {
        List<AnalyticAnswer> analyticAnswers = questionAnalytics
                .answers()
                .stream()
                .map(e-> analyticAnswerMapperForAnalytic.toAnalyticAnswer(e,questionAnalytics))
                .toList();

        return QuestionAnalytic
                .builder()
                .Question(questionAnalytics.question())
                .QuestionId(questionAnalytics.id())
                .countOfAnswers(analyticAnswers)
                .build();

    }
}
