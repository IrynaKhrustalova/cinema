package com.example.cinema_app_spring_boot.repository;

import com.example.cinema_app_spring_boot.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("FROM User u INNER JOIN FETCH u.role WHERE u.email = ?1")
    Optional<User> findByEmail(String email);
}
