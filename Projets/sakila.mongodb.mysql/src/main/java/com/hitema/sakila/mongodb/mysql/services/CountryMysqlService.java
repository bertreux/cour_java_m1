package com.hitema.sakila.mongodb.mysql.services;

import com.hitema.sakila.mongodb.mysql.models.CountryMysql;

import java.util.List;

public interface CountryMysqlService {
    CountryMysql create(CountryMysql country);
    CountryMysql read(Long id);
    CountryMysql update(CountryMysql country);
    boolean delete(Long id);
    List<CountryMysql> readAll();
}
