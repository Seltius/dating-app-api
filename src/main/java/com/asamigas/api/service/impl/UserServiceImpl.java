package com.asamigas.api.service.impl;

import com.asamigas.api.dto.request.RegisterUserRequest;
import com.asamigas.api.exceptions.EmailAlreadyRegisteredException;
import com.asamigas.api.service.mapper.UserMapper;
import com.asamigas.api.model.User;
import com.asamigas.api.repository.UserRepository;
import com.asamigas.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createUser(RegisterUserRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent())
            throw new EmailAlreadyRegisteredException();

        storeUser(request);

    }

    private void storeUser(RegisterUserRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = UserMapper.INSTANCE.toEntity(request, encodedPassword);
        user.setPassword(encodedPassword);

        userRepository.save(user);

    }

}