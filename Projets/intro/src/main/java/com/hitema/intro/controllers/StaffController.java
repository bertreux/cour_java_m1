package com.hitema.intro.controllers;

import com.hitema.intro.services.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {
    private static final Logger log = LoggerFactory.getLogger(CountryController.class);

    private StaffService service;

    public StaffController(StaffService service) {
        this.service = service;
    }

    @GetMapping({"/{id}", ""})
    public String getPictureOfStaff(@PathVariable Long id) {
        String picture = service.getPicture(id);
        return String.format("<img src=\"data:image/jpeg;base64,%s\" alt=\"Image\">",
                picture);
    }
}
