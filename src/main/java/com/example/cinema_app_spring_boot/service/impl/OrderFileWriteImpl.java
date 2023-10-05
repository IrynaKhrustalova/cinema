package com.example.cinema_app_spring_boot.service.impl;

import com.example.cinema_app_spring_boot.model.Order;
import com.example.cinema_app_spring_boot.service.OrderFileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class OrderFileWriteImpl implements OrderFileWriter {
    @Override
    public void writeOrderToFile(Order order) {
        File file = new File("orders" + File.separator
                + "userId " + order.getUser().getId()
                + " date " + LocalDate.now() + ".txt");
        String sessions = order.getTickets()
                .stream()
                .map(ticket -> ticket.getMovieSession().toString())
                .collect(Collectors.joining(" "));
        String txt = "User " + order.getUser().getEmail() + "\n"
                + "Movie sessions " + sessions + "\n"
                + "Time " + order.getTime();
        try {
            Files.write(file.toPath(), txt.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't create data", e);
        }
    }
}
