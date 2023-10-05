package com.example.cinema_app_spring_boot.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private Long userId;
    private LocalDateTime orderTime;
}
