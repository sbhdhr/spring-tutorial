<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Student - Registration Confirmation</title>
	</head>
	
	
	<body>
	
		<h2>Student - Registration Confirmation</h2>
		
		<br>
		<br>
		
		<h4>The student is confirmed : ${student.firstName}  ${student.lastName}</h4>
		
		<br>
		<br>
		
		<h4>Country : ${student.country}</h4>
		
		<br>
		<br>
		
		<h4>Favorite Language : ${student.favoriteLanguage}</h4>
		
		
		<br>
		<br>
		
		<h4>Operating Systems : </h4><br>
		<ul>
			<c:forEach var="temp" items="${student.operatingSystems}">
				<li> ${temp} </li>
			</c:forEach> 
		</ul>
	
	</body>
</html>