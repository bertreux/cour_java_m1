package com.hitema.intro.repositories;

import com.hitema.intro.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository  extends JpaRepository<City, Long> {
}
