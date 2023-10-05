package com.example.cinema_app_spring_boot.controller;

import com.example.cinema_app_spring_boot.dto.response.UserResponseDto;
import com.example.cinema_app_spring_boot.model.User;
import com.example.cinema_app_spring_boot.service.UserService;
import com.example.cinema_app_spring_boot.service.mapper.ResponseDtoMapper;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ResponseDtoMapper<User, UserResponseDto> userResponseDtoMapper;

    public UserController(UserService userService,
                          ResponseDtoMapper<User, UserResponseDto> userResponseDtoMapper) {
        this.userService = userService;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getUserByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        return userResponseDtoMapper.mapToDto(user);
    }

    @PutMapping("/add-role")
    public UserResponseDto addRole(@Parameter(description = "Use only USER or ADMIN role name")
                                       @RequestParam String roleName,
                                   @RequestParam Long userId) {
        return userResponseDtoMapper.mapToDto(userService.addRole(roleName, userId));
    }
}
