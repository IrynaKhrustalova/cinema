package com.example.cinema_app_spring_boot.controller;

import com.example.cinema_app_spring_boot.dto.request.MovieSessionRequestDto;
import com.example.cinema_app_spring_boot.dto.response.MovieSessionResponseDto;
import com.example.cinema_app_spring_boot.model.MovieSession;
import com.example.cinema_app_spring_boot.service.MovieSessionService;
import com.example.cinema_app_spring_boot.service.mapper.RequestDtoMapper;
import com.example.cinema_app_spring_boot.service.mapper.ResponseDtoMapper;
import com.example.cinema_app_spring_boot.util.DateTimePatternUtil;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final RequestDtoMapper<MovieSessionRequestDto, MovieSession>
            movieSessionRequestDtoMapper;
    private final ResponseDtoMapper<MovieSession, MovieSessionResponseDto>
            movieSessionResponseDtoMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  RequestDtoMapper<MovieSessionRequestDto, MovieSession>
                                          movieSessionRequestDtoMapper,
                                  ResponseDtoMapper<MovieSession, MovieSessionResponseDto>
                                          movieSessionResponseDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionRequestDtoMapper = movieSessionRequestDtoMapper;
        this.movieSessionResponseDtoMapper = movieSessionResponseDtoMapper;
    }

    @PostMapping("/add")
    public MovieSessionResponseDto add(@RequestBody @Valid MovieSessionRequestDto
                                                   movieSessionRequestDto) {
        return movieSessionResponseDtoMapper.mapToDto(movieSessionService
                .add(movieSessionRequestDtoMapper.mapToModel(movieSessionRequestDto)));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailable(@RequestParam Long movieId,
                                                         @RequestParam
                                                         @DateTimeFormat(
                                                                 pattern = DateTimePatternUtil
                                                                 .DATE_PATTERN)
                                                         LocalDate date) {
        return movieSessionService.getAvailableSessions(movieId, date)
                .stream()
                .map(movieSessionResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody @Valid
                                          MovieSessionRequestDto movieSessionRequestDto) {
        return movieSessionResponseDtoMapper.mapToDto(movieSessionService
                .update(id, movieSessionRequestDtoMapper.mapToModel(movieSessionRequestDto)));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@RequestParam Long id) {
        movieSessionService.delete(id);
    }
}
