package com.example.api.exceptions;

public class ReviewNotFoundException extends RuntimeException{
    private static final long serialVersion = 2;
    public ReviewNotFoundException(String message){
        super(message);

    }
}
