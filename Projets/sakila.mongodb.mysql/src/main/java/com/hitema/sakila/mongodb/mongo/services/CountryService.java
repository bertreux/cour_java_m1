package com.hitema.sakila.mongodb.mongo.services;

import com.hitema.sakila.mongodb.mongo.models.Country;

import java.util.List;

public interface CountryService {
    Country create(Country country);
    Country read(String id);
    Country update(Country country);
    boolean delete(String id);
    List<Country> readAll();
}
