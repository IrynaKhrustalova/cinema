package com.example.cinema_app_spring_boot.controller;

import com.example.cinema_app_spring_boot.dto.response.ShoppingCartResponseDto;
import com.example.cinema_app_spring_boot.model.MovieSession;
import com.example.cinema_app_spring_boot.model.ShoppingCart;
import com.example.cinema_app_spring_boot.model.User;
import com.example.cinema_app_spring_boot.service.MovieSessionService;
import com.example.cinema_app_spring_boot.service.ShoppingCartService;
import com.example.cinema_app_spring_boot.service.UserService;
import com.example.cinema_app_spring_boot.service.mapper.ResponseDtoMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ResponseDtoMapper<ShoppingCart, ShoppingCartResponseDto> responseDtoMapper;
    private final UserService userService;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ResponseDtoMapper<ShoppingCart,
                                          ShoppingCartResponseDto> responseDtoMapper,
                                  UserService userService,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.responseDtoMapper = responseDtoMapper;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @PutMapping("/movie-sessions")
    public void addToCart(Authentication authentication,
                          @RequestParam Long movieSessionId) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication authentication) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        return responseDtoMapper.mapToDto(shoppingCartService.getByUser(user));
    }
}
