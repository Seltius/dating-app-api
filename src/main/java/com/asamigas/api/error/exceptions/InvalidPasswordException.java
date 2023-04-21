package com.asamigas.api.error.exceptions;

import static com.asamigas.api.error.ErrorMessages.INVALID_PASSWORD_MESSAGE;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(){
        super(INVALID_PASSWORD_MESSAGE);
    }

}
