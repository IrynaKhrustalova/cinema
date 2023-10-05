package com.example.cinema_app_spring_boot.config;

import com.example.cinema_app_spring_boot.model.Role;
import com.example.cinema_app_spring_boot.service.RoleService;
import com.example.cinema_app_spring_boot.service.ShoppingCartService;
import com.example.cinema_app_spring_boot.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public DataInitializer(RoleService roleService, UserService userService,
                           ShoppingCartService shoppingCartService) {
        this.roleService = roleService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);

        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);
    }
}
