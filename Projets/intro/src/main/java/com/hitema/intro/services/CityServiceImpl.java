package com.hitema.intro.services;

import com.hitema.intro.models.City;
import com.hitema.intro.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City create(City city) {
        return repository.save(city);
    }

    @Override
    public City read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public City update(City city) {
        return repository.save(city);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return ( read(id) == null );
    }

    @Override
    public List<City> readAll() {
        return repository.findAll();
    }

    @Override
    public List<City> readByName(String name) {
        return repository.findByNameContaining(name);
    }


}
