package com.asamigas.api.exceptions;

public class EmailAlreadyRegisteredException extends RuntimeException {

    public EmailAlreadyRegisteredException() {
        super("E-mail already registered");
    }

}
