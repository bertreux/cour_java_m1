package com.hitema.intro.controllers;

import com.hitema.intro.models.Country;
import com.hitema.intro.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private static final Logger log = LoggerFactory.getLogger(CountryController.class);

    private CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping({"/all", ""})
    public List<Country> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    public Country getOne(@PathVariable Long id) {
        return service.read(id);
    }

    @PostMapping("/create")
    public Country create(@RequestBody Country country) {
        return service.create(country);
    }
}
