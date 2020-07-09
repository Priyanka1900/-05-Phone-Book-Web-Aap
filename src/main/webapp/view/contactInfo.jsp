<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h2>save contact</h2>	
	<p><font color='green'>${succMsg}</font></p>
	<p><font color='red'>${errMsg}</font></p>		
    <form:form action="saveContact" modelAttribute="contact" model="post">
	<table border="1">
			<tr>
						<form:hidden path="contactId"/>
						<td>Contact Name : </td>
						<td><form:input path="contactName"/></td>
			</tr>
			<tr>
						<td>Contact Email :</td>
						<td><form:input path="contactEmail"/></td>
			</tr>
			<tr>
						<td>Contact Number :</td>
						<td><form:input path="contactNumber"/></td>
			</tr>
			<tr>
						<td><input type="reset" value="reset"/></td>
						<td><input type="submit" value="save"/></td>
			</tr>
		</table>
</form:form>
			<a href="viewContacts">view All Contacts</a>
</body>
</html>