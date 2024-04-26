package com.hitema.sakila.mongodb.mongo.repositories;

import com.hitema.sakila.mongodb.mongo.models.CityMongo;
import com.hitema.sakila.mongodb.mongo.models.CountryMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CityMongoRepository extends MongoRepository<CityMongo, Long> {
//    List<CountryMongo> findDistinctCountry();
}
