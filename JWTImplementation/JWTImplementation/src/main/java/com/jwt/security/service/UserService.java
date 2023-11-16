package com.jwt.security.service;

import com.jwt.security.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store=new ArrayList<>();

    public UserService() {
        store.add(new User(UUID.randomUUID().toString(),"Dipraj Admuthe","dip@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Raj Mane","raj@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Ram Patil","ram@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Shyam Raje","shyam@gmail.com"));
    }

    public List<User> getUsers(){
        return this.store;
    }
}
