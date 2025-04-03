package org.example.springboot.analyticsservice.Api.DTO.Analytic;

import lombok.Builder;

import java.util.List;

@Builder
public record TestAnalyticResponse(
        Long pollId,
        List<QuestionAnalytic> questionAnalyticList
) {
}
