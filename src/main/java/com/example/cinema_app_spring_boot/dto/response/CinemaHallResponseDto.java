package com.example.cinema_app_spring_boot.dto.response;

import lombok.Data;

@Data
public class CinemaHallResponseDto {
    private Long id;
    private int capacity;
    private String description;
}
