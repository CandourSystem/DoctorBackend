package org.cs.jwt.controller;

import org.cs.jwt.dto.DoctorRegistrationDTO;
import org.cs.jwt.model.DoctorRegistration;
import org.cs.jwt.services.DoctorRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorRegistrationController {

    @Autowired
    private DoctorRegistrationService service;

    @PostMapping
    public DoctorRegistration registerDoctor(@RequestBody DoctorRegistrationDTO doctorDTO) {
        return service.saveDoctor(doctorDTO);
    }
}
