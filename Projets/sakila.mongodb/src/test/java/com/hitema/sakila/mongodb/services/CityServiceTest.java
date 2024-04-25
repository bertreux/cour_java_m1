package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.City;
import com.hitema.sakila.mongodb.models.Country;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CityServiceTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    CityService service;

    @Autowired
    CountryService countryService;

    @Test
    void create() {
        log.info("DEBUT TEST Create");
        City city = new City();
        Country country = new Country();
        country.setLastUpdate(LocalDateTime.now());
        country.setName("test");
        country = countryService.create(country);
        if (country != null) {
            log.info(country.toString());
            city.setName("test");
            city.setLastUpdate(LocalDateTime.now());
            city.setCountry(country);
            city = service.create(city);
            if (city != null) {
                log.info(city.toString());
                boolean delete = service.delete(city.getId());
                if (delete){
                    log.info("Le test du city a bien été crée et supprimer");
                }else {
                    log.error("Le test du city a bien été crée mais n'a pas pu etre supprimé");
                }
            }else {
                log.error("Le test du city n'a pas été crée");
            }
            boolean delete = countryService.delete(country.getId());
            if (delete){
                log.info("Le test du country a bien été crée et supprimer");
            }else {
                log.error("Le test du country a bien été crée mais n'a pas pu etre supprimé");
            }
        } else {
            log.error("Le country de test n'a pas pu etre crée");
        }
        log.info("FIN TEST Create");
    }

    @Test
    void read() {
        log.info("DEBUT TEST Read By id");
        City city = new City();
        city.setName("test");
        city.setCapital(true);
        city.setLastUpdate(LocalDateTime.now());
        city = service.create(city);
        city = service.read(city.getId());
        if(city != null) {
            log.info(city.toString());
            service.delete(city.getId());
        } else {
            log.error("Erreur lors de la lecture d'un element");
        }
        log.info("FIN TEST Read By id");
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
        log.info("FIN TEST Read All");
    }
}