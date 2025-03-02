package org.example.springboot.pollsservice.Api.DTO.Request;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.springboot.pollsservice.Data.Entities.Answer;
import org.example.springboot.pollsservice.Data.Entities.Poll;

import java.util.List;

@Data
public class QuestionRequest {
    @NotNull
    @NotEmpty(message = "Fill this please")
    private String question;

    @NotNull
    @NotEmpty(message = "Fill this please")
    private List<AnswerRequest> answers;
}
