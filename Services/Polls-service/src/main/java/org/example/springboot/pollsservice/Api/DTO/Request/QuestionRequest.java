package org.example.springboot.pollsservice.Api.DTO.Request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.util.List;

@Data
public class QuestionRequest {
    @NotNull(message = "Question must not be null")
    @NotEmpty(message = "Question must not be empty")
    private String question;

    @NotNull(message = "Answers must not be null")
    @NotEmpty(message = "Answers must not be empty ")
    @Valid
    private List<AnswerRequest> answers;
}
