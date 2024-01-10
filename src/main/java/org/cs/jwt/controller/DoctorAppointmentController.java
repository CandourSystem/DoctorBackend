package org.cs.jwt.controller;

import org.cs.jwt.dto.DoctorAppointmentDTO;
import org.cs.jwt.model.DoctorAppointment;
import org.cs.jwt.services.DoctorAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class DoctorAppointmentController {

    @Autowired
    private DoctorAppointmentService service;

    @PostMapping
    public DoctorAppointment createAppointment(@RequestBody DoctorAppointmentDTO appointmentDTO) {
        return service.saveAppointment(appointmentDTO);
    }
}

