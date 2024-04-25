package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.City;

import java.util.List;

public interface CityService {
    City create(City city);
    City read(String id);
    City update(City city);
    boolean delete(String id);
    List<City> readAll();
}
