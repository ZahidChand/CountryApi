package com.plasmit.countryapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.plasmit.countryapi.exception.StateNotFoundException;

@ControllerAdvice
public class StateExceptionController {

	@ExceptionHandler(value = StateNotFoundException.class)
	public ResponseEntity<Object> exception(StateNotFoundException exception) {
		return new ResponseEntity<Object>("State Enterned Does Not Found In Database Please Enter Correct State",
				HttpStatus.NOT_FOUND);
	}

}
