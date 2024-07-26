package com.gracjan.gamestore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

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
}
