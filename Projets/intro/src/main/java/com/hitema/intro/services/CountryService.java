package com.hitema.intro.services;

import com.hitema.intro.models.Country;

import java.util.List;

public interface CountryService {
    Country create(Country country);
    Country read(Long id);
    Country update(Country country);
    boolean delete(Long id);
    List<Country> readAll();
}
