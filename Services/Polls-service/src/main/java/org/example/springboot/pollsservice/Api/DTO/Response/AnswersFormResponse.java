package org.example.springboot.pollsservice.Api.DTO.Response;

import lombok.Builder;
import org.example.springboot.pollsservice.Data.Entities.TypeOfPoll;

import java.util.List;
import java.util.UUID;

@Builder
public record AnswersFormResponse(
        Long pollId,

        TypeOfPoll typeOfPoll,

        String userId ,

        List<AnswerResponseToForm> listOfAnswers
) {
}
