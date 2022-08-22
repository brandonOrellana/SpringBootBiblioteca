package com.example.biblioteca.dto;

import com.example.biblioteca.model.common.UserStatus;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private UserStatus userStatus;
    private String airlineId;
}
