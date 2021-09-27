package com.plasmit.countryapi.entities;

import org.springframework.data.annotation.Id;

public class Country {
	@Id
	private int id;
	private String cid;
	private String country;
	private String state;
	private String city;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "CountryApi [id=" + id + ", cid=" + cid + ", country=" + country + ", state=" + state + ", city=" + city
				+ "]";
	}

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(int id, String cid, String country, String state, String city) {
		super();
		this.id = id;
		this.cid = cid;
		this.country = country;
		this.state = state;
		this.city = city;
	}

}
