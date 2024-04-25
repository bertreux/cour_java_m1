package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
