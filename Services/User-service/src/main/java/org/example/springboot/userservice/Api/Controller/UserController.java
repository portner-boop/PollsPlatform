package org.example.springboot.userservice.Api.Controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.springboot.userservice.Api.DTO.Request.UserRequest;
import org.example.springboot.userservice.Api.DTO.Response.UserResponse;
import org.example.springboot.userservice.Api.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class UserController {

    UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id){
        return  ResponseEntity.ok(userService.getUserById(id)) ;
    }

    @PostMapping("/user/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody @Validated UserRequest userRequest){
        return ResponseEntity.ok(userService.createUser(userRequest));
    }
}
