package com.asamigas.api.error.exceptions;

import static com.asamigas.api.error.ErrorMessages.USER_NOT_FOUND_MESSAGE;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(){
        super(USER_NOT_FOUND_MESSAGE);
    }

}
