package com.example.web4.exceptions;

public class IncorrectUserCredentialsException extends RuntimeException{
    public IncorrectUserCredentialsException(String massage) {
        super(massage);
    }
}
