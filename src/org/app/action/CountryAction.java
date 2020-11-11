package org.app.action;

import java.util.ArrayList;
import java.util.List;

import org.app.dao.CountryDao;
import org.app.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryAction {
	
	List<Country> list = new ArrayList<Country>();
	String countryCode;
	String countryName;
	String capitalCity;
	String currencyCode;
	@Autowired
	CountryDao countryDao;
	
	public CountryDao getCountryDao() {
		return countryDao;
	}

	public void setCountryDao(CountryDao countryDao) {
		this.countryDao = countryDao;
	}

	public List<Country> getList() {
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
			list = countryDao.getCountries();
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";}
	   
	}
	
	public String saveCountry() {
		Country country = new Country(countryCode, countryName, capitalCity, currencyCode);

		try {
			countryDao.saveCountry(country);
			list = countryDao.getCountries();
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";}
		
	}
	
//	HibernateTemplate template;  
//	public void setTemplate(HibernateTemplate template) {  
//	    this.template = template;  
//	}  
//	//method to save employee  
//	public void saveEmployee(Employee e){  
//	    template.save(e);  
//	}  
//	//method to update employee  
//	public void updateEmployee(Employee e){  
//	    template.update(e);  
//	}  
//	//method to delete employee  
//	public void deleteEmployee(Employee e){  
//	    template.delete(e);  
//	}  
//	//method to return one employee of given id  
//	public Employee getById(int id){  
//	    Employee e=(Employee)template.get(Employee.class,id);  
//	    return e;  
//	}  
//	//method to return all employees  
//	public List<Employee> getEmployees(){  
//	    List<Employee> list=new ArrayList<Employee>();  
//	    list=template.loadAll(Employee.class);  
//	    return list;  
//	}  
}
