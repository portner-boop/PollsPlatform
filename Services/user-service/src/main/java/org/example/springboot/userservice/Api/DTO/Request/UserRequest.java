package org.example.springboot.userservice.Api.DTO.Request;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.example.springboot.userservice.Data.Entity.LocalRole;

import java.time.LocalDateTime;

@Data
@Builder
public class UserRequest {


    LocalRole localRole;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    String email;
}
