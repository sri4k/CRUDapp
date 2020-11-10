package org.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.app.dao.CountryDao;
import org.app.model.Country;


@WebServlet("/home")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CountryDao countryDao = new CountryDao();
	
    public CountryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 	List<Country> list = null;
		try {
			list = countryDao.getCountries();
			System.out.println(list.size());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 	
	 	request.setAttribute("list", list);
	 	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	 	dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String countryCode = request.getParameter("country_code");
		String countryName = request.getParameter("country_name");
		String capitalCity = request.getParameter("capital_city");
		String currencyCode = request.getParameter("currency_code");
		
		Country country = new Country();
		country.setCountryCode(countryCode);
		country.setCountryName(countryName); 
		country.setCapitalCity(capitalCity);
		country.setCurrencyCode(currencyCode);
		
		try {
			countryDao.save(country);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		
		response.sendRedirect("/CRUDapp/home");
	}
}
