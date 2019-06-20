<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Student - Registration Form</title>
	</head>
	
	
	<body>
	
		<h2>Student - Registration Form</h2>
		
		<form:form action="processForm" modelAttribute="student">
			
			First name : <form:input path="firstName"/>
			
			<br><br>
			Last name : <form:input path="lastName"/>
			
			<br><br>Country : 
				<form:select path="country">
					
					<%-- <form:option value="BraziL" label="Brazil " /> 
					<form:option value="France" label="France" /> 
					<form:option value="Germany" label="Germany" /> 
					<form:option value="India" label="India" /> --%>
					
					<form:options path="country" items="${student.countryOptions}"/>
					
				</form:select> 
				
			<br><br>
			Favorite Language:<br>
			<%-- Java <form:radiobutton path="favoriteLanguage" value="Java"/>
			C# <form:radiobutton path="favoriteLanguage" value="C#"/>
			Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
			Perl <form:radiobutton path="favoriteLanguage" value="Perl"/> --%>
			
			<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  />
			
			<br><br>
			Operating Systems:<br>
			Windows <form:checkbox path="operatingSystems" value="Windows"/><br>
			Linux <form:checkbox path="operatingSystems" value="Linux"/><br>
			MacOS <form:checkbox path="operatingSystems" value="MacOS"/><br>
			Android <form:checkbox path="operatingSystems" value="Android"/><br>
			
			
			
			<br><br>
			<input type="submit" value="Submit"/>
			
		</form:form>
	
	</body>
</html>