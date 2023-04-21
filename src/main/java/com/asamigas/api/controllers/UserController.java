package com.asamigas.api.controllers;

import com.asamigas.api.dto.request.RegisterUserRequest;
import com.asamigas.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(API.BASE_USER)
public class UserController {

    private final UserService userService;

    @PostMapping(API.REGISTER)
    public ResponseEntity<Void> registerUser(@RequestBody RegisterUserRequest userRequest) { //TODO VALIDATE REQUEST BODY FIELDS
        userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
