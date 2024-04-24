package com.hitema.sakila.mongodb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class CheckController {

    @GetMapping({"/","/check"})
    public String check(){
        String msg = String.format("<h2 style='color:green;text-align:center'><br>Le Serveur Sakila/MongoDB est UP ! %s </h2>", LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd - HH:mm:ss")));
        return msg;
    }
}
