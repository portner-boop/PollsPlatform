package org.example.springboot.pollsservice.Api.DTO.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.springboot.pollsservice.Data.Entities.TypeOfAnswer;

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
    @NotEmpty(message = "Fill this please")
    TypeOfAnswer typeOfAnswer;

    @NotNull
    @NotEmpty
    List<QuestionRequest> questions;



}
