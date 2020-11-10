<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUDapp</title>
</head>
<body>
<div align="center">
  <h1>CRUD Application</h1>
  <br/>
  <h2>User Entry</h2>
    
  <form action="/CRUDapp/home" method="post">
    Country Code: <input type = "text" name = "country_code" />
    <br />
    Country Name: <input type = "text" name = "country_name" />
    <br/>
    Capital City: <input type = "text" name = "capital_city" />
    <br/>
    Currency Code: <input type = "text" name = "currency_code" />
    <br/>
    
    <input type="submit" value="Submit" />
  </form>
 </div>
 <br/>
 <div align="center">
  <h2>Results</h2>
   <table>
		<c:forEach items = "${list}" var = "country">
			<tr>
				<td>${country.countryCode}</td>
				<td>${country.countryName}</td>
				<td>${country.capitalCity}</td>
				<td>${country.currencyCode}</td>
			</tr>
		</c:forEach>
	</table>
 </div>
</body>
</html>