package com.jee.Exceptions;

public class UserAlreadyExisteException extends RuntimeException{
    public UserAlreadyExisteException(String message) {
        super(message);
    }
}
