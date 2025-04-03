package org.example.springboot.pollsservice.Api.DTO.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.springboot.pollsservice.Data.Entities.TypeOfPoll;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PollRequest {
    @NotNull(message = "Title must not be null")
    @NotEmpty(message = "Title must not be empty")
    String title;

    @NotNull(message = "Description  must not be null")
    @NotEmpty(message = "Description must not be empty")
    String description;

    @NotNull(message = "TypeOfAnswer must not be null")
    TypeOfPoll typeOfPoll;

    @NotNull(message = "Questions must not be null")
    @NotEmpty(message = "Questions must not be empty")
    List<QuestionRequest> questions;
}
