package com.example.cinema_app_spring_boot.controller;

import com.example.cinema_app_spring_boot.dto.response.OrderResponseDto;
import com.example.cinema_app_spring_boot.model.Order;
import com.example.cinema_app_spring_boot.model.ShoppingCart;
import com.example.cinema_app_spring_boot.model.User;
import com.example.cinema_app_spring_boot.service.OrderService;
import com.example.cinema_app_spring_boot.service.ShoppingCartService;
import com.example.cinema_app_spring_boot.service.UserService;
import com.example.cinema_app_spring_boot.service.mapper.ResponseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ResponseDtoMapper<Order, OrderResponseDto> orderResponseDtoMapper;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public OrderController(OrderService orderService,
                           ResponseDtoMapper<Order, OrderResponseDto> orderResponseDtoMapper,
                           ShoppingCartService shoppingCartService,
                           UserService userService) {
        this.orderService = orderService;
        this.orderResponseDtoMapper = orderResponseDtoMapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(Authentication authentication) {
        String email = authentication.getName();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found")
        );
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return orderResponseDtoMapper.mapToDto(orderService.compliteOrder(shoppingCart));
    }

    @GetMapping("/all")
    public List<OrderResponseDto> getOrderHistory(Authentication authentication) {
        String email = authentication.getName();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found")
        );
        return orderService.getOrderHistory(user)
                .stream()
                .map(orderResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
