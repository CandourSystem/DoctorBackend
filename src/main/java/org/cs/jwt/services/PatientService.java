package org.cs.jwt.services;

import org.cs.jwt.controller.PatientRepository;
import org.cs.jwt.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> findByName(String name) {
        return patientRepository.findByName(name);
    }

    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    // Add other methods as needed
}
