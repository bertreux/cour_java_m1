package com.hitema.intro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class CheckController {
    @GetMapping({"/", "/check"})
    public String check(){
        String msg = String.format("<h2 style='display: flex;align-items: center;justify-content: center;" +
                "height: 100vh;color: green'>Le serveur est UP ! %s </h2>",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm:ss")));
        return msg;
    }
}
