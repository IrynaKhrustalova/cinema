package com.example.cinema_app_spring_boot.repository;

import com.example.cinema_app_spring_boot.model.Order;
import com.example.cinema_app_spring_boot.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("From Order o "
            + "Join fetch o.tickets t "
            + "Join fetch t.movieSession ms "
            + "Join fetch ms.movie "
            + "Join fetch ms.cinemaHall "
            + "Where o.user = ?1")
    List<Order> getOrderHistoryByUser(User user);
}
