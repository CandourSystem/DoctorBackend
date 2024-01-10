package org.cs.jwt.db;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;


public interface QMSUserRepository extends JpaRepository<QMSUser, Long> {
   
    QMSUser findByUsername(String username);

    QMSUser findByUserid(BigInteger userid);
   
}