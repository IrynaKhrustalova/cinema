package com.example.cinema_app_spring_boot.config;

import com.example.cinema_app_spring_boot.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {
    private static final String ADMIN_ROLE_NAME = "ADMIN";
    private static final String USER_ROLE_NAME = "USER";
    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authConfiguration) throws Exception {
        return authConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/register", "swagger-ui/index.htm", "/inject")
                        .permitAll()
                        .requestMatchers("/cinema-halls/all",
                                "/movies/all", "/movie-sessions/available", "/orders/all",
                                "/shopping-carts/by-user")
                        .hasAnyRole(Role.RoleName.ADMIN.name(), Role.RoleName.USER.name())
                        .requestMatchers("/cinema-halls/add")
                        .hasRole(Role.RoleName.ADMIN.name())
                        .requestMatchers("/movies/add", "/movie-sessions/add")
                        .hasRole(Role.RoleName.ADMIN.name())
                        .requestMatchers("/movie-sessions/update")
                        .hasRole(Role.RoleName.ADMIN.name())
                        .requestMatchers("/orders/complete")
                        .hasAnyRole(Role.RoleName.USER.name(), Role.RoleName.ADMIN.name())
                        .requestMatchers("/users/by_email")
                        .hasRole(Role.RoleName.ADMIN.name())
                        .requestMatchers("/shopping-carts/movies-sessions")
                        .hasAnyRole(Role.RoleName.USER.name(), Role.RoleName.ADMIN.name())
                        .requestMatchers("/movie-sessions/delete")
                        .hasRole(Role.RoleName.ADMIN.name())
                        .anyRequest().authenticated())
                .formLogin().permitAll()
                .and()
                .httpBasic();

        http.authenticationProvider(authenticationProvider());

        return http.build();
    }
}
