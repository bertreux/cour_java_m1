package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.User;
import com.hitema.sakila.mongodb.repositories.UserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        if (user.getLastUpdate() == null) {
            user.setLastUpdate(LocalDateTime.now());
        }
        return repository.save(user);
    }

    @Override
    public User read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public boolean delete(String id) {
        repository.deleteById(id);
        return ( read(id) == null );
    }

    @Override
    public List<User> readAll() {
        return repository.findAll();
    }

    @Override
    public List<User> readAllNomOrPrenom(String name) {
        return repository.findByFirstNameContainingOrLastNameContaining(name, name);
    }

    @Override
    public User setPictureById(String id, byte[] file) {
        User user = read(id);
        user.setPicture(file);
        return update(user);
    }

    @Override
    public byte[] getPicture(String id) {
        User user = read(id);
        return user.getPicture();
    }
}
