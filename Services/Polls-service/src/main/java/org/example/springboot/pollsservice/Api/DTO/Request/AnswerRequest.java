package org.example.springboot.pollsservice.Api.DTO.Request;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnswerRequest {

    @NotNull
    @NotEmpty(message = "Fill this please")
    private String answer;


    @NotEmpty(message = "Fill this please")
    boolean correctness;



}
