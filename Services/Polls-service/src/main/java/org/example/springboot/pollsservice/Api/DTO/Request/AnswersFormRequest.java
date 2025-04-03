package org.example.springboot.pollsservice.Api.DTO.Request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.springboot.pollsservice.Data.Entities.TypeOfPoll;

import java.util.List;

@Data
public class AnswersFormRequest {
    String id;

    Long pollId;

    TypeOfPoll type;

    @NotNull(message = "Answers must not be null")
    @NotEmpty(message = "Answers list cannot be empty")
    @Valid
    List<AnswerRequestToForm> answers;
}
