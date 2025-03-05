package org.example.springboot.userservice.Api.DTO.Response;

import lombok.Builder;
import org.example.springboot.userservice.Data.Entity.LocalRole;

import java.time.LocalDateTime;

@Builder
public record UserResponse(

        String id,

        LocalRole role,

        LocalDateTime creationDate,

        String email

) {
}
