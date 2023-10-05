package com.example.cinema_app_spring_boot.service;

import com.example.cinema_app_spring_boot.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionService {

    List<MovieSession> getAvailableSessions(Long movieId, LocalDate date);

    MovieSession get(Long id);

    MovieSession add(MovieSession movieSession);

    MovieSession update(Long id, MovieSession movieSession);

    void delete(Long id);
}
