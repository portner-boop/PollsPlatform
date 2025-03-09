package org.example.springboot.analyticsservice.Api.Mapper;


import lombok.RequiredArgsConstructor;
import org.example.springboot.analyticsservice.Api.DTO.Analytic.AnalyticAnswer;
import org.example.springboot.analyticsservice.Api.DTO.Analytic.QuestionAnalytic;
import org.example.springboot.analyticsservice.Api.DTO.RestObject.AnswerAnalytics;
import org.example.springboot.analyticsservice.Api.DTO.RestObject.QuestionAnalytics;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionAnalyticMapper {
    private final AnalyticAnswerMapper analyticAnswerMapper;


    public QuestionAnalytic toQuestionAnalytic(QuestionAnalytics questionAnalytics) {
        List<AnalyticAnswer> analyticAnswers = questionAnalytics
                .answers()
                .stream()
                .map(e->analyticAnswerMapper.toAnalyticAnswer(e,questionAnalytics))
                .toList();

        return QuestionAnalytic
                .builder()
                .Question(questionAnalytics.question())
                .QuestionId(questionAnalytics.id())
                .countOfAnswers(analyticAnswers)
                .build();

    }
}
