package com.example.cinema_app_spring_boot.dto.response;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private String role;
}
