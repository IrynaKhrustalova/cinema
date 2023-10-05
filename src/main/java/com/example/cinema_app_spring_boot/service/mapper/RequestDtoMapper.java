package com.example.cinema_app_spring_boot.service.mapper;

public interface RequestDtoMapper<D, T> {

    T mapToModel(D dto);
}
