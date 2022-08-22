package com.example.biblioteca.exception;

import com.example.biblioteca.exception.config.GlobalErrorCode;

public class EntityNotFoundException extends JavatoDevGlobalException{

    public EntityNotFoundException() {
        super("Entity Not Found", GlobalErrorCode.ERROR_ENTITY_NOT_FOUND);
    }

    public EntityNotFoundException(String message, Long code) {
        super(message, code);
    }
}
