package com.dating.api.error.exceptions;

import static com.dating.api.error.ErrorMessages.USER_BLOCKED_MESSAGE;

public class UserBlockedException extends RuntimeException {

    public UserBlockedException() {
        super(USER_BLOCKED_MESSAGE);
    }

}
