package com.hitema.sakila.mongodb.repositories;

import com.hitema.sakila.mongodb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
