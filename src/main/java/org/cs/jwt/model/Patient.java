package org.cs.jwt.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pcb_Patient_dtls")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Code")
    private Long code;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private Long mobile;

    @Column(name = "address")
    private String address;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "creationdate")
    private Date creationDate;

    @Column(name = "lastupdatedby")
    private String lastUpdatedBy;

    @Column(name = "lastupdateddate")
    private Date lastUpdatedDate;

    // getters and setters
}
