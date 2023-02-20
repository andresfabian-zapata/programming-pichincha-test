package com.programmingtest.clientservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    private static final String RESOURCE_NOT_FOUND = "RESOURCE NOT FOUND";

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(
                RESOURCE_NOT_FOUND,
                ex.getResourceName(),
                ex.getFieldName(),
                ex.getFieldValue(),
                ex.getCause()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}