package com.hitema.sakila.mongodb.controllers;

import com.hitema.sakila.mongodb.models.User;
import com.hitema.sakila.mongodb.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/name/{expr}")
    public List<User> getAllUserWithName(@PathVariable String expr) {
        return service.readAllNomOrPrenom(expr);
    }

    @GetMapping({"/all", ""})
    public List<User> readAll() {
        return service.readAll();
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @PostMapping("/picture/{id}")
    public User insertPicture(@RequestBody byte[] file, @PathVariable String id) {
        return service.setPictureById(id, file);
    }

    @GetMapping(value = "/picture/{id}", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public byte[] getPicture(@PathVariable String id) {
        return service.getPicture(id);
    }
}
