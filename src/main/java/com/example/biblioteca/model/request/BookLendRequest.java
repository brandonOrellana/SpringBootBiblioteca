package com.example.biblioteca.model.request;

import lombok.Data;

@Data
public class BookLendRequest {
    private Long bookId;
    private Long memberId;
}
