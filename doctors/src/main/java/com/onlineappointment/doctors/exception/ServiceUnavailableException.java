package com.onlineappointment.doctors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnavailableException extends RuntimeException{
	
	private String resourceName;
	
	public ServiceUnavailableException(String resourceName)
	{
		super(String.format("%s must be down",resourceName ));
		this.resourceName=resourceName;
	}

}
