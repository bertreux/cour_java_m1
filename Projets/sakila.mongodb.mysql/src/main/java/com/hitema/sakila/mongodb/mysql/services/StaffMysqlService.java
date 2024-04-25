package com.hitema.sakila.mongodb.mysql.services;

import com.hitema.sakila.mongodb.mysql.models.StaffMysql;

public interface StaffMysqlService {
    String getPicture(Long id);
    StaffMysql read(Long id);
}
