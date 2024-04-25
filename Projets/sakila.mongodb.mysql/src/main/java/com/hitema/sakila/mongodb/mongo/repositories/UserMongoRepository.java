package com.hitema.sakila.mongodb.mongo.repositories;

import com.hitema.sakila.mongodb.mongo.models.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserMongoRepository extends MongoRepository<UserMongo, String> {
    List<UserMongo> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
