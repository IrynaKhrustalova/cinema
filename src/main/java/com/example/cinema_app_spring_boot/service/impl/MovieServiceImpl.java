package com.example.cinema_app_spring_boot.service.impl;

import com.example.cinema_app_spring_boot.model.Movie;
import com.example.cinema_app_spring_boot.repository.MovieRepository;
import com.example.cinema_app_spring_boot.service.MovieService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie add(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find movie with id " + id));
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }
}
