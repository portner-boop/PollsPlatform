package org.example.springboot.pollsservice.Api.PollsMapper;

import org.example.springboot.pollsservice.Api.DTO.Response.PollsResponse.AnswerResponse;
import org.example.springboot.pollsservice.Data.Entities.Answer;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {

    public AnswerResponse toAnswerResponse(Answer answer) {
        return AnswerResponse
                .builder()
                .id(answer.getId())
                .answer(answer.getAnswer())
                .correctness(answer.isCorrectness())
                .build();
    }
}
