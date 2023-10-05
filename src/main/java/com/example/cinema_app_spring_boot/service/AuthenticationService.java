package com.example.cinema_app_spring_boot.service;

import com.example.cinema_app_spring_boot.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
