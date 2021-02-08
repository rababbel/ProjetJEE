package com.jee.Exceptions;

public class FileAdditionFailedException extends RuntimeException{

    public FileAdditionFailedException(String message) {
        super(message);
    }
}
