package com.plasmit.countryapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.plasmit.countryapi.exception.CodeNotFoundException;

@ControllerAdvice
public class CodeExceptionController
{
	@ExceptionHandler(value = CodeNotFoundException.class)
	public ResponseEntity<Object> exception(CodeNotFoundException exception)
	{
		return new ResponseEntity<Object>(
			"Entered Country Code Do Not Matched In Database. Please Enter Correct Country Code",
				HttpStatus.NOT_FOUND);
	}
	
}
