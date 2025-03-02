package org.example.springboot.pollsservice.Api.PollsMapper;

import org.example.springboot.pollsservice.Api.DTO.Request.AnswerRequest;
import org.example.springboot.pollsservice.Api.DTO.Response.AnswerResponse;
import org.example.springboot.pollsservice.Data.Entities.Answer;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {

    public AnswerResponse mapToAnswerResponse(Answer answer) {
        return new AnswerResponse(
                answer.getId(),
                answer.getAnswer(),
                answer.isCorrectness()
        );
    }

    public Answer mapToAnswer(AnswerRequest answerRequest) {
        Answer answer = new Answer();
        answer.setAnswer(answerRequest.getAnswer());
        answer.setCorrectness(answerRequest.isCorrectness());
        return answer;
    }
}
