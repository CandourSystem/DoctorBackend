package org.cs.jwt.model;

import java.io.Serializable;

public class ResponseStatus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String messageCode="FAILURE";
	private String message="Record insertion/updation failed";
	String responsetime;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getResponsetime() {
		return responsetime;
	}

	public void setResponsetime(String responsetime) {
		this.responsetime = responsetime;
	}

}
