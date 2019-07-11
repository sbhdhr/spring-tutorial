<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

	<head>
	<title>${title}</title>
	</head>
	
	
	
	
	<body>
	
		<h2>${title}</h2>
		
		<form:form action="${pageContext.request.contextPath}/authenticateUser" method="post">
			
			<c:if test="${param.error != null}">
				<i style="color:red;">Invalid credentials</i>
			
			</c:if>
			<p>
				User Name: <input type="text" name="username" />
			</p>
			
			<p>
				Password: <input type="password" name="password" />
			</p>
			
			<p>
				<input type="submit" value="Login" />
			</p>
		
		</form:form>
	
	</body>
	
</html>