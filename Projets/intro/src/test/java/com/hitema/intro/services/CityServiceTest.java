package com.hitema.intro.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CityServiceTest {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceTest.class);

    @Autowired
    CityService service;

    @Test
    void create() {
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
}