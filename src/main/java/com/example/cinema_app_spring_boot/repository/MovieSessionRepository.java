package com.example.cinema_app_spring_boot.repository;

import com.example.cinema_app_spring_boot.model.MovieSession;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieSessionRepository extends JpaRepository<MovieSession, Long> {
    @Query("From MovieSession ms "
            + "INNER JOIN FETCH ms.movie m "
            + "Where m.id = ?1 AND DATE_FORMAT(ms.time, '%Y-%m-%d') = ?2")
    List<MovieSession> findAllAvailableSessions(Long movieId, LocalDate date);
}
