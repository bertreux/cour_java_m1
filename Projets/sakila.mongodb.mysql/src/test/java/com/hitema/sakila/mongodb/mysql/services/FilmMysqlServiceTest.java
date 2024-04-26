package com.hitema.sakila.mongodb.mysql.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FilmMysqlServiceTest {

    private static final Logger log = LoggerFactory.getLogger(FilmMysqlServiceTest.class);

    @Autowired
    FilmMysqlService service;

    @Test
    void create() {
    }

    @Test
    void read() {
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