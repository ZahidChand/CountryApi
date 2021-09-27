package com.plasmit.countryapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.plasmit.countryapi.exception.IdAlreadyExistException;

@ControllerAdvice
public class IdExceptionController {
	@ExceptionHandler(value = IdAlreadyExistException.class)
	public ResponseEntity<Object> exception(IdAlreadyExistException exception) {
		return new ResponseEntity<Object>("Id Enterned Already Exist  In Database Please Enter Different Id", HttpStatus.NOT_FOUND);
	}

}
