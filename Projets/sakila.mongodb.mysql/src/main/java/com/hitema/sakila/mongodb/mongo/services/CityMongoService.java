package com.hitema.sakila.mongodb.mongo.services;

import com.hitema.sakila.mongodb.mongo.models.CityMongo;
import com.hitema.sakila.mongodb.mongo.models.CountryMongo;
import com.hitema.sakila.mongodb.mysql.models.CityMysql;

import java.util.List;

public interface CityMongoService {
    CityMongo create(CityMongo city);
    CityMongo read(Long id);
    CityMongo update(CityMongo city);
    boolean delete(Long id);
    List<CityMongo> readAll();
    List<CityMongo> migrate(List<CityMysql> cities);
    List<CountryMongo> readAllCountry();
}
