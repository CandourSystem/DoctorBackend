package org.cs.jwt.controller;

import org.cs.jwt.model.Patient;
import org.cs.jwt.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.findById(id);
    }

    @GetMapping("/byname")
    public List<Patient> getPatientsByName(@RequestParam String name) {
        return patientService.findByName(name);
    }

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientService.findAllPatients();
    }

    // Add other endpoints as needed
}
