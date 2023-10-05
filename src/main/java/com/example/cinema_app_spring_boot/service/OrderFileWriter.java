package com.example.cinema_app_spring_boot.service;

import com.example.cinema_app_spring_boot.model.Order;

public interface OrderFileWriter {
    void writeOrderToFile(Order order);
}
