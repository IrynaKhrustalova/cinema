package com.example.cinema_app_spring_boot.service.mapper;

import com.example.cinema_app_spring_boot.dto.response.OrderResponseDto;
import com.example.cinema_app_spring_boot.model.Order;
import com.example.cinema_app_spring_boot.model.Ticket;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements ResponseDtoMapper<Order, OrderResponseDto> {

    @Override
    public OrderResponseDto mapToDto(Order model) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(model.getId());
        orderResponseDto.setUserId(model.getUser().getId());
        orderResponseDto.setOrderTime(model.getTime());
        orderResponseDto.setTicketIds(model.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return orderResponseDto;
    }
}
