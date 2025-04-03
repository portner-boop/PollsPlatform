package org.example.springboot.userservice.Api.DTO.Response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserResponse(

        String id,

        LocalDateTime creationDate,

        String email

) {
}
