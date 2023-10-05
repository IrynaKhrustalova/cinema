package com.example.cinema_app_spring_boot.service.impl;

import com.example.cinema_app_spring_boot.model.MovieSession;
import com.example.cinema_app_spring_boot.model.ShoppingCart;
import com.example.cinema_app_spring_boot.model.Ticket;
import com.example.cinema_app_spring_boot.model.User;
import com.example.cinema_app_spring_boot.repository.ShoppingCartRepository;
import com.example.cinema_app_spring_boot.repository.TicketRepository;
import com.example.cinema_app_spring_boot.service.ShoppingCartService;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final TicketRepository ticketRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   TicketRepository ticketRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void addSession(MovieSession movieSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setMovieSession(movieSession);
        ticket.setUser(user);
        Ticket save = ticketRepository.save(ticket);
        ShoppingCart shoppingCart = shoppingCartRepository.findByUser(user);
        shoppingCart.getTickets().add(save);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartRepository.findByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCart.setTickets(new ArrayList<>());
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.setTickets(new ArrayList<>());
        shoppingCartRepository.save(shoppingCart);
    }
}
