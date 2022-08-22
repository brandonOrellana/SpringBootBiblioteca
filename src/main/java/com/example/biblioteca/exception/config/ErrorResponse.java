package com.example.biblioteca.exception.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private Long code;
    private String message;
}
