package com.hitema.sakila.mongodb.controllers;

import com.hitema.sakila.mongodb.mongo.models.CityMongo;
import com.hitema.sakila.mongodb.mongo.models.CountryMongo;
import com.hitema.sakila.mongodb.mongo.services.CityMongoService;
import com.hitema.sakila.mongodb.mysql.models.CityMysql;
import com.hitema.sakila.mongodb.mysql.services.CityMysqlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    private static final Logger log = LoggerFactory.getLogger(CityController.class);

    private CityMongoService serviceMongo;

    private CityMysqlService serviceMysql;

    public CityController(CityMongoService serviceMongo, CityMysqlService serviceMysql) {
        this.serviceMongo = serviceMongo;
        this.serviceMysql = serviceMysql;
    }

    @GetMapping("/mysql/all")
    public List<CityMysql> getAllMysql() {
        return serviceMysql.readAll();
    }

    @GetMapping("/countries")
    public List<CountryMongo> getAllCountriesMongo() {
        return serviceMongo.readAllCountry();
    }

    @GetMapping("/mongo/all")
    public List<CityMongo> getAllMongo() {
        return serviceMongo.readAll();
    }

    @GetMapping("/migrate")
    public List<CityMongo> migrate() {
        List<CityMysql> citiesMysql = serviceMysql.readAll();
        return serviceMongo.migrate(citiesMysql);
    }
}
