package com.hitema.sakila.mongodb.mysql.services;

import com.hitema.sakila.mongodb.mysql.models.LanguageMysql;
import com.hitema.sakila.mongodb.mysql.repositories.LanguageMysqlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LanguageMysqlServiceImpl implements LanguageMysqlService {

    private LanguageMysqlRepository repository;

    @Override
    public LanguageMysql create(LanguageMysql language) {
        if (language.getLastUpdate() == null) {
            language.setLastUpdate(LocalDateTime.now());
        }
        return repository.save(language);
    }

    @Override
    public LanguageMysql read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public LanguageMysql update(LanguageMysql language) {
        return repository.save(language);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return ( read(id) == null );
    }

    @Override
    public List<LanguageMysql> readAll() {
        return repository.findAll();
    }
}
