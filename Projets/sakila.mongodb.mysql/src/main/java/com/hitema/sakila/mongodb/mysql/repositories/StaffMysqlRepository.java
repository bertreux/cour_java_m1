package com.hitema.sakila.mongodb.mysql.repositories;

import com.hitema.sakila.mongodb.mysql.models.StaffMysql;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffMysqlRepository extends JpaRepository<StaffMysql, Long> {
}
