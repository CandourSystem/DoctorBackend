package org.cs.jwt.dto;

import java.sql.Timestamp;

public class AppointmentDto {
    private Timestamp startTime;
    public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMeetingURL() {
		return meetingURL;
	}
	public void setMeetingURL(String meetingURL) {
		this.meetingURL = meetingURL;
	}
	private Timestamp endTime;
    private String day;
    private String meetingURL;
    // Getters and setters
}
