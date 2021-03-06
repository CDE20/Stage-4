package com.cognizant.moviecruiser_restful.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timeStamp;
	private String message;

	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(Date timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	private String details;

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timeStamp=" + timeStamp + ", message=" + message + ", details=" + details + "]";
	}

}
