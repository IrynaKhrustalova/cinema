package com.example.cinema_app_spring_boot.repository;

import com.example.cinema_app_spring_boot.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
