package org.example.springboot.analyticsservice.Api.DTO.Analytic;

import lombok.Builder;

import java.util.List;

@Builder
public record QuestionAnalytic(
        Long QuestionId,
        String Question,
        List<AnalyticAnswer> countOfAnswers

) {
}
