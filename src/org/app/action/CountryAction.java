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
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";}
		
	}
}
