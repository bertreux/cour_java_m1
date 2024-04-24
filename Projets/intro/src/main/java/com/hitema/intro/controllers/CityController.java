package com.hitema.intro.controllers;

import com.hitema.intro.models.City;
import com.hitema.intro.models.Country;
import com.hitema.intro.services.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    private static final Logger log = LoggerFactory.getLogger(CountryController.class);

    private CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping({"/all", "", "/name/"})
    public List<City> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    public City getOne(@PathVariable Long id) {
        return service.read(id);
    }

    @GetMapping("/name/{name}")
    public List<City> getOne(@PathVariable String name) {
        return service.readByName(name);
    }

    @GetMapping("/capitals")
    public List<City> getAllCapitals() {
        return service.readAllCapital();
    }

    @PostMapping("/create")
    public City create(@RequestBody City city) {
        return service.create(city);
    }
}
