package com.dating.api.service;

import com.dating.api.dto.request.AuthRequest;
import com.dating.api.dto.request.RegisterUserRequest;
import com.dating.api.dto.response.AuthResponse;

public interface UserService {

    void create(RegisterUserRequest request);

    AuthResponse authenticate(AuthRequest request);

}
