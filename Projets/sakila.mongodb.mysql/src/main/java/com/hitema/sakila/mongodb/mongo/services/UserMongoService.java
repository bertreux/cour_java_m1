package com.hitema.sakila.mongodb.mongo.services;

import com.hitema.sakila.mongodb.mongo.models.UserMongo;

import java.util.List;

public interface UserMongoService {
    UserMongo create(UserMongo user);
    UserMongo read(String id);
    UserMongo update(UserMongo user);
    boolean delete(String id);
    List<UserMongo> readAll();
    List<UserMongo> readAllNomOrPrenom(String name);
    UserMongo setPictureById(String id, byte[] file);
    byte[] getPicture(String id);
}
