package com.hitema.sakila.mongodb.repositories;

import com.hitema.sakila.mongodb.models.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository  extends MongoRepository<City, String> {
}
