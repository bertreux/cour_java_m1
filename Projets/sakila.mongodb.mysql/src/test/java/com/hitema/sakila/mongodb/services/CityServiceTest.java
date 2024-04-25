package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.mongo.models.CityMongo;
import com.hitema.sakila.mongodb.mongo.models.CountryMongo;
import com.hitema.sakila.mongodb.mongo.services.CityMongoService;
import com.hitema.sakila.mongodb.mysql.services.CityMysqlService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CityServiceTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    CityMongoService service;

    @Autowired
    CityMysqlService serviceMysql;

    @Test
    @Order(1)
    void create() {
        log.info("<<<<<<<<<START Create CityMongo >>>>>>>>>");
        Long id = 12L;
        var country = new CountryMongo(34, "France");
        var city = new CityMongo();
        city.setId(id);
        city.setName("Paris");
        city.setCapital(true);
        city.setCountry(country);
        assertTrue(service.create(city) != null, "CITY CREATE DOES NOT WORK !!!");
        log.info("Create city : {} ", city);
        log.info("<<<<<<<<<END Create CityMongo >>>>>>>>>");
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    @DisplayName("Should Delete CityMongo")
    @Order(0)
    void shouldDeleteCity() {
        log.info("<<<<<<<<<START shouldDeleteCity >>>>>>>>>");
        Long id = 12L;
        assertTrue(service.delete(id), "CITY DELETE ERROR id:"+id);
        log.info("<<<<<<<<<END   shouldDeleteCity >>>>>>>>>");
    }

    @Test
    void readAll() {
    }

    @Test
    void readAllCityWithMySQL() {
        log.info("DEBUT TEST Read All With MySQL");
        serviceMysql.readAll().forEach(c -> log.info("{}", c));
        log.info("FIN TEST Read All With MySQL");
    }
}