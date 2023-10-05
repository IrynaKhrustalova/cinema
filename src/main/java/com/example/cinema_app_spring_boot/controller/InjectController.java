package com.example.cinema_app_spring_boot.controller;

import com.example.cinema_app_spring_boot.model.Role;
import com.example.cinema_app_spring_boot.model.User;
import com.example.cinema_app_spring_boot.service.RoleService;
import com.example.cinema_app_spring_boot.service.ShoppingCartService;
import com.example.cinema_app_spring_boot.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InjectController {
    private final UserService userService;
    private final RoleService roleService;
    private final ShoppingCartService shoppingCartService;

    public InjectController(UserService userService,
                            RoleService roleService,
                            ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.roleService = roleService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/inject")
    public boolean inject() {
        User user = new User();
        user.setEmail("admin123@gmail.com");
        user.setPassword("admin123");
        user.setRole(roleService.getByName(Role.RoleName.ADMIN));
        User addedUser = userService.add(user);
        shoppingCartService.registerNewShoppingCart(addedUser);
        return true;
    }
}
