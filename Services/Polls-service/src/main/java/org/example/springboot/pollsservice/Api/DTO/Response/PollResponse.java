package org.example.springboot.pollsservice.Api.DTO.Response;

import lombok.Builder;
import org.example.springboot.pollsservice.Data.Entities.TypeOfPoll;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record PollResponse(
        Long id,

        String title,

        String description,

        LocalDateTime dateOfCreation,

        TypeOfPoll typeOfPoll,

        List<QuestionResponse> questions
) {
}




