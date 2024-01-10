package org.cs.jwt.services;

import org.cs.jwt.dto.DoctorRegistrationDTO;
import org.cs.jwt.model.DoctorRegistration;
import org.cs.jwt.repository.DoctorRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DoctorRegistrationService {

    @Autowired
    private DoctorRegistrationRepository repository;

    public DoctorRegistration saveDoctor(DoctorRegistrationDTO doctorDTO) {
        DoctorRegistration doctor = new DoctorRegistration();

        doctor.setName(doctorDTO.getFullName());
        doctor.setSpeciality(doctorDTO.getSpeciality());
        doctor.setExperience(doctorDTO.getExperience());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setAadhar(doctorDTO.getAadhar());
        doctor.setPanCard(doctorDTO.getPancard());
        doctor.setMobNumber(doctorDTO.getMobile());
        doctor.setAddress(doctorDTO.getAddress());
        doctor.setLicNumber(doctorDTO.getLicenceNumber());

        // Set default or auto-generated values
        doctor.setCreationdate(LocalDateTime.now());
        doctor.setCreatedby("admin"); // Assuming 'admin' is a constant
        doctor.setFlag(true); // Assuming 'Y' is represented as true

        return repository.save(doctor);
    }
}

