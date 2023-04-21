package com.asamigas.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleUserAlreadyExistsException(EmailAlreadyRegisteredException ex) {
        return new ErrorResponse("EMAIL_ALREADY_EXISTS", ex.getMessage());
    }


}
