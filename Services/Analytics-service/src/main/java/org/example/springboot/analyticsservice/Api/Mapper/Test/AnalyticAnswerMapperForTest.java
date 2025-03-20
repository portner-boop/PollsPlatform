package org.example.springboot.analyticsservice.Api.Mapper.Test;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.springboot.analyticsservice.Api.DTO.Analytic.AnalyticAnswer;
import org.example.springboot.analyticsservice.Api.DTO.RestObject.AnswerAnalytics;
import org.example.springboot.analyticsservice.Api.DTO.RestObject.QuestionAnalytics;
import org.example.springboot.analyticsservice.Data.Repository.AnswerRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnalyticAnswerMapperForTest {

    private final AnswerRepository answerRepository;
    @Transactional
    public AnalyticAnswer toAnalyticAnswer(AnswerAnalytics answerAnalytics, QuestionAnalytics questionAnalytics) {

        Long questionId = questionAnalytics.id();
        Long countOfAnswers = answerRepository.countAnswersByQuestionIdAndAnswer(questionId,answerAnalytics.answer());
        return AnalyticAnswer
                .builder()
                .answer(answerAnalytics.answer())
                .correctness(answerAnalytics.correctness())
                .countOfAnswers(countOfAnswers)
                .build();

    }
}
