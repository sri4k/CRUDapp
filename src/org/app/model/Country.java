package org.app.model;

public class Country {

	private String countryCode;
	private String countryName;
	private String capitalCity;
	private String currencyCode;
	
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
	public Country() {
		super();
	}
	public Country(String countryCode, String countryName, String capitalCity, String currencyCode) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.capitalCity = capitalCity;
		this.currencyCode = currencyCode;
	}
	
}
