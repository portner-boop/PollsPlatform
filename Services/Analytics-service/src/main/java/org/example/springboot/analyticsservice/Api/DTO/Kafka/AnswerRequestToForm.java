package org.example.springboot.analyticsservice.Api.DTO.Kafka;

import lombok.Builder;

@Builder
public record AnswerRequestToForm(

        Long questionId,
        Long id,
        String answer,
        boolean correctness
) {
}
