package org.cs.jwt.services;

import org.cs.jwt.model.Appointment;
import org.cs.jwt.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository repository;

    public Appointment createOrUpdateAppointment(Appointment appointment) {
        return repository.save(appointment);
    }
}