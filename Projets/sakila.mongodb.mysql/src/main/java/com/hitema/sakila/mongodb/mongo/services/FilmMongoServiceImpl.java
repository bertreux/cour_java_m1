package com.hitema.sakila.mongodb.mongo.services;

import com.hitema.sakila.mongodb.mongo.models.*;
import com.hitema.sakila.mongodb.mongo.repositories.FilmMongoRepository;
import com.hitema.sakila.mongodb.mysql.models.FilmMysql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmMongoServiceImpl implements FilmMongoService {

    private FilmMongoRepository repository;

    public FilmMongoServiceImpl(FilmMongoRepository filmMongoRepository) {
        this.repository = filmMongoRepository;
    }

    @Override
    public FilmMongo create(FilmMongo film) {
        return repository.save(film);
    }

    @Override
    public FilmMongo read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public FilmMongo update(FilmMongo film) {
        return repository.save(film);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return ( read(id) == null );
    }

    @Override
    public List<FilmMongo> readAll() {
        return repository.findAll();
    }

    @Override
    public List<FilmMongo> migrate(List<FilmMysql> films) {
        films.forEach(film -> {
            if(read(film.getId()) == null){
                FilmMongo filmMongo = new FilmMongo();
                filmMongo.setId(film.getId());
                filmMongo.setDescription(film.getDescription());
                filmMongo.setPicture(film.getPicture());
                filmMongo.setTitle(film.getTitle());
                filmMongo.setReleaseYear(film.getReleaseYear());
                if(film.getLanguage() != null) {
                    LanguageMongo languageMongo = new LanguageMongo(film.getLanguage().getId(), film.getLanguage().getName());
                    filmMongo.setLanguage(languageMongo);
                }
                create(filmMongo);
            }
        });
        return repository.findAll();
    }

    @Override
    public FilmMongo setPictureById(Long id, byte[] file) {
        FilmMongo film = read(id);
        film.setPicture(file);
        return update(film);
    }

    @Override
    public byte[] getPicture(Long id) {
        FilmMongo film = read(id);
        return film.getPicture();
    }
}
