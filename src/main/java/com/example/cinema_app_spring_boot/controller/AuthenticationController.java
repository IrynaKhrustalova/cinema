package com.example.cinema_app_spring_boot.controller;

import com.example.cinema_app_spring_boot.dto.request.UserRequestDto;
import com.example.cinema_app_spring_boot.dto.response.UserResponseDto;
import com.example.cinema_app_spring_boot.model.User;
import com.example.cinema_app_spring_boot.service.AuthenticationService;
import com.example.cinema_app_spring_boot.service.mapper.ResponseDtoMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final ResponseDtoMapper<User, UserResponseDto> responseDtoMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    ResponseDtoMapper<User, UserResponseDto> responseDtoMapper) {
        this.authenticationService = authenticationService;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
        return responseDtoMapper.mapToDto(user);
    }
}
