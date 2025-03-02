package org.example.springboot.pollsservice.Api.DTO.Response;

import lombok.Builder;
import org.example.springboot.pollsservice.Data.Entities.Question;

@Builder
public record AnswerResponse(
        Long id,
        String answer,
        boolean correctness
) {}
