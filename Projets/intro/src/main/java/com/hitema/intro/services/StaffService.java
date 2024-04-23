package com.hitema.intro.services;

import com.hitema.intro.models.Staff;

public interface StaffService {
    String getPicture(Long id);
    Staff read(Long id);
}
