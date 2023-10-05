package com.example.cinema_app_spring_boot.service.mapper;

import com.example.cinema_app_spring_boot.dto.request.CinemaHallRequestDto;
import com.example.cinema_app_spring_boot.dto.response.CinemaHallResponseDto;
import com.example.cinema_app_spring_boot.model.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper implements ResponseDtoMapper<CinemaHall, CinemaHallResponseDto>,
        RequestDtoMapper<CinemaHallRequestDto, CinemaHall> {
    @Override
    public CinemaHall mapToModel(CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(dto.getCapacity());
        cinemaHall.setDescription(dto.getDescription());
        return cinemaHall;
    }

    @Override
    public CinemaHallResponseDto mapToDto(CinemaHall model) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(model.getId());
        cinemaHallResponseDto.setCapacity(model.getCapacity());
        cinemaHallResponseDto.setDescription(model.getDescription());
        return cinemaHallResponseDto;
    }
}
