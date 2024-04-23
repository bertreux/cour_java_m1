package com.hitema.intro.services;

import com.hitema.intro.models.City;

import java.util.List;

public interface CityService {
    City create(City city);
    City read(Long id);
    City update(City city);
    boolean delete(Long id);
    List<City> readAll();
}
