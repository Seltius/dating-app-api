package com.dating.api.error.exceptions;

import com.dating.api.error.ErrorMessages;

public class EmailAlreadyRegisteredException extends RuntimeException {

    public EmailAlreadyRegisteredException() {
        super(ErrorMessages.EMAIL_ALREADY_EXISTS_MESSAGE);
    }

}
