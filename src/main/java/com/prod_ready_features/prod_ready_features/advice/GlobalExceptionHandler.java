package com.prod_ready_features.prod_ready_features.advice;

import com.prod_ready_features.prod_ready_features.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIError> handleResourceNotFound(ResourceNotFoundException ex) {
        APIError apiError = new APIError(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
}