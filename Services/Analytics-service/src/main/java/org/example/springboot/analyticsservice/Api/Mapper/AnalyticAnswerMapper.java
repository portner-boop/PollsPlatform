package org.example.springboot.analyticsservice.Api.Mapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.springboot.analyticsservice.Api.DTO.Analytic.AnalyticAnswer;
import org.example.springboot.analyticsservice.Api.DTO.RestObject.AnswerAnalytics;
import org.example.springboot.analyticsservice.Api.DTO.RestObject.PollAnalytics;
import org.example.springboot.analyticsservice.Api.DTO.RestObject.QuestionAnalytics;
import org.example.springboot.analyticsservice.Data.Entity.Poll;
import org.example.springboot.analyticsservice.Data.Repository.AnswerRepository;
import org.example.springboot.analyticsservice.Data.Repository.PollRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AnalyticAnswerMapper {

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
