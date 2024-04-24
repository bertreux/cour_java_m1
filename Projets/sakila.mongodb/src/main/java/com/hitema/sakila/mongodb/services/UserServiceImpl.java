package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.User;
import com.hitema.sakila.mongodb.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        if (user.getLastUpdate() == null) {
            user.setLastUpdate(LocalDateTime.now());
        }
        return repository.save(user);
    }

    @Override
    public User read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public boolean delete(String id) {
        repository.deleteById(id);
        return ( read(id) == null );
    }

    @Override
    public List<User> readAll() {
        return repository.findAll();
    }
}
