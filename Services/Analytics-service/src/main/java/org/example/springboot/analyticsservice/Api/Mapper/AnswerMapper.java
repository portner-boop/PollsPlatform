package org.example.springboot.analyticsservice.Api.Mapper;


import org.example.springboot.analyticsservice.Api.DTO.Kafka.AnswerRequestToForm;
import org.example.springboot.analyticsservice.Data.Entity.Answer;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {

    public Answer toAnswer(AnswerRequestToForm answerRequestToForm) {
        return Answer
                .builder()
                .answer(answerRequestToForm.answer())
                .answerId(answerRequestToForm.id())
                .correctness(answerRequestToForm.correctness())
                .questionId(answerRequestToForm.questionId())
                .build();
    }
}
