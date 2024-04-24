package com.hitema.sakila.mongodb.controllers;

import com.hitema.sakila.mongodb.models.User;
import com.hitema.sakila.mongodb.services.UserService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping({"/all", ""})
    public List<User> readAll() {
        return service.readAll();
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return service.create(user);
    }
}
