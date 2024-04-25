package com.hitema.sakila.mongodb.mongo.services;

import com.hitema.sakila.mongodb.mongo.models.CityMongo;

import java.util.List;

public interface CityMongoService {
    CityMongo create(CityMongo city);
    CityMongo read(Long id);
    CityMongo update(CityMongo city);
    boolean delete(Long id);
    List<CityMongo> readAll();
}
