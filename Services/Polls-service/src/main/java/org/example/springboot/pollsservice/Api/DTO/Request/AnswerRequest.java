package org.example.springboot.pollsservice.Api.DTO.Request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnswerRequest {

    @NotNull(message = "Answer must not be null")
    @NotEmpty(message = "Answer must not be empty")
    private String answer;

    private Boolean correctness;


    public Boolean isCorrectness() {
        return correctness;
    }
}
