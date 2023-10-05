package com.example.cinema_app_spring_boot.service;

import com.example.cinema_app_spring_boot.model.Order;
import com.example.cinema_app_spring_boot.model.ShoppingCart;
import com.example.cinema_app_spring_boot.model.User;
import java.util.List;

public interface OrderService {
    Order compliteOrder(ShoppingCart shoppingCart);

    List<Order> getOrderHistory(User user);
}
