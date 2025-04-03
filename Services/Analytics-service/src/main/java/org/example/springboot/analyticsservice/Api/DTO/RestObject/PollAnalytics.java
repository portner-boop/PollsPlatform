package org.example.springboot.analyticsservice.Api.DTO.RestObject;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record PollAnalytics(
        Long id,

        String title,

        LocalDateTime dateOfCreation,

        String description,

        String typeOfPoll,

        List<QuestionAnalytics> questions) {
}
