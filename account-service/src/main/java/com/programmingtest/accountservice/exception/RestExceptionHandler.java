package com.programmingtest.accountservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

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

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorGeneralResponse> handleException(Exception ex) {
        ErrorGeneralResponse error = new ErrorGeneralResponse();
        error.setMessage("Error interno del servidor");
        error.setErrors(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}