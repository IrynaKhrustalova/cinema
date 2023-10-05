package com.example.cinema_app_spring_boot.service;

import com.example.cinema_app_spring_boot.model.Movie;
import java.util.List;

public interface MovieService {

    Movie add(Movie movie);

    Movie get(Long id);

    List<Movie> getAll();
}
