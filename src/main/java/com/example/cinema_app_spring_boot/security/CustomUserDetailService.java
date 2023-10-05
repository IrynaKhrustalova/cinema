package com.example.cinema_app_spring_boot.security;

import com.example.cinema_app_spring_boot.model.User;
import com.example.cinema_app_spring_boot.service.UserService;
import java.util.Optional;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userFromDb = userService.findByEmail(email);
        UserBuilder userBuilder;
        if (userFromDb.isPresent()) {
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(email);
            userBuilder.password(new BCryptPasswordEncoder()
                    .encode(userFromDb.get().getPassword()));
            userBuilder.authorities(userFromDb.get().getRole().getRoleName().name());
            return userBuilder.build();
        }
        throw new UsernameNotFoundException("User not found");
    }
}
