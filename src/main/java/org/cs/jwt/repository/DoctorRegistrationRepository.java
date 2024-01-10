package org.cs.jwt.repository;

import org.cs.jwt.model.DoctorRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRegistrationRepository extends JpaRepository<DoctorRegistration, Long> {
}

