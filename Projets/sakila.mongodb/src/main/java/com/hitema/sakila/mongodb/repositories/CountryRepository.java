package com.hitema.sakila.mongodb.repositories;

import com.hitema.sakila.mongodb.models.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository  extends MongoRepository<Country, String> {
}
