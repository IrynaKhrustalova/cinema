package com.example.cinema_app_spring_boot.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MovieRequestDto {
    @NotNull
    private String title;
    @Size(max = 200)
    private String description;
}
