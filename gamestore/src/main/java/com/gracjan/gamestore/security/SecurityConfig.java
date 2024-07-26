package com.gracjan.gamestore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // FOR CUSTOM TABLES (accounts, roles INSTEAD OF users, authorities) IN DATABASE
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username, password, enabled from accounts where username=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username, role from roles where username=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        // ADD ROLE PERMISSIONS TO USE ENDPOINTS
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/games").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/games/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/games").hasRole("MODERATOR")
                        .requestMatchers(HttpMethod.PUT, "/api/games").hasRole("MODERATOR")
                        .requestMatchers(HttpMethod.DELETE, "/api/games").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/games/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/dao/games").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/dao/games/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/dao/games/platform/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/dao/games").hasRole("MODERATOR")
                        .requestMatchers(HttpMethod.PUT, "/dao/games").hasRole("MODERATOR")
                        .requestMatchers(HttpMethod.DELETE, "/dao/games").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/dao/games/**").hasRole("ADMIN")
        );

        // USE HTTP BASIC AUTHENTICATION
        http.httpBasic(Customizer.withDefaults());

        // DISABLE CSRF
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
