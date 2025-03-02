package org.example.springboot.pollsservice.Api.DTO.Response.PollsResponse;

import lombok.Builder;
import org.example.springboot.pollsservice.Data.Entities.Question;

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




