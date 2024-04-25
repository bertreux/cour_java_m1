package com.hitema.sakila.mongodb.mongo.services;

import com.hitema.sakila.mongodb.mongo.models.CityMongo;
import com.hitema.sakila.mongodb.mongo.repositories.CityMongoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CityMongoServiceImpl implements CityMongoService {

    private CityMongoRepository repository;

    public CityMongoServiceImpl(CityMongoRepository cityRepository) {
        this.repository = cityRepository;
    }

    @Override
    public CityMongo create(CityMongo city) {
        if (city.getLastUpdate() == null) {
            city.setLastUpdate(LocalDateTime.now());
        }
        return repository.save(city);
    }

    @Override
    public CityMongo read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CityMongo update(CityMongo city) {
        return repository.save(city);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return ( read(id) == null );
    }

    @Override
    public List<CityMongo> readAll() {
        return repository.findAll();
    }
}