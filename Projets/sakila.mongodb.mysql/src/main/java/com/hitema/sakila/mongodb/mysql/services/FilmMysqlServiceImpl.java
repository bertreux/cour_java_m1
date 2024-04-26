package com.hitema.sakila.mongodb.mysql.services;

import com.hitema.sakila.mongodb.mysql.models.FilmMysql;
import com.hitema.sakila.mongodb.mysql.repositories.FilmMysqlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmMysqlServiceImpl implements FilmMysqlService {
    private FilmMysqlRepository repository;

    public FilmMysqlServiceImpl(FilmMysqlRepository repository) {
        this.repository = repository;
    }

    @Override
    public FilmMysql create(FilmMysql film) {
        return repository.save(film);
    }

    @Override
    public FilmMysql read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public FilmMysql update(FilmMysql film) {
        return repository.save(film);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return ( read(id) == null );
    }

    @Override
    public List<FilmMysql> readAll() {
        return repository.findAll();
    }
}
