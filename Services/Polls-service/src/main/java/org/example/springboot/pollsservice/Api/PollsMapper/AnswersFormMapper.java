package org.example.springboot.pollsservice.Api.PollsMapper;

import lombok.RequiredArgsConstructor;
import org.example.springboot.pollsservice.Api.DTO.Request.AnswersFormRequest;
import org.example.springboot.pollsservice.Api.DTO.Response.AnswerResponseToForm;
import org.example.springboot.pollsservice.Api.DTO.Response.AnswersFormResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AnswersFormMapper {

    private final AnswerMapper answerMapper;

    public AnswersFormResponse toAnswersFormResponse(AnswersFormRequest answersFormRequest) {
        List<AnswerResponseToForm> listOfAnswerResponses = answersFormRequest
                .getAnswers()
                .stream()
                .map(answerMapper::mapToAnswerResponseForm)
                .toList();
        return new AnswersFormResponse(answersFormRequest.getPollId(),
                answersFormRequest.getType(),answersFormRequest.getId(), listOfAnswerResponses);

    }
}
