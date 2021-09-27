package com.plasmit.countryapi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.plasmit.countryapi.entities.Country;

@Repository
public class CountryDaoImpl implements CountryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public CountryDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Country saveDetails(Country country) {
		String sql = "insert into countrydetails values(?,?,?,?,?)";
		jdbcTemplate.update(sql, country.getId(), country.getCid(), country.getCountry(), country.getState(),
				country.getCity());
		return country;
	}

	@Override
	public Country updateDetails(Country country) {
		String sql = "update countrydetails set cid = ?, country = ? ,state = ?,city = ? where id = ?";
		jdbcTemplate.update(sql, country.getCid(), country.getCountry(), country.getState(), country.getCity(),
				country.getId());
		return country;
	}

	@Override
	public Country getById(int id) {
		String sql = "select * from countrydetails where id =?";
		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			return new Country(rs.getInt("id"), rs.getString("cid"), rs.getString("country"), rs.getString("state"),
					rs.getString("city"));
		}, id);
	}

	@Override
	public String deleteById(int id) {
		String sql = "delete from countrydetails where id =?";
		jdbcTemplate.update(sql, id);
		return "Successfully Deleted Record From Database whose Id = " + id;

	}

	@Override
	public List<Country> allDetails() {
		String sql = "select * from countrydetails";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			return new Country(rs.getInt("id"), rs.getString("cid"), rs.getString("country"), rs.getString("state"),
					rs.getString("city"));
		});
	}

	public List<Country> getState(String statename) {
		String sql = "select * from countrydetails where state = ?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, statename);
		
		List<Country> countryList = new ArrayList<Country>();

		for (Map<String, Object> map : list) {
			Country country = new Country();
			country.setId((Integer) map.get("id"));
			country.setCid((String) map.get("cid"));
			country.setCountry((String) map.get("country"));
			country.setState((String) map.get("state"));
			country.setCity((String) map.get("city"));
			countryList.add(country);
		}
		return countryList;
	}

	@Override
	public List<Country> getCity(String city) {
		String sql = "select * from countrydetails where city = ?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, city);

		List<Country> countryList = new ArrayList<Country>();

		for (Map<String, Object> map : list) {
			Country country = new Country();
			country.setId((Integer) map.get("id"));
			country.setCid((String) map.get("cid"));
			country.setCountry((String) map.get("country"));
			country.setState((String) map.get("state"));
			country.setCity((String) map.get("city"));
			countryList.add(country);
		}
		return countryList;

	}

	@Override
	public List<Country> getByCode(String code) {
		String sql = "select * from countrydetails where cid = ?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, code);

		List<Country> countryList = new ArrayList<Country>();

		for (Map<String, Object> map : list) {
			Country country = new Country();
			country.setId((Integer) map.get("id"));
			country.setCid((String) map.get("cid"));
			country.setCountry((String) map.get("country"));
			country.setState((String) map.get("state"));
			country.setCity((String) map.get("city"));
			countryList.add(country);
		}
		return countryList;
	}

	@Override
	public boolean isExist(int id) {
		String sql = "select count(*) from countrydetails where id =?";
		int count = jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);

		if (count >= 1) {
			return true;
		}
		return false;

	}

	public boolean isStateExist(String state) {
		String sql = "Select count(*) from countrydetails where state =?";
		int count = jdbcTemplate.queryForObject(sql, new Object[] { state }, Integer.class);
		if (count >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isCityExist(String city) {
		String sql = "Select count(*) from countrydetails where city =?";
		int count = jdbcTemplate.queryForObject(sql, new Object[] { city }, Integer.class);
		if (count >= 1) {
			return true;
		}
		return false;

	}

	@Override
	public boolean iscodeExist(String code) {
		String sql = "select count(*) from countrydetails where cid =?";
		int count = jdbcTemplate.queryForObject(sql, new Object[] { code }, Integer.class);

		if (count >= 1) {
			return true;
		}
		return false;
	}

}
