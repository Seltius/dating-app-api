package com.dating.api.error.exceptions;

import com.dating.api.error.ErrorMessages;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(){
        super(ErrorMessages.USER_NOT_FOUND_MESSAGE);
    }

}
