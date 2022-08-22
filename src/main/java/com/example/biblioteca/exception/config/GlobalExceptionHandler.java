package com.example.biblioteca.exception.config;

import com.example.biblioteca.exception.JavatoDevGlobalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JavatoDevGlobalException.class)
    protected ResponseEntity handleGlobalException(JavatoDevGlobalException e, Locale locale){
        return ResponseEntity
                .badRequest()
                .body(ErrorResponse.builder()
                        .code(e.getCode())
                        .message(e.getMessage())
                        .build());
    }

    protected ResponseEntity handleException(Exception e, Locale locale){
        return ResponseEntity
                .badRequest()
                .body("Exception occured inside API"+e);
    }

}

