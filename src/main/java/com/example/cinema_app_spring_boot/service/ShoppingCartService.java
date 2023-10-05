package com.example.cinema_app_spring_boot.service;

import com.example.cinema_app_spring_boot.model.MovieSession;
import com.example.cinema_app_spring_boot.model.ShoppingCart;
import com.example.cinema_app_spring_boot.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
