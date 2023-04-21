package com.asamigas.api.service;

import com.asamigas.api.dto.request.RegisterUserRequest;

public interface UserService {

    void createUser(RegisterUserRequest user);

}
