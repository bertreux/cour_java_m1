package com.hitema.sakila.mongodb.mysql.services;

import com.hitema.sakila.mongodb.mysql.models.CityMysql;

import java.util.List;

public interface CityMysqlService {
    CityMysql create(CityMysql city);
    CityMysql read(Long id);
    CityMysql update(CityMysql city);
    boolean delete(Long id);
    List<CityMysql> readAll();
    List<CityMysql> readByName(String name);
    List<CityMysql> readAllCapital();
}
