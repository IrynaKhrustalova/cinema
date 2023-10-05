package com.example.cinema_app_spring_boot.service.impl;

import com.example.cinema_app_spring_boot.model.Role;
import com.example.cinema_app_spring_boot.model.User;
import com.example.cinema_app_spring_boot.repository.UserRepository;
import com.example.cinema_app_spring_boot.service.RoleService;
import com.example.cinema_app_spring_boot.service.UserService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User addRole(String roleName, Long userId) {
        Role.RoleName roleName1 = Role.RoleName.valueOf(roleName);
        Role role = roleService.getByName(roleName1);
        Optional<User> userById = userRepository.findById(userId);
        if (userById.isPresent()) {
            User user = userById.get();
            user.setRole(role);
            return userRepository.save(user);
        }
        throw new RuntimeException("Can't add role " + role.getRoleName()
                + ". User by id " + userId + "not found");
    }
}
