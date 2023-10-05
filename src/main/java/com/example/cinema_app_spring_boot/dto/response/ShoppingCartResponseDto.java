package com.example.cinema_app_spring_boot.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class ShoppingCartResponseDto {
    private Long userId;
    private List<Long> ticketsIds;
}
