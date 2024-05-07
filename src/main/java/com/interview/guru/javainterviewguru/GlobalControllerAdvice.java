package com.interview.guru.javainterviewguru;

import com.interview.guru.javainterviewguru.exception.ExceptionResponse;
import com.interview.guru.javainterviewguru.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<ExceptionResponse> handleUserNotFound(Exception exception, WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), HttpStatus.FOUND.value(), LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response
        ,HttpStatus.NOT_FOUND);
    }
}
