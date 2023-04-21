package com.dating.api.error;

import com.dating.api.error.exceptions.EmailAlreadyRegisteredException;
import com.dating.api.error.exceptions.InvalidPasswordException;
import com.dating.api.error.exceptions.UserBlockedException;
import com.dating.api.error.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.dating.api.error.ErrorMessages.*;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleUserAlreadyExistsException(EmailAlreadyRegisteredException ex) {
        return new ErrorResponse(EMAIL_ALREADY_EXISTS, ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleUserNotFoundException(UserNotFoundException ex) {
        return new ErrorResponse(USER_NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorResponse handleInvalidPasswordException(InvalidPasswordException ex) {
        return new ErrorResponse(INVALID_PASSWORD, ex.getMessage());
    }

    @ExceptionHandler(UserBlockedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorResponse handleUserBlockedException(UserBlockedException ex) {
        return new ErrorResponse(USER_BLOCKED, ex.getMessage());
    }

    public record ErrorResponse (String errorCode, String errorMessage){}

}
