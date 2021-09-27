package com.plasmit.countryapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plasmit.countryapi.dao.CountryDao;
import com.plasmit.countryapi.entities.Country;

@Service
public class CountryService 
{
	@Autowired
	CountryDao countryDao;
	
	public Country addCountry(Country country)
	{
		return countryDao.saveDetails(country);
	}
	public Country updateCountry(Country country)
	{
		return countryDao.updateDetails(country);
	}
	
	public Country ById(int id)
	{
		return countryDao.getById(id);
	}
	public String deleteDetail(int id)
	{
		return countryDao.deleteById(id);
	}
	public List <Country> getAll(Country country)
	{
		return countryDao.allDetails();
	}
	public  List <Country> byState(String sname)
	{
		return countryDao.getState(sname);
	}
	public List <Country> byCity(String cityname)
	{
		return countryDao.getCity(cityname);
	}
	public List <Country> bycode(String code)
	{
		return countryDao.getByCode(code);
	}
	public boolean exist(int id)
	{
		return countryDao.isExist(id);
	}
	public boolean stateExist(String state)
	{
		return countryDao.isStateExist(state);
	}
	public boolean cityExist(String city)
	{
		return countryDao.isCityExist(city);
	}
	public boolean codeExist(String code)
	{
		return countryDao.iscodeExist(code);
	}
	
}
