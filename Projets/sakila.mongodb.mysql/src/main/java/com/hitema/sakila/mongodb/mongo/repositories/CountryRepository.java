package com.hitema.sakila.mongodb.mongo.repositories;

import com.hitema.sakila.mongodb.mongo.models.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository  extends MongoRepository<Country, String> {
}
