package com.example.cinema_app_spring_boot.repository;

import com.example.cinema_app_spring_boot.model.ShoppingCart;
import com.example.cinema_app_spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query("From ShoppingCart sc "
            + "left join fetch sc.tickets t "
            + "left join fetch t.movieSession ms "
            + "left join fetch ms.cinemaHall "
            + "left join fetch ms.movie "
            + "Where sc.user = ?1")
    ShoppingCart findByUser(User user);
}
