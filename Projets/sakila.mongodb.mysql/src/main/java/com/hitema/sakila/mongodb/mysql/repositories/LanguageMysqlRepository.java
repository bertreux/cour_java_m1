package com.hitema.sakila.mongodb.mysql.repositories;

import com.hitema.sakila.mongodb.mysql.models.LanguageMysql;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageMysqlRepository extends JpaRepository<LanguageMysql, Long>  {
}
