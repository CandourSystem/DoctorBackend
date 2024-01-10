package org.cs.jwt.services;

import org.cs.jwt.dto.DoctorAppointmentDTO;
import org.cs.jwt.model.DoctorAppointment;
import org.cs.jwt.repository.DoctorAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID; // For generating unique appointmentCode

@Service
public class DoctorAppointmentService {
    
    @Autowired
    private DoctorAppointmentRepository repository;

    public DoctorAppointment saveAppointment(DoctorAppointmentDTO appointmentDTO) {
        DoctorAppointment appointment = new DoctorAppointment();

        appointment.setDocCode(appointmentDTO.getDocCode());
        appointment.setStarttime(appointmentDTO.getStarttime());
        appointment.setEndtime(appointmentDTO.getEndtime());
        appointment.setDay(appointmentDTO.getDay());
        appointment.setMeetinURL(appointmentDTO.getMeetinURL());

        // Auto-generated and default fields
        appointment.setAppointmentCode(UUID.randomUUID().toString());
        appointment.setCreateby("Admin");
        appointment.setCreationdate(LocalDateTime.now());
        appointment.setLastupdatedby("Admin");
        appointment.setLastupdateddate(LocalDateTime.now());

        return repository.save(appointment);
    }
}
