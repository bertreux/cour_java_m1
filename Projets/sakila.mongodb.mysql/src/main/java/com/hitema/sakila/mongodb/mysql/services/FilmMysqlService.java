package com.hitema.sakila.mongodb.mysql.services;

import com.hitema.sakila.mongodb.mysql.models.FilmMysql;

import java.util.List;

public interface FilmMysqlService {
    FilmMysql create(FilmMysql film);
    FilmMysql read(Long id);
    FilmMysql update(FilmMysql film);
    boolean delete(Long id);
    List<FilmMysql> readAll();
}
