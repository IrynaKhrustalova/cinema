package com.example.cinema_app_spring_boot.service.impl;

import com.example.cinema_app_spring_boot.model.MovieSession;
import com.example.cinema_app_spring_boot.repository.MovieSessionRepository;
import com.example.cinema_app_spring_boot.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionRepository movieSessionRepository;

    public MovieSessionServiceImpl(MovieSessionRepository movieSessionRepository) {
        this.movieSessionRepository = movieSessionRepository;
    }

    @Override
    public List<MovieSession> getAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionRepository.findAllAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession get(Long id) {
        return movieSessionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("MovieSession with id = " + id + "dos't exist"));
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        return movieSessionRepository.save(movieSession);
    }

    @Override
    public MovieSession update(Long id, MovieSession movieSession) {
        Optional<MovieSession> fromDb = movieSessionRepository.findById(id);
        if (fromDb.isPresent()) {
            MovieSession movieSessionFromDb = fromDb.get();
            movieSessionFromDb.setMovie(movieSession.getMovie());
            movieSessionFromDb.setTime(movieSession.getTime());
            movieSessionFromDb.setCinemaHall(movieSession.getCinemaHall());
            return movieSessionFromDb;
        }
        throw new RuntimeException("MovieSession with id = "
                + movieSession.getId() + "dos't exist");
    }

    @Override
    public void delete(Long id) {
        movieSessionRepository.deleteById(id);
    }
}
