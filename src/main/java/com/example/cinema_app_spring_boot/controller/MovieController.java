package com.example.cinema_app_spring_boot.controller;

import com.example.cinema_app_spring_boot.dto.request.MovieRequestDto;
import com.example.cinema_app_spring_boot.dto.response.MovieResponseDto;
import com.example.cinema_app_spring_boot.model.Movie;
import com.example.cinema_app_spring_boot.service.MovieService;
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
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final RequestDtoMapper<MovieRequestDto, Movie> movieRequestDtoMapper;
    private final ResponseDtoMapper<Movie, MovieResponseDto> movieResponseDtoMapper;

    public MovieController(MovieService movieService,
                           RequestDtoMapper<MovieRequestDto, Movie> movieRequestDtoMapper,
                           ResponseDtoMapper<Movie, MovieResponseDto> movieResponseDtoMapper) {
        this.movieService = movieService;
        this.movieRequestDtoMapper = movieRequestDtoMapper;
        this.movieResponseDtoMapper = movieResponseDtoMapper;
    }

    @PostMapping("/add")
    public MovieResponseDto add(@RequestBody @Valid MovieRequestDto movieRequestDto) {
        return movieResponseDtoMapper.mapToDto(movieService
                .add(movieRequestDtoMapper.mapToModel(movieRequestDto)));
    }

    @GetMapping("/all")
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(movieResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
