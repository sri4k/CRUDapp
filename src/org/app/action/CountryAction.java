package org.app.action;

import java.util.ArrayList;

import org.app.dao.CountryDao;
import org.app.model.Country;

public class CountryAction {
	
	ArrayList<Country> list = new ArrayList<Country>();
	String countryCode;
	String countryName;
	String capitalCity;
	String currencyCode;
	
	public ArrayList<Country> getList() {
		return list;
	}

	public void setList(ArrayList<Country> list) {
		this.list = list;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCapitalCity() {
		return capitalCity;
	}

	public void setCapitalCity(String capitalCity) {
		this.capitalCity = capitalCity;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCountries() {
     
		try {
			list = CountryDao.getCountries();
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";}
	   
	}
	
	public String saveCountry() {
		Country country = new Country(countryCode, countryName, capitalCity, currencyCode);

		try {
			CountryDao.save(country);
			list = CountryDao.getCountries();
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";}
		
	}
}
