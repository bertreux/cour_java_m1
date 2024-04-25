package com.hitema.sakila.mongodb.mysql.services;

import com.hitema.sakila.mongodb.mysql.models.CountryMysql;
import com.hitema.sakila.mongodb.mysql.repositories.CountryMysqlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CountryMysqlServiceImpl implements CountryMysqlService {

    private CountryMysqlRepository repository;

    public CountryMysqlServiceImpl(CountryMysqlRepository repository) {
        this.repository = repository;
    }

    @Override
    public CountryMysql create(CountryMysql country) {
        if (country.getLastUpdate() == null) {
            country.setLastUpdate(LocalDateTime.now());
        }
        return repository.save(country);
    }

    @Override
    public CountryMysql read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CountryMysql update(CountryMysql country) {
        return repository.save(country);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return ( read(id) == null );
    }

    @Override
    public List<CountryMysql> readAll() {
        return repository.findAll();
    }
}
