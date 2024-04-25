package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.City;
import com.hitema.sakila.mongodb.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository repository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.repository = cityRepository;
    }

    @Override
    public City create(City city) {
        if (city.getLastUpdate() == null) {
            city.setLastUpdate(LocalDateTime.now());
        }
        return repository.save(city);
    }

    @Override
    public City read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public City update(City city) {
        return repository.save(city);
    }

    @Override
    public boolean delete(String id) {
        repository.deleteById(id);
        return ( read(id) == null );
    }

    @Override
    public List<City> readAll() {
        return repository.findAll();
    }
}
