package com.hitema.sakila.mongodb.mysql.services;

import com.hitema.sakila.mongodb.mysql.models.CityMysql;
import com.hitema.sakila.mongodb.mysql.repositories.CityMysqlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CityMysqlServiceImpl implements CityMysqlService {
    private CityMysqlRepository repository;

    public CityMysqlServiceImpl(CityMysqlRepository repository) {
        this.repository = repository;
    }

    @Override
    public CityMysql create(CityMysql city) {
        if (city.getLastUpdate() == null) {
            city.setLastUpdate(LocalDateTime.now());
        }
        return repository.save(city);
    }

    @Override
    public CityMysql read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CityMysql update(CityMysql city) {
        return repository.save(city);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return ( read(id) == null );
    }

    @Override
    public List<CityMysql> readAll() {
        return repository.findAll();
    }

    @Override
    public List<CityMysql> readByName(String name) {
        return repository.findByNameContaining(name);
    }

    @Override
    public List<CityMysql> readAllCapital() {
        return repository.findByCapitalTrue();
    }


}
