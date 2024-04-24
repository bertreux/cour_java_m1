package com.hitema.sakila.mongodb.repositories;

import com.hitema.sakila.mongodb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
