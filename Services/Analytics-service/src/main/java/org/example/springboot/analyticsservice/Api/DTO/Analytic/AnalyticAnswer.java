package org.example.springboot.analyticsservice.Api.DTO.Analytic;

import lombok.Builder;

@Builder
public record AnalyticAnswer(
        String answer,
        Long countOfAnswers,
        Boolean correctness
        ) {
}
