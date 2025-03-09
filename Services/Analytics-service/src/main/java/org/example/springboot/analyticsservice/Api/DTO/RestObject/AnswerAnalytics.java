package org.example.springboot.analyticsservice.Api.DTO.RestObject;

import lombok.Builder;

@Builder
public record AnswerAnalytics(
         Long id,
         String answer,
         boolean correctness
) {
}
