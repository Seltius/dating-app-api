package com.dating.api.error;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorMessages {

    public static final String EMAIL_ALREADY_EXISTS = "EMAIL_ALREADY_EXISTS";
    public static final String EMAIL_ALREADY_EXISTS_MESSAGE = "E-Mail already registered";


    public static final String USER_NOT_FOUND = "USER_NOT_FOUND";
    public static final String USER_NOT_FOUND_MESSAGE = "Unregistered User";


    public static final String INVALID_PASSWORD = "INVALID_PASSWORD";
    public static final String INVALID_PASSWORD_MESSAGE = "Invalid Password";


    public static final String USER_BLOCKED = "USER_BLOCK";
    public static final String USER_BLOCKED_MESSAGE = "Blocked User";
}
