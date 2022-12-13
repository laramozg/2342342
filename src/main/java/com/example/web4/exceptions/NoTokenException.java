package com.example.web4.exceptions;

public class NoTokenException extends RuntimeException{
    public NoTokenException(String massage){
        super(massage);
    }
}
