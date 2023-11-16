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
        UserDetails user = User.builder().username("dipraj").password(passwordEncoder().encode("abc")).roles("ADMIN").build();
        UserDetails user1 = User.builder().username("ram").password(passwordEncoder().encode("abc")).roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user,user1);
    }
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User.builder().username("rohit").password(passwordEncoder().encode("rohit123")).roles("admin").build();
//        UserDetails user2 = User.builder().username("ram").password(passwordEncoder().encode("ram123")).roles("employee").build();
//        UserDetails user3 = User.builder().username("shyam").password(passwordEncoder().encode("shyam123")).roles("manager").build();
//        return new InMemoryUserDetailsManager(user1,user2,user3);
//    }
    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }
}
