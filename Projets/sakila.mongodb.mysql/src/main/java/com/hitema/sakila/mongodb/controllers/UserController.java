package com.hitema.sakila.mongodb.controllers;

import com.hitema.sakila.mongodb.mongo.models.UserMongo;
import com.hitema.sakila.mongodb.mongo.services.UserMongoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserMongoService service;

    public UserController(UserMongoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public UserMongo getOne(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/name/{expr}")
    public List<UserMongo> getAllUserWithName(@PathVariable String expr) {
        return service.readAllNomOrPrenom(expr);
    }

    @GetMapping({"/all", ""})
    public List<UserMongo> readAll() {
        return service.readAll();
    }

    @PostMapping("/create")
    public UserMongo create(@RequestBody UserMongo user) {
        return service.create(user);
    }

    @PostMapping(value = "/picture/{id}", consumes = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public UserMongo insertPicture(@RequestBody byte[] file, @PathVariable String id) {
        return service.setPictureById(id, file);
    }

    @GetMapping(value = "/picture/{id}", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public byte[] getPicture(@PathVariable String id) {
        return service.getPicture(id);
    }
}
