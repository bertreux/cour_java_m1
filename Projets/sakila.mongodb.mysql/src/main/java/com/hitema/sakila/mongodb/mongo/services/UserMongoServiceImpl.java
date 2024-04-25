package com.hitema.sakila.mongodb.mongo.services;

import com.hitema.sakila.mongodb.mongo.models.UserMongo;
import com.hitema.sakila.mongodb.mongo.repositories.UserMongoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserMongoServiceImpl implements UserMongoService {
    private UserMongoRepository repository;

    public UserMongoServiceImpl(UserMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserMongo create(UserMongo user) {
        if (user.getLastUpdate() == null) {
            user.setLastUpdate(LocalDateTime.now());
        }
        return repository.save(user);
    }

    @Override
    public UserMongo read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public UserMongo update(UserMongo user) {
        return repository.save(user);
    }

    @Override
    public boolean delete(String id) {
        repository.deleteById(id);
        return ( read(id) == null );
    }

    @Override
    public List<UserMongo> readAll() {
        return repository.findAll();
    }

    @Override
    public List<UserMongo> readAllNomOrPrenom(String name) {
        return repository.findByFirstNameContainingOrLastNameContaining(name, name);
    }

    @Override
    public UserMongo setPictureById(String id, byte[] file) {
        UserMongo user = read(id);
        user.setPicture(file);
        return update(user);
    }

    @Override
    public byte[] getPicture(String id) {
        UserMongo user = read(id);
        return user.getPicture();
    }
}
