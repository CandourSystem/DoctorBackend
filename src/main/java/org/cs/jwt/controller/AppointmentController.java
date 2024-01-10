package org.cs.jwt.controller;

import org.cs.jwt.dto.AppointmentDto;
import org.cs.jwt.model.Appointment;
import org.cs.jwt.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService service;

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();

        // Manually mapping fields from DTO to Entity
        appointment.setStartTime(appointmentDto.getStartTime());
        appointment.setEndTime(appointmentDto.getEndTime());
        appointment.setDay(appointmentDto.getDay());
        appointment.setMeetingURL(appointmentDto.getMeetingURL());

        Appointment savedAppointment = service.createOrUpdateAppointment(appointment);

        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }
}

