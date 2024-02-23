package com.ks.todoapi.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends GlobalException {
    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
