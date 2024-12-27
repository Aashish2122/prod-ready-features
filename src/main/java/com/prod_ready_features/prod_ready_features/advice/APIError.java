package com.prod_ready_features.prod_ready_features.advice;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class APIError {
    private LocalDateTime timestamp;
    private String error;
    private HttpStatus statusCode;

    public APIError() {
        this.timestamp = LocalDateTime.now();
    }

    public APIError(String error, HttpStatus statusCode) {
        this();
        this.error = error;
        this.statusCode = statusCode;
    }
}
