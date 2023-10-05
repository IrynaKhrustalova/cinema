package com.example.cinema_app_spring_boot.service.impl;

import com.example.cinema_app_spring_boot.model.Order;
import com.example.cinema_app_spring_boot.model.ShoppingCart;
import com.example.cinema_app_spring_boot.model.User;
import com.example.cinema_app_spring_boot.repository.OrderRepository;
import com.example.cinema_app_spring_boot.service.OrderFileWriter;
import com.example.cinema_app_spring_boot.service.OrderService;
import com.example.cinema_app_spring_boot.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;
    private final OrderFileWriter orderFileWriter;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ShoppingCartService shoppingCartService,
                            OrderFileWriter orderFileWriter) {
        this.orderRepository = orderRepository;
        this.shoppingCartService = shoppingCartService;
        this.orderFileWriter = orderFileWriter;
    }

    @Override
    public Order compliteOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setTime(LocalDateTime.now());
        order.setTickets(shoppingCart.getTickets());
        order.setUser(shoppingCart.getUser());
        shoppingCartService.clear(shoppingCart);
        Order save = orderRepository.save(order);
        orderFileWriter.writeOrderToFile(save);
        return save;
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return orderRepository.getOrderHistoryByUser(user);
    }
}
