package com.hitema.sakila.mongodb.mysql.repositories;

import com.hitema.sakila.mongodb.mysql.models.FilmMysql;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmMysqlRepository extends JpaRepository<FilmMysql, Long>  {
}
