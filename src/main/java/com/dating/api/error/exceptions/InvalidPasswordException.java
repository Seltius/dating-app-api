package com.dating.api.error.exceptions;

import com.dating.api.error.ErrorMessages;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException() {
        super(ErrorMessages.INVALID_PASSWORD_MESSAGE);
    }

}
