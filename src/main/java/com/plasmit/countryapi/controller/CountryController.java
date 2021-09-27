package com.plasmit.countryapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plasmit.countryapi.dao.CountryDaoImpl;
import com.plasmit.countryapi.entities.Country;
import com.plasmit.countryapi.exception.CityNotFoundException;
import com.plasmit.countryapi.exception.CodeNotFoundException;
import com.plasmit.countryapi.exception.CountryNotFoundException;
import com.plasmit.countryapi.exception.IdAlreadyExistException;
import com.plasmit.countryapi.exception.StateNotFoundException;
import com.plasmit.countryapi.service.CountryService;

@RestController
public class CountryController {
	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	CountryDaoImpl countryDaoImpl;

	@Autowired
	CountryService countryService;

	@PostMapping("/addDetails")
	public ResponseEntity<Country> addApi(@RequestBody Country country) {
		int id = country.getId();
		boolean exist = countryService.exist(id);
		if (exist) {
			logger.error("Id Already Found Into The Database Please Chose Diffferent Id");
			throw new IdAlreadyExistException("Id Already Found Into The Database Please Chose Diffferent Id");

		} else {
			logger.info("Inserted A Record Successfully Into The Databases");
			Country addCountry = countryService.addCountry(country);
			return new ResponseEntity<Country>(addCountry, HttpStatus.OK);
		}

	}

	@PutMapping("/updateDetails")
	public ResponseEntity<Object> updateApi(@RequestBody Country country) {
		int id = country.getId();
		// System.out.println(id);
		boolean idThere = countryService.exist(id);
		if (idThere) {
			logger.info("Updated Successfully");
			Country updateCountry = countryService.updateCountry(country);
			return new ResponseEntity<Object>(updateCountry, HttpStatus.ACCEPTED);
		} else {
			logger.error(id + " Id Enterned But Not Found Into The Database So Cant Be Updated");
			throw new CountryNotFoundException("Not Found Id");
		}

	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Country> getId(@PathVariable int id) {
		boolean exist = countryService.exist(id);
		if (exist) {
			logger.info("Fething Value From Database Whose Id Is " + id);
			Country byId = countryService.ById(id);
			return new ResponseEntity<Country>(byId, HttpStatus.OK);
		} else {
			logger.error(id + " Id Enterned But Not Found Into The Database");
			throw new CountryNotFoundException("Id " + id + " Not Found In The Database ");
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteApi(@PathVariable int id) {
		boolean exist = countryService.exist(id);
		if (exist) {
			logger.info("Successfully Deleted From Database");
			String deleteDetail = countryService.deleteDetail(id);
			return new ResponseEntity<Object>(deleteDetail, HttpStatus.OK);

		}
		else 
		{
			logger.error(id + " Id Enterned But Not Found Into The Database So Cant Be Deleted");
			throw new CountryNotFoundException("Entered Id " + id + " Does Not Match To The Record In The Database ");
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Country>> getAllDetails(Country country) {
		logger.info("Successfully Fetched Data From Database");
		List<Country> all = countryService.getAll(country);
		return new ResponseEntity<List<Country>>(all, HttpStatus.OK);
	}

	@GetMapping("/getState/{state}")
	public ResponseEntity<List<Country>> getByState(@PathVariable String state) {
		//String temp = state;
		boolean stateExist = countryService.stateExist(state);
		if(stateExist)
		{
			logger.info("Getting All Details Whose State Is " + state);
			List<Country> by = countryService.byState(state);
			return new ResponseEntity<List<Country>>(by, HttpStatus.ACCEPTED);
		}
		else 
		{
			logger.error("Enterd "+ state +" State Does Not Match In The Database ");
			throw new StateNotFoundException("Entered State  Does Not Match To The Record In The Database ");
		}
		
	}

	@GetMapping("/getCity/{city}")
	public ResponseEntity<List<Country>> getByCity(@PathVariable String city) {
		boolean cityExist = countryService.cityExist(city);
		if(cityExist)
		{
			logger.info("Getting All Details Whose City Name Is " + city);
			List<Country> byCity = countryService.byCity(city);
			return new ResponseEntity<List<Country>>(byCity, HttpStatus.ACCEPTED);
		}
		else 
		{
			logger.error("Enterd "+ city +" City Does Not Match In The Database ");
			throw new CityNotFoundException("Entered State  Does Not Match To The Record In The Database ");
		}
		

	}

	@GetMapping("/code/{code}")
	public ResponseEntity<List<Country>> code(@PathVariable String code) {
		boolean codeExist = countryService.codeExist(code);
		if(codeExist)
		{
			logger.info("Getting Details Of State And City From Database Whose Country Id Is " + code);
			List<Country> bycode = countryService.bycode(code);
			return new ResponseEntity<List<Country>>(bycode, HttpStatus.ACCEPTED);
		}
		else
		{
			throw new CodeNotFoundException("Entered Code Not Found In The Database");
		}
		
	}

}
