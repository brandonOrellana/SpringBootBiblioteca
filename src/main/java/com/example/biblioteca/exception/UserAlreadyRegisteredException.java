package com.example.biblioteca.exception;

public class UserAlreadyRegisteredException extends JavatoDevGlobalException{
    public UserAlreadyRegisteredException(String message, Long code) {
        super(message, code);
    }
}
