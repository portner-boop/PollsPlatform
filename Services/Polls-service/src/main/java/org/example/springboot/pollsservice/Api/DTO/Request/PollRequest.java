package org.example.springboot.pollsservice.Api.DTO.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PollRequest {

    @NotNull
    @NotEmpty(message = "Fill this please")
    String title;

    @NotNull
    @NotEmpty(message = "Fill this please")
    String description;

    @NotNull
    @NotEmpty
    List<QuestionRequest> questions;



}
