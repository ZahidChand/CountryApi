package com.plasmit.countryapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.plasmit.countryapi.exception.CityNotFoundException;

@ControllerAdvice
public class CityExceptionController 
{
	@ExceptionHandler(value = CityNotFoundException.class)
	public ResponseEntity<Object> exception (CityNotFoundException exception)
	{
		return new ResponseEntity<Object>("Entered City Not Found Into The Database . Please Enter Correct City Name ",HttpStatus.NOT_FOUND);
		
	}
}
