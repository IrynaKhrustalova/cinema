package com.example.cinema_app_spring_boot.service;

import com.example.cinema_app_spring_boot.model.CinemaHall;
import java.util.List;

public interface CinemaHallService {
    CinemaHall get(Long id);

    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();
}
