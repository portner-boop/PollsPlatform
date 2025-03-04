package org.example.springboot.userservice.Data.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "user_table", schema = "user_bd")
public class User {

    @Id
    String id;

    LocalRole localRole;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @CreationTimestamp
    LocalDateTime CreationDate;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    String email;

}
