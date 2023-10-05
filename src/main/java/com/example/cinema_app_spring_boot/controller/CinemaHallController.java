package com.example.cinema_app_spring_boot.controller;

import com.example.cinema_app_spring_boot.dto.request.CinemaHallRequestDto;
import com.example.cinema_app_spring_boot.dto.response.CinemaHallResponseDto;
import com.example.cinema_app_spring_boot.model.CinemaHall;
import com.example.cinema_app_spring_boot.service.CinemaHallService;
import com.example.cinema_app_spring_boot.service.mapper.RequestDtoMapper;
import com.example.cinema_app_spring_boot.service.mapper.ResponseDtoMapper;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final RequestDtoMapper<CinemaHallRequestDto,
            CinemaHall> cinemaHallRequestDtoMapper;
    private final ResponseDtoMapper<CinemaHall,
            CinemaHallResponseDto> cinemaHallResponseDtoMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                RequestDtoMapper<CinemaHallRequestDto, CinemaHall>
                                        cinemaHallRequestDtoMapper,
                                ResponseDtoMapper<CinemaHall, CinemaHallResponseDto>
                                        cinemaHallResponseDtoResponseDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallRequestDtoMapper = cinemaHallRequestDtoMapper;
        this.cinemaHallResponseDtoMapper = cinemaHallResponseDtoResponseDtoMapper;
    }

    @PostMapping("/add")
    public CinemaHallResponseDto add(@RequestBody @Valid CinemaHallRequestDto
                                                 cinemaHallRequestDto) {
        return cinemaHallResponseDtoMapper.mapToDto(cinemaHallService
                .add(cinemaHallRequestDtoMapper.mapToModel(cinemaHallRequestDto)));
    }

    @GetMapping("/all")
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll()
                .stream().map(cinemaHallResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
