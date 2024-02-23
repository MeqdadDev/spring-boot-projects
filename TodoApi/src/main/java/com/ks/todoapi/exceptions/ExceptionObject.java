package com.ks.todoapi.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ExceptionObject {
    private String message;
    private String uri;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    public ExceptionObject(){
        this.timestamp = new Date();
    }
    public ExceptionObject(String message, String uri){
        this();
        this.message = message;
        this.uri = uri;
    }

}
