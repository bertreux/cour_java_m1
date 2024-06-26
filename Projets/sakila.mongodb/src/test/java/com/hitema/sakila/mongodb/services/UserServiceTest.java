package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    UserService service;

    @Test
    void create() {
        log.info("DEBUT TEST Create");
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john@doe.com");
        User serchUser = service.read(user.getEmail());
        if (serchUser != null) {
            service.delete(user.getEmail());
        }
        user = service.create(user);
        serchUser = service.read(user.getEmail());
        if (serchUser == null) {
            log.error("erreur lors de la creation du user");
        } else {
            log.info(serchUser.toString());
        }
        log.info("FIN TEST Read All");
    }

    @Test
    void read() {
        log.info("DEBUT TEST Read By id with john@doe.com");
        log.info("{}", service.read("john@doe.com"));
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
        log.info("FIN TEST Read All");
    }

    @Test
    void readAllNomOrPrenom() {
        log.info("DEBUT TEST Read All With Nom Or Prenom Containing st");
        service.readAllNomOrPrenom("st").forEach(c -> log.info("{}", c));
        log.info("FIN TEST Read All With Nom Or Prenom Containing st");
    }
}