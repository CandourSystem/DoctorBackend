package org.cs.jwt.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pcb_doctor_appointment")
public class DoctorAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Assuming there is an ID field

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDocCode() {
		return docCode;
	}
	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}
	public String getAppointmentCode() {
		return appointmentCode;
	}
	public void setAppointmentCode(String appointmentCode) {
		this.appointmentCode = appointmentCode;
	}
	public LocalDateTime getStarttime() {
		return starttime;
	}
	public void setStarttime(LocalDateTime starttime) {
		this.starttime = starttime;
	}
	public LocalDateTime getEndtime() {
		return endtime;
	}
	public void setEndtime(LocalDateTime endtime) {
		this.endtime = endtime;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getCreateby() {
		return createby;
	}
	public void setCreateby(String createby) {
		this.createby = createby;
	}
	public LocalDateTime getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(LocalDateTime creationdate) {
		this.creationdate = creationdate;
	}
	public String getLastupdatedby() {
		return lastupdatedby;
	}
	public void setLastupdatedby(String lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}
	public LocalDateTime getLastupdateddate() {
		return lastupdateddate;
	}
	public void setLastupdateddate(LocalDateTime lastupdateddate) {
		this.lastupdateddate = lastupdateddate;
	}
	public String getMeetinURL() {
		return meetinURL;
	}
	public void setMeetinURL(String meetinURL) {
		this.meetinURL = meetinURL;
	}
	private String docCode;
    private String appointmentCode;
    private LocalDateTime starttime;
    private LocalDateTime endtime;
    private String day;
    private String createby;
    private LocalDateTime creationdate;
    private String lastupdatedby;
    private LocalDateTime lastupdateddate;
    private String meetinURL;

    // Getters and Setters
}

