package com.hitema.sakila.mongodb.mongo.services;

import com.hitema.sakila.mongodb.mongo.models.FilmMongo;
import com.hitema.sakila.mongodb.mongo.models.LanguageMongo;
import com.hitema.sakila.mongodb.mongo.models.UserMongo;
import com.hitema.sakila.mongodb.mysql.services.FilmMysqlService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FilmMongoServiceTest {

    private static final Logger log = LoggerFactory.getLogger(FilmMongoServiceTest.class);

    @Autowired
    private FilmMongoService service;

    @Test
    void create() {
        log.info("DEBUT TEST Create");
        FilmMongo film = new FilmMongo();
        film.setId(12L);
        film.setTitle("test");
        film.setReleaseYear(LocalDateTime.now());
        film.setDescription("test");
        LanguageMongo languageMongo = new LanguageMongo(34L, "test");
        film.setLanguage(languageMongo);
        FilmMongo searchMongo = service.create(film);
        searchMongo = service.read(searchMongo.getId());
        if (searchMongo != null) {
            log.info(searchMongo.toString());
            service.delete(searchMongo.getId());
        } else {
            log.error("Erreur lors de la création d'un film");
        }
        log.info("FIN TEST Create");
    }

    @Test
    void read() {
        log.info("DEBUT TEST Read By id with john@doe.com");
        log.info("{}", service.read(6L));
        log.info("FIN TEST Read By id with john@doe.com");
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void readAll() {
        log.info("DEBUT TEST Read All");
        service.readAll().forEach(c -> log.info("{}", c));
        log.info("FIN TEST Read Al");
    }

    @Test
    void migrate() {
    }
}