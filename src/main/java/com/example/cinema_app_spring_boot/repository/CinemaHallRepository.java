package com.example.cinema_app_spring_boot.repository;

import com.example.cinema_app_spring_boot.model.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaHallRepository extends JpaRepository<CinemaHall, Long> {
}
