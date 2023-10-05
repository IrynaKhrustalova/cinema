package com.example.cinema_app_spring_boot.service.mapper;

import com.example.cinema_app_spring_boot.dto.request.MovieSessionRequestDto;
import com.example.cinema_app_spring_boot.dto.response.MovieSessionResponseDto;
import com.example.cinema_app_spring_boot.model.MovieSession;
import com.example.cinema_app_spring_boot.service.CinemaHallService;
import com.example.cinema_app_spring_boot.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper implements RequestDtoMapper<MovieSessionRequestDto, MovieSession>,
        ResponseDtoMapper<MovieSession, MovieSessionResponseDto> {
    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;

    public MovieSessionMapper(CinemaHallService cinemaHallService, MovieService movieService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    @Override
    public MovieSession mapToModel(MovieSessionRequestDto dto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(dto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(dto.getCinemaHallId()));
        movieSession.setTime(dto.getShowTime());
        return movieSession;
    }

    @Override
    public MovieSessionResponseDto mapToDto(MovieSession model) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setMovieSessionId(model.getId());
        movieSessionResponseDto.setMovieId(model.getMovie().getId());
        movieSessionResponseDto.setMovieTitle(model.getMovie().getTitle());
        movieSessionResponseDto.setCinemaHallId(model.getCinemaHall().getId());
        movieSessionResponseDto.setTime(model.getTime());
        return movieSessionResponseDto;
    }
}
