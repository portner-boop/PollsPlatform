package org.example.springboot.analyticsservice.Api.DTO.RestObject;


import lombok.Builder;

import java.util.List;

@Builder
public record QuestionAnalytics(
         Long id,

         String question,

         List<AnswerAnalytics> answers
) {
}
