package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User read(String id);
    User update(User user);
    boolean delete(String id);
    List<User> readAll();
}
