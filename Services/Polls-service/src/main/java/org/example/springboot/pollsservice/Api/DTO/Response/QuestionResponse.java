package org.example.springboot.pollsservice.Api.DTO.Response;

import lombok.Builder;

import java.util.List;

@Builder
public record QuestionResponse(
        Long id,

        String question,

        List<AnswerResponse> answers
) {}
