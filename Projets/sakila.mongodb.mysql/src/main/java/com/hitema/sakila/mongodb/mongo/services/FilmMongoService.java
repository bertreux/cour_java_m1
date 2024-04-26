package com.hitema.sakila.mongodb.mongo.services;

import com.hitema.sakila.mongodb.mongo.models.FilmMongo;
import com.hitema.sakila.mongodb.mysql.models.FilmMysql;

import java.util.List;

public interface FilmMongoService {
    FilmMongo create(FilmMongo film);
    FilmMongo read(Long id);
    FilmMongo update(FilmMongo film);
    boolean delete(Long id);
    List<FilmMongo> readAll();
    List<FilmMongo> migrate(List<FilmMysql> films);
    FilmMongo setPictureById(Long id, byte[] file);
    byte[] getPicture(Long id);
}
