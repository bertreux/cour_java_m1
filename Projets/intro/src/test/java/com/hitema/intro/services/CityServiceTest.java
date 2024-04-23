package com.hitema.intro.services;

import com.hitema.intro.models.City;
import com.hitema.intro.models.Country;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CityServiceTest {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceTest.class);

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
        log.info("DEBUT TEST Read One");
        Long id = 6L;
        var city = service.read(id);
        log.trace("{}", city);
        log.info("FIN TEST Read One");
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
        service.readAll().forEach(c -> log.info(c.toString()));
        log.info("FIN TEST Read All");
    }
    @Test
    void readByName() {
        log.info("DEBUT TEST Read All By Name");
        service.readByName("A").forEach(c -> log.info(c.toString()));
        log.info("FIN TEST Read All By Name");
    }
    
}