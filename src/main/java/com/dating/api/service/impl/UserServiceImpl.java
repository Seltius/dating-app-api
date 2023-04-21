package com.dating.api.service.impl;

import com.dating.api.dto.request.AuthRequest;
import com.dating.api.dto.request.RegisterUserRequest;
import com.dating.api.dto.response.AuthResponse;
import com.dating.api.error.exceptions.EmailAlreadyRegisteredException;
import com.dating.api.error.exceptions.InvalidPasswordException;
import com.dating.api.error.exceptions.UserBlockedException;
import com.dating.api.error.exceptions.UserNotFoundException;
import com.dating.api.model.User;
import com.dating.api.repository.UserRepository;
import com.dating.api.service.UserService;
import com.dating.api.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void create(RegisterUserRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent())
            throw new EmailAlreadyRegisteredException();

        createUser(request);

    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(UserNotFoundException::new);

        if (user.getIsBlocked())
            throw new UserBlockedException();

        authValidation(user, request);

        return null;
    }

    private void authValidation(User user, AuthRequest request) {
        int loginAttempts = user.getLoginAttempts() + 1;
        boolean isValidPassword = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (isValidPassword) {
            user.setLoginAttempts(0);
            user.setLastLogin(LocalDateTime.now());
            userRepository.save(user);
        } else {
            user.setLoginAttempts(loginAttempts);

            if (loginAttempts >= 3)
                user.setIsBlocked(true);

            userRepository.save(user);
            throw new InvalidPasswordException();
        }

    }

    private void createUser(RegisterUserRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = UserMapper.INSTANCE.toEntity(request, encodedPassword);
        user.setPassword(encodedPassword);

        userRepository.save(user);

    }

}