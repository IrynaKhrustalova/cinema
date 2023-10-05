package com.example.cinema_app_spring_boot.service.mapper;

public interface ResponseDtoMapper<T, D> {

    D mapToDto(T model);
}
