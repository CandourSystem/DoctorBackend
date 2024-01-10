package org.cs.jwt.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pcb_doctor_registration")
public class DoctorRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docCode;

    @Column(name = "Name")
    private String name;

    public Long getDocCode() {
		return docCode;
	}

	public void setDocCode(Long docCode) {
		this.docCode = docCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicNumber() {
		return licNumber;
	}

	public void setLicNumber(String licNumber) {
		this.licNumber = licNumber;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Long getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(Long mobNumber) {
		this.mobNumber = mobNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public LocalDateTime getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(LocalDateTime creationdate) {
		this.creationdate = creationdate;
	}

	@Column(name = "LicNumber")
    private String licNumber;

    @Column(name = "Speciality")
    private String speciality;

    @Column(name = "Experience")
    private String experience;

    @Column(name = "MobNumber")
    private Long mobNumber;

    @Column(name = "Email")
    private String email;

    @Column(name = "Address")
    private String address;

    @Column(name = "flag")
    private boolean flag;

    @Column(name = "createdby")
    private String createdby;

    @Column(name = "Aadhar")
    private String aadhar;

    @Column(name = "PanCard")
    private String panCard;

    @Column(name = "creationdate", updatable = false)
    private LocalDateTime creationdate;

    // Constructors, Getters and Setters
}
