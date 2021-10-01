package com.myapp.rest.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {
	private HttpStatus status;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

	
	private String message;
	
	
	
	
	public ApiError() {
		timestamp = LocalDateTime.now();
	}



	public ApiError(HttpStatus status, String localizedMessage) {
		// TODO Auto-generated constructor stub
		
		this();
		this.status = status;
		this.message =localizedMessage;
		
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	

	
	
	
}
