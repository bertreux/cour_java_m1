package com.hitema.sakila.mongodb.mongo.services;

import com.hitema.sakila.mongodb.mongo.models.City;

import java.util.List;

public interface CityService {
    City create(City city);
    City read(String id);
    City update(City city);
    boolean delete(String id);
    List<City> readAll();
}
