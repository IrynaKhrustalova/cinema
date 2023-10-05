package com.example.cinema_app_spring_boot.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CinemaHallRequestDto {
    @Min(10)
    private int capacity;
    @Size(max = 200)
    private String description;
}
