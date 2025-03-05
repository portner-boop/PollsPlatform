package org.example.springboot.pollsservice.Api.DTO.Response;

import lombok.Builder;


@Builder
public record AnswerResponse(

        Long id,
        String answer,
        boolean correctness
) {
}
