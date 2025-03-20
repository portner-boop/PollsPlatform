package org.example.springboot.userservice.Api.DTO.Request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.example.springboot.userservice.Data.Entity.LocalRole;



@Data
@Builder
public class UserRequest {
    @NotNull
    String id;




    @NotNull(message = "Email must not be null")
    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must  be valid")
    String email;

    @NotNull(message = "LocalRole must not be null")
    LocalRole localRole;
}
