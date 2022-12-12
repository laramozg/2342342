package com.example.web4.exceptions;

public class InvalidParameterException extends RuntimeException{
    public InvalidParameterException(String massage){
        super(massage);
    }
}
