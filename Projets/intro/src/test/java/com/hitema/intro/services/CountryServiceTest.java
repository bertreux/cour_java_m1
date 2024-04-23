package com.hitema.intro.services;

import com.hitema.intro.models.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountryServiceTest {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceTest.class);

    @Autowired
    CountryService service;

    @Test
    void create() {
        log.info("DEBUT TEST Create");
        Country country = new Country();
        country.setName("test");
        country.setLastUpdate(LocalDateTime.now());
        country = service.create(country);
        if (country != null) {
            log.info(country.toString());
            boolean delete = service.delete(country.getId());
            if (delete){
                log.info("Le test a bien été crée et supprimer");
            }else {
                log.error("Le test du country a bien été crée mais n'a pas pu etre supprimé");
            }
        }else {
            log.error("Le test du country n'a pas été crée");
        }
        log.info("FIN TEST Create");
    }

    @Test
    void read() {
        log.info("DEBUT TEST Read One");
        Long id = 6L;
        var country = service.read(id);
        log.trace("{}", country);
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
}