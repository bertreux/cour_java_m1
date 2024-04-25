package com.hitema.sakila.mongodb.mongo.repositories;

import com.hitema.sakila.mongodb.mongo.models.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository  extends MongoRepository<City, String> {
}
