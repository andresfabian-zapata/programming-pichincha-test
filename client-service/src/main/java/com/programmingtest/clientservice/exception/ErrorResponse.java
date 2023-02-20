package com.programmingtest.clientservice.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private String message;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;
    private Throwable cause;
}