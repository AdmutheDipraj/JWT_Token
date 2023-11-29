package com.jwt.security.controller;

import com.jwt.security.models.User;
import com.jwt.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> getUser(){
        return userService.getUsers();
    }

    @GetMapping("/currentUser")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}
