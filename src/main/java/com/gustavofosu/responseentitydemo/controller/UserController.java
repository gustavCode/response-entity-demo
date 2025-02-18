package com.gustavofosu.responseentitydemo.controller;

/*
    Created by Gustav on 2/18/2025
    @author : Gustav Ofosu
    @date : 2/18/2025
    @project : response-entity-demo
*/

import com.gustavofosu.responseentitydemo.exception.UserNotFoundException;
import com.gustavofosu.responseentitydemo.model.User;
import com.gustavofosu.responseentitydemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Simple GET with ResponseEntity
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.findUserById(id);

        if (user != null) {
            return ResponseEntity.ok(user);  // 200 OK
            // return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("User with id " + id + " not found");
//            return ResponseEntity.notFound().build();  // 404
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);

        // Custom header example
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity
                .created(location)  // 201 Created
                .header("X-Custom-Header", "user_created")
                .body(savedUser);
    }
}







