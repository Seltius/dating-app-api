package com.dating.api.controllers;

import com.dating.api.dto.request.AuthRequest;
import com.dating.api.dto.request.RegisterUserRequest;
import com.dating.api.dto.response.AuthResponse;
import com.dating.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(API.BASE_USER)
public class UserController {

    private final UserService userService;

    @PostMapping(API.REGISTER)
    public ResponseEntity<Void> createUser(@RequestBody @Valid RegisterUserRequest request) {
        userService.create(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(API.AUTH)
    public ResponseEntity<AuthResponse> authenticate(@RequestBody @Valid AuthRequest request) {
        return ResponseEntity.ok(userService.authenticate(request));
    }


}
