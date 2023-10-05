package com.example.cinema_app_spring_boot.service.mapper;

import com.example.cinema_app_spring_boot.dto.request.UserRequestDto;
import com.example.cinema_app_spring_boot.dto.response.UserResponseDto;
import com.example.cinema_app_spring_boot.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements ResponseDtoMapper<User, UserResponseDto>,
        RequestDtoMapper<UserRequestDto, User> {

    @Override
    public UserResponseDto mapToDto(User model) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(model.getId());
        userResponseDto.setEmail(model.getEmail());
        userResponseDto.setRole(String.valueOf(model.getRole()));
        return userResponseDto;
    }

    @Override
    public User mapToModel(UserRequestDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
