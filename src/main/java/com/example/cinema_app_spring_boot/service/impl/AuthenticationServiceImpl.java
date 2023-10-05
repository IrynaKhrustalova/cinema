package com.example.cinema_app_spring_boot.service.impl;

import com.example.cinema_app_spring_boot.model.User;
import com.example.cinema_app_spring_boot.service.AuthenticationService;
import com.example.cinema_app_spring_boot.service.ShoppingCartService;
import com.example.cinema_app_spring_boot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(null);
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
