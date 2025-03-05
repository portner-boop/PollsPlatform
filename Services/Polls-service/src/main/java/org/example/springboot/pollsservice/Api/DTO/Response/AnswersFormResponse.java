package org.example.springboot.pollsservice.Api.DTO.Response;

import lombok.Builder;

import java.util.List;

@Builder
public record AnswersFormResponse(

        Long pollId,
        List<AnswerResponseToForm> listOfAnswers
) {
}
