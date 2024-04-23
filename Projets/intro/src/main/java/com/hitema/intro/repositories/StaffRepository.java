package com.hitema.intro.repositories;

import com.hitema.intro.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository  extends JpaRepository<Staff, Long> {
}
