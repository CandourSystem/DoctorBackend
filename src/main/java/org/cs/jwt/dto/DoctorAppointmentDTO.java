package org.cs.jwt.dto;
import java.time.LocalDateTime;

public class DoctorAppointmentDTO {
    public String getDocCode() {
		return docCode;
	}
	public void setDocCode(String docCode) {
		this.docCode = docCode;
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
	public String getMeetinURL() {
		return meetinURL;
	}
	public void setMeetinURL(String meetinURL) {
		this.meetinURL = meetinURL;
	}
	private String docCode;
    private LocalDateTime starttime;
    private LocalDateTime endtime;
    private String day;
    private String meetinURL;

    // Getters and Setters
}

