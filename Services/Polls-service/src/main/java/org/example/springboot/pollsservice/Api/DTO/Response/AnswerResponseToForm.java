package org.example.springboot.pollsservice.Api.DTO.Response;

import lombok.Builder;

@Builder
public record AnswerResponseToForm(
        Long questionId,

        Long id,

        String answer,

        Boolean correctness
) {
}
