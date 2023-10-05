package com.example.cinema_app_spring_boot.service;

import com.example.cinema_app_spring_boot.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);

    User addRole(String roleName, Long userId);
}
