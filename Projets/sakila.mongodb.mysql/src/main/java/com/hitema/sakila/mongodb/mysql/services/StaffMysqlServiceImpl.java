package com.hitema.sakila.mongodb.mysql.services;

import com.hitema.sakila.mongodb.mysql.models.StaffMysql;
import com.hitema.sakila.mongodb.mysql.repositories.StaffMysqlRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class StaffMysqlServiceImpl implements StaffMysqlService {

    private StaffMysqlRepository repository;

    public StaffMysqlServiceImpl(StaffMysqlRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getPicture(Long id) {
        StaffMysql staff = read(id);
        return Base64.encodeBase64String(staff.getPicture());
    }

    @Override
    public StaffMysql read(Long id) {
        return repository.findById(id).orElse(null);
    }
}
