package com.myapp.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyAppExceptionHandler {

	public MyAppExceptionHandler() {
		// TODO Auto-generated constructor stub
	}
	
	  
	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ApiError> handleException(ResourceNotFoundException e) {
	    	ApiError error = new ApiError(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
	        return new ResponseEntity<>(error, error.getStatus());
	    }

	   
	}


