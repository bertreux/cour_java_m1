package com.hitema.sakila.mongodb.controllers;

import com.hitema.sakila.mongodb.mongo.models.FilmMongo;
import com.hitema.sakila.mongodb.mongo.services.FilmMongoService;
import com.hitema.sakila.mongodb.mysql.models.FilmMysql;
import com.hitema.sakila.mongodb.mysql.services.FilmMysqlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {
    private static final Logger log = LoggerFactory.getLogger(CityController.class);

    private FilmMongoService serviceMongo;

    private FilmMysqlService serviceMysql;

    public FilmController(FilmMongoService serviceMongo, FilmMysqlService serviceMysql) {
        this.serviceMongo = serviceMongo;
        this.serviceMysql = serviceMysql;
    }

    @GetMapping("/migrate")
    public List<FilmMongo> migrate() {
        List<FilmMysql> citiesMysql = serviceMysql.readAll();
        return serviceMongo.migrate(citiesMysql);
    }
    @GetMapping({"/all", ""})
    public List<FilmMongo> readAll() {
        return serviceMongo.readAll();
    }

    @PostMapping("/create")
    public FilmMongo create(@RequestBody FilmMongo film) {
        return serviceMongo.create(film);
    }

    @PostMapping(value = "/picture/{id}", consumes = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public FilmMongo insertPicture(@RequestBody byte[] file, @PathVariable Long id) {
        return serviceMongo.setPictureById(id, file);
    }

    @GetMapping(value = "/picture/{id}", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public byte[] getPicture(@PathVariable Long id) {
        return serviceMongo.getPicture(id);
    }

    @GetMapping("/{id}")
    public FilmMongo getOne(@PathVariable Long id) {
        return serviceMongo.read(id);
    }
}
