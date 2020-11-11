package org.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.app.model.Country;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class CountryDao {
//	public int save(Country country) throws ClassNotFoundException
//	{
//		String insertCountry = "INSERT INTO country " +
//									"(country_code, country_name, capital_city, currency_code) values " +
//									"(?,?,?,?)" ;
//		
//		int res = 0;
//		
//		Class.forName("com.mysql.jdbc.Driver");
//		
//		try (Connection conn = DriverManager.
//				getConnection("jdbc:mysql://localhost:3306/webdb?useSSL=false", "root", "root");
//				PreparedStatement ps = conn.prepareStatement(insertCountry)) {
//			
//			ps.setString(1, country.getCountryCode());
//			ps.setString(2, country.getCountryName());
//			ps.setString(3, country.getCapitalCity()); 
//			ps.setString(4, country.getCurrencyCode());
//			
//			res = ps.executeUpdate();
//			System.out.println("Inserted into db " + res);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return res;	
//	}
//	
//	public ArrayList<Country> getCountries() throws ClassNotFoundException
//	{
//		ArrayList<Country> list = new ArrayList<Country>();
//		String getCountries = "SELECT * FROM country" ;
//		
//		Class.forName("com.mysql.jdbc.Driver");
//		
//		try (Connection conn = DriverManager.
//				getConnection("jdbc:mysql://localhost:3306/webdb?useSSL=false", "root", "root")) {
//				
//			Statement s = conn.createStatement();
//			ResultSet rs = s.executeQuery(getCountries);
//			
//			while(rs.next()) {
//				Country country = new Country();
//				country.setCountryCode(rs.getString("country_code"));
//				country.setCountryName(rs.getString("country_name"));
//				country.setCapitalCity(rs.getString("capital_city"));
//				country.setCurrencyCode(rs.getString("currency_code"));
//				list.add(country);
//			}
//			
//			System.out.println("Fetched from db " + rs.getFetchSize());
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
	
	public static int saveCountry(Country country) {
    	Session session = new Configuration().configure("hibernate.cfg.xml").
    						buildSessionFactory().openSession();
    	Transaction t = session.beginTransaction();
    	
    	int i = (Integer)session.save(country);
    	
    	t.commit();
    	session.close();
    	return i;
    }
    
    public List<Country> getCountries() throws Exception{
        
        Session session = new Configuration().configure("hibernate.cfg.xml").
					buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        
        try{    
			List<Country> countryList = session.createSQLQuery("SELECT * FROM country").list();
	        if(countryList.size() > 0)
	        {
	            return countryList;
	        }
        } 
        catch(Exception e) {
            throw e;
        }
        finally {
        	session.close();
        }
        
        return null;  
    }
}
