package com.jwt.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder().username("dipraj").password(passwordEncoder().encode("dipraj@123")).roles("ADMIN").build();
        UserDetails user1 = User.builder().username("ram").password(passwordEncoder().encode("ram@123")).roles("ADMIN").build();
        UserDetails user2 = User.builder().username("shyam").password(passwordEncoder().encode("shyam@123")).roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user,user1,user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }
}
