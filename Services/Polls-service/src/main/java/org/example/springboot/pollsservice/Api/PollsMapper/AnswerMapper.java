package org.example.springboot.pollsservice.Api.PollsMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.springboot.pollsservice.Api.DTO.Request.AnswerRequest;
import org.example.springboot.pollsservice.Api.DTO.Request.AnswerRequestToForm;
import org.example.springboot.pollsservice.Api.DTO.Response.AnswerResponse;
import org.example.springboot.pollsservice.Api.DTO.Response.AnswerResponseToForm;
import org.example.springboot.pollsservice.Api.Exceptions.NotFoundAnswerException;
import org.example.springboot.pollsservice.Data.Entities.Answer;
import org.example.springboot.pollsservice.Data.Repository.AnswerRepository;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AnswerMapper {

    private final AnswerRepository answerRepository;

        public AnswerResponse mapToAnswerResponse(Answer answer) {
            return new AnswerResponse(
                    answer.getId(),
                    answer.getAnswer(),
                    answer.getCorrectness()
            );
        }

    public Answer mapToAnswer(AnswerRequest answerRequest) {
        Answer answer = new Answer();
        answer.setAnswer(answerRequest.getAnswer());
        answer.setCorrectness(answerRequest.getCorrectness());
        return answer;
    }

    @Transactional
    public AnswerResponseToForm mapToAnswerResponseForm(AnswerRequestToForm answerRequest) {
        Answer answer =answerRepository
                .findById(answerRequest.getAnswerId())
                .orElseThrow(() -> new NotFoundAnswerException("Answer not found"));

        return new AnswerResponseToForm(
                answer.getQuestion().getId(),
                answerRequest.getAnswerId(),
                answer.getAnswer(),
                answer.getCorrectness()

        );
    }
}
