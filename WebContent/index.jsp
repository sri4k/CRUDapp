<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Country List</title>
</head>
<body>
 <div>
 	
  	<h3>Enter new Country</h3>
 	<s:form action="home" method="POST">  
		<s:textfield name="countryCode" label="Country Code"></s:textfield>  
		<s:textfield name="countryName" label="Country Name"></s:textfield>  
		<s:textfield name="capitalCity" label="Capital CIty"></s:textfield>  
		<s:textfield name="currencyCode" label="Currency Code"></s:textfield>  
		
		<s:submit value="Save"></s:submit>
	</s:form>
	<br/>
	<h3>Country List</h3>
 	<table>
 		<!-- <fieldset>   -->
		<s:iterator  value="list">  
		<tr>
			<td><s:property value="countryCode"/></td>
			<td><s:property value="countryName"/></td>
			<td><s:property value="capitalCity"/></td>
			<td><s:property value="currencyCode"/></td>
		</tr>
		</s:iterator>  
   	
		<!-- </fieldset>   -->
	</table>
	
  </div>
</body>
</html>