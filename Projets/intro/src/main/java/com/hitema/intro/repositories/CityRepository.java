package com.hitema.intro.repositories;

import com.hitema.intro.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository  extends JpaRepository<City, Long> {
    List<City> findByNameContaining(String name);
    List<City> findByCapitalTrue();
}
