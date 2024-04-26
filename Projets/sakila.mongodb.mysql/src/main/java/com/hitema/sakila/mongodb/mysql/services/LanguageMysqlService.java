package com.hitema.sakila.mongodb.mysql.services;

import com.hitema.sakila.mongodb.mysql.models.LanguageMysql;

import java.util.List;

public interface LanguageMysqlService {
    LanguageMysql create(LanguageMysql language);
    LanguageMysql read(Long id);
    LanguageMysql update(LanguageMysql language);
    boolean delete(Long id);
    List<LanguageMysql> readAll();
}
