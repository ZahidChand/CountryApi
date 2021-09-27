package com.plasmit.countryapi.dao;

import java.util.List;

import com.plasmit.countryapi.entities.Country;

public interface CountryDao 
{
	Country saveDetails(Country country);
	
	Country updateDetails(Country country);

	Country getById(int id);

	String deleteById(int id);

	List<Country> allDetails();
	
	List <Country> getState(String statename);

	List <Country> getCity(String city);
	
	List<Country> getByCode(String code);
	
	public boolean isExist(int id);  
	
	public boolean isStateExist(String state);
	
	public boolean isCityExist(String city);
	
	public boolean iscodeExist(String code);
}
