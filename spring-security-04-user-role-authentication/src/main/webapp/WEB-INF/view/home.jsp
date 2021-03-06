<%@page import="spring.security.demo.controller.HomeController"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>

	<head>
	<title>${title}</title>
	
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css">
	
	</head>
	
	
	
	
	<body>
	
		<nav class="navbar navbar-inverse" style="border-radius: 0px; ">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">Spring Security Demo</a>
		    </div>
		    <form:form action="${pageContext.request.contextPath}/logout" method="post">
			    <ul class="nav navbar-nav navbar-right">
			    <li><input class="btn btn-danger navbar-btn" type="submit" value="Logout"/></li>
		      		<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>			      	
			    </ul>
		    </form:form>
		    
		  </div>
		</nav>
	
	
		<div class="container">
		  <div class="page-header">
		    <h1>${title}</h1>      
		  </div>
		  <p>User : <security:authentication property="principal.username"/></p>      
		  <p>Roles :  <security:authentication property="principal.authorities"/></p>      
		</div>
	
		
		<security:authorize access="hasRole(T(spring.security.demo.constants.Roles.Role).MANAGER)">
			
			<div class="container">
				<div class="page-header">
					<p><a href="${pageContext.request.contextPath}${HomeController.MANAGER_PAGE_URL}"
					class="btn btn-primary">Manager Dashboard</a></p> 
				</div>
			
			</div>
		</security:authorize>
		
		
		<security:authorize access="hasRole(T(spring.security.demo.constants.Roles.Role).ADMIN)">
			
			<div class="container">
				<div class="page-header">
					<p><a href="${pageContext.request.contextPath}${HomeController.ADMIN_PAGE_URL}"
					class="btn btn-danger">Admin Dashboard</a></p> 
				</div>
			
			</div>
		</security:authorize>
		
		
		
			
			
		
		
		<!--===============================================================================================-->
			<script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
		<!--===============================================================================================-->
			<script src="<%=request.getContextPath()%>/resources/vendor/animsition/js/animsition.min.js"></script>
		<!--===============================================================================================-->
			<script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/popper.js"></script>
			<script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
		<!--===============================================================================================-->
		
	
	</body>
	
</html>