package com.example.web4.exceptions;

import com.example.web4.interaction.ApiError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({InvalidParameterException.class,IllegalArgumentException.class,IncorrectUserCredentialsException.class})
    public ResponseEntity<ApiError> invalidParameterExceptionHandler(Exception exception) {
        return new ResponseEntity<>(ApiError.builder()
                .statusNum(BAD_REQUEST.value())
                .message(exception.getMessage())
                .build(), BAD_REQUEST);
    }

}