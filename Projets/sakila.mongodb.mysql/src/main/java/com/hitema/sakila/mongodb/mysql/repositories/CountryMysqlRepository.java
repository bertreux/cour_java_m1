package com.hitema.sakila.mongodb.mysql.repositories;

import com.hitema.sakila.mongodb.mysql.models.CountryMysql;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryMysqlRepository extends JpaRepository<CountryMysql, Long> {
}
