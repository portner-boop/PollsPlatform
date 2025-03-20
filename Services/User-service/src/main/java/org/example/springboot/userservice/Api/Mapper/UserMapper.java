package org.example.springboot.userservice.Api.Mapper;

import org.example.springboot.userservice.Api.DTO.Request.UserRequest;
import org.example.springboot.userservice.Api.DTO.Response.UserResponse;
import org.example.springboot.userservice.Data.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toUserResponse(User user){
        return UserResponse
                .builder()
                .role(user.getLocalRole())
                .creationDate(user.getCreationDate())
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }

    public User toUser(UserRequest userRequest){
        return User
                .builder()
                .id(userRequest.getId())
                .email(userRequest.getEmail())
                .localRole(String.valueOf(userRequest.getLocalRole()))
                .build();
    }
}
