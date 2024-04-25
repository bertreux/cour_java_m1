package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.Country;
import com.hitema.sakila.mongodb.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository repository;

    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Country create(Country country) {
        if (country.getLastUpdate() == null) {
            country.setLastUpdate(LocalDateTime.now());
        }
        return repository.save(country);
    }

    @Override
    public Country read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Country update(Country country) {
        return repository.save(country);
    }

    @Override
    public boolean delete(String id) {
        repository.deleteById(id);
        return ( read(id) == null );
    }

    @Override
    public List<Country> readAll() {
        return repository.findAll();
    }
}
