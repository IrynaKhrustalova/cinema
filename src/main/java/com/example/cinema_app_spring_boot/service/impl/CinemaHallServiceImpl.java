package com.example.cinema_app_spring_boot.service.impl;

import com.example.cinema_app_spring_boot.model.CinemaHall;
import com.example.cinema_app_spring_boot.repository.CinemaHallRepository;
import com.example.cinema_app_spring_boot.service.CinemaHallService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    private final CinemaHallRepository cinemaHallRepository;

    public CinemaHallServiceImpl(CinemaHallRepository cinemaHallRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @Override
    public CinemaHall get(Long id) {
        return cinemaHallRepository.findById(id).orElseThrow(
                () -> new RuntimeException("CinemaHall with id = " + id + "dosn't exist"));
    }

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallRepository.save(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallRepository.findAll();
    }
}
