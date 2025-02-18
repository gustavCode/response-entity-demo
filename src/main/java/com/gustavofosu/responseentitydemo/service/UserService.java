package com.gustavofosu.responseentitydemo.service;

/*
    Created by Gustav on 2/18/2025
    @author : Gustav Ofosu
    @date : 2/18/2025
    @project : response-entity-demo
*/

import com.gustavofosu.responseentitydemo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private Long nextId = 3L;

    public UserService() {
        // Initialize with sample data
        users.add(new User(1L, "Alice", "alice@example.com"));
        users.add(new User(2L, "Bob", "bob@example.com"));
    }

    public User findUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User saveUser(User user) {
        // Simulate ID generation
        user.setId(nextId++);
        users.add(user);
        return user;
    }
}








