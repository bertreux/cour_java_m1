package com.hitema.intro.services;

import com.hitema.intro.models.Staff;
import com.hitema.intro.repositories.StaffRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {

    private StaffRepository repository;

    public StaffServiceImpl(StaffRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getPicture(Long id) {
        Staff staff = read(id);
        return Base64.encodeBase64String(staff.getPicture());
    }

    @Override
    public Staff read(Long id) {
        return repository.findById(id).orElse(null);
    }
}
