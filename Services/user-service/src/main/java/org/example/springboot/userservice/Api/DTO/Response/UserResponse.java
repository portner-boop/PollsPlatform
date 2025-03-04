package org.example.springboot.userservice.Api.DTO.Response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.example.springboot.userservice.Data.Entity.LocalRole;

import java.time.LocalDateTime;

@Builder
public record UserResponse(

        String id,

        @NotNull
        @NotEmpty
        LocalRole role,
        @NotNull
        @NotEmpty
        LocalDateTime creationDate,
        @NotNull(message = "Email cannot be null")
        @Email(message = "Email should be valid")
        String email

) {
}
