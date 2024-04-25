package com.hitema.sakila.mongodb.mongo.services;

import com.hitema.sakila.mongodb.mongo.models.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User read(String id);
    User update(User user);
    boolean delete(String id);
    List<User> readAll();
    List<User> readAllNomOrPrenom(String name);
    User setPictureById(String id, byte[] file);
    byte[] getPicture(String id);
}
