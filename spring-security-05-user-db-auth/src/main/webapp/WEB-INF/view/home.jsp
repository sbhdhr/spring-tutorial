<%@page import="spring.security.db.auth.constants.UrlConstants"%>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>

	<jsp:include page="includes/standardHeader.jsp"></jsp:include>
	
	
	
	
	<body>
	
		<jsp:include page="includes/navBar.jsp"></jsp:include>
	
	
		<div class="container">
		  <div class="page-header">
		    <h1>${title}</h1>      
		  </div>
		  <p>User : <security:authentication property="principal.username"/></p>      
		  <p>Roles :  <security:authentication property="principal.authorities"/></p>      
		</div>
	
		
		<security:authorize access="hasRole(T(spring.security.db.auth.constants.Roles).MANAGER)">
			
			<div class="container">
				<div class="page-header">
					<p><a href="${pageContext.request.contextPath}${UrlConstants.MANAGER_PAGE_URL}"
					class="btn btn-primary">Manager Dashboard</a></p> 
				</div>
			
			</div>
		</security:authorize>
		
		
		<security:authorize access="hasRole(T(spring.security.db.auth.constants.Roles).ADMIN)">
			
			<div class="container">
				<div class="page-header">
					<p><a href="${pageContext.request.contextPath}${UrlConstants.ADMIN_PAGE_URL}"
					class="btn btn-danger">Admin Dashboard</a></p> 
				</div>
			
			</div>
		</security:authorize>
		
		
		<jsp:include page="includes/standardFooter.jsp"></jsp:include>
	
	</body>
	
</html>