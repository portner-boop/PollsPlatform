package org.example.springboot.analyticsservice.Api.DTO.Kafka;

import lombok.Builder;


import java.util.List;
import java.util.UUID;

@Builder
public record AnswersFormRequest(

        Long pollId,

        String typeOfPoll,

        UUID userId,

        List<AnswerRequestToForm> listOfAnswers
) {
}
