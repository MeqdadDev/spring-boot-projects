package com.ks.todoapi.exceptions;

import org.springframework.http.HttpStatus;

public abstract class GlobalException extends RuntimeException{
    public GlobalException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatusCode();
}
