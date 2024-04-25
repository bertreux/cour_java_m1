package com.hitema.sakila.mongodb.mysql.repositories;

import com.hitema.sakila.mongodb.mysql.models.CityMysql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMysqlRepository extends JpaRepository<CityMysql, Long> {
    List<CityMysql> findByNameContaining(String name);
    List<CityMysql> findByCapitalTrue();
}
