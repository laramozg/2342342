package com.example.web4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseUser {
    public ResponseUser(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResponseUser(int statusCode, String message, String accessToken) {
        this.statusCode = statusCode;
        this.message = message;
        this.accessToken = accessToken;
    }

    private int statusCode;
    private String message;
    private String accessToken;
}
