package org.example.springboot.pollsservice.Api.DTO.Response;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record PollResponse(
        Long id,
        String title,
        String description,
        LocalDateTime dateOfCreation,
        List<QuestionResponse> questions
) {}




