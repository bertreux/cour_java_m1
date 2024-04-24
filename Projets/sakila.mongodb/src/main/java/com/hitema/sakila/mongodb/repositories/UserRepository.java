package com.hitema.sakila.mongodb.repositories;

import com.hitema.sakila.mongodb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{'$or':[{'first_name': {$regex: ?0, $options: 'i'}}, {'last_name': {$regex: ?0, $options: 'i'}}]}")
    List<User> rechercherParNomOuPrenom(String expression);
}
