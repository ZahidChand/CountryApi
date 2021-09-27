package com.plasmit.countryapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CountryNotFoundException extends RuntimeException 
{

	public CountryNotFoundException(String message) {
		super(message);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
