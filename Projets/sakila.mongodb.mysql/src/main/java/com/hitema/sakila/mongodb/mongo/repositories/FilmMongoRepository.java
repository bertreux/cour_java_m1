package com.hitema.sakila.mongodb.mongo.repositories;

import com.hitema.sakila.mongodb.mongo.models.FilmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmMongoRepository extends MongoRepository<FilmMongo, Long> {
}
