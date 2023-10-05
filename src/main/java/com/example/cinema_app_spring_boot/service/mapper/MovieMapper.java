package com.example.cinema_app_spring_boot.service.mapper;

import com.example.cinema_app_spring_boot.dto.request.MovieRequestDto;
import com.example.cinema_app_spring_boot.dto.response.MovieResponseDto;
import com.example.cinema_app_spring_boot.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper implements ResponseDtoMapper<Movie, MovieResponseDto>,
        RequestDtoMapper<MovieRequestDto, Movie> {
    @Override
    public Movie mapToModel(MovieRequestDto dto) {
        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        return movie;
    }

    @Override
    public MovieResponseDto mapToDto(Movie model) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(model.getId());
        movieResponseDto.setTitle(model.getTitle());
        movieResponseDto.setDescription(model.getDescription());
        return movieResponseDto;
    }
}
