package com.jee.ExceptionsHandlers;

import com.jee.Beans.ExceptionResponse;
import com.jee.Exceptions.FileAdditionFailedException;
import com.jee.Exceptions.UserAlreadyExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;

@ControllerAdvice
public class UserExceptionsHandler {
    @ExceptionHandler(value={UserAlreadyExisteException.class})
    public ResponseEntity<?> userAlreadyExisteExHandler(UserAlreadyExisteException e){
        ExceptionResponse response = new ExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST,new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value={FileAdditionFailedException.class})
    public ResponseEntity<?> fileAdditionFailedHandler(FileAdditionFailedException e){
        ExceptionResponse response = new ExceptionResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
