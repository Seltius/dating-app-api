package com.asamigas.api.error.exceptions;

import static com.asamigas.api.error.ErrorMessages.EMAIL_ALREADY_EXISTS_MESSAGE;

public class EmailAlreadyRegisteredException extends RuntimeException {

    public EmailAlreadyRegisteredException() {
        super(EMAIL_ALREADY_EXISTS_MESSAGE);
    }

}
