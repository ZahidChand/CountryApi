package com.plasmit.countryapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.plasmit.countryapi.exception.CountryNotFoundException;

@ControllerAdvice
public class CountryExceptionController 
{
	@ExceptionHandler(value = CountryNotFoundException.class)
	public ResponseEntity<Object> exception(CountryNotFoundException exception)
	{
		return new ResponseEntity<Object>("Id Enterned Not Found In Database ",HttpStatus.NOT_FOUND);
	}
}
