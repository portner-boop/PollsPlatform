package org.example.springboot.userservice.Api.Service;

import lombok.RequiredArgsConstructor;
import org.example.springboot.userservice.Api.DTO.Request.UserRequest;
import org.example.springboot.userservice.Api.DTO.Response.UserResponse;
import org.example.springboot.userservice.Api.Exception.NotFoundUserException;
import org.example.springboot.userservice.Api.Mapper.UserMapper;
import org.example.springboot.userservice.Data.Entity.User;
import org.example.springboot.userservice.Data.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse getUserById(String id) {
        return userMapper.toUserResponse(userRepository
                .getUserById(id)
                .orElseThrow(()-> new NotFoundUserException("Not found user with id: " + id)));
    }

    public UserResponse createUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);

        return  userMapper.toUserResponse(userRepository.save(user));

    }
}
