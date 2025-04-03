package org.example.springboot.pollsservice.Api.DTO.Request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnswerRequestToForm {
    @NotNull(message = "AnswerId must not be null")
    Long answerId;
}
