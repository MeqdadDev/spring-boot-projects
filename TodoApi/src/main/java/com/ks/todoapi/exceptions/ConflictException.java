package com.ks.todoapi.exceptions;

import org.springframework.http.HttpStatus;

public class ConflictException extends GlobalException{
    public ConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
