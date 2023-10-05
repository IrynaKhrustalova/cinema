package com.example.cinema_app_spring_boot.repository;

import com.example.cinema_app_spring_boot.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
