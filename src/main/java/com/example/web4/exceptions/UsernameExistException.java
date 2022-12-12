package com.example.web4.exceptions;

public class UsernameExistException extends RuntimeException{
    public UsernameExistException(String massage){
        super(massage);
    }
}
