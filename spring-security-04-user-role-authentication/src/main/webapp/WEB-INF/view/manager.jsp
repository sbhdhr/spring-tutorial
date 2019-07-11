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
			
			<div class="panel panel-primary ">
			  <div class="panel-heading">Welcome Manager</div>
			  <div class="panel-body">
			  	<p>This is exclusive to managers only</p>
			  	<p><a href="${pageContext.request.contextPath}/" class="btn btn-primary">Homepage</a></p>
			  </div>
			</div>
			
		</div>
		
		
		<div class="container" style="margin-top:50px;">
		  <p>Credentials : </p>
		  <p>User : <security:authentication property="principal.username"/></p>      
		  <p>Roles :  <security:authentication property="principal.authorities"/></p>      
		
		</div>
		
		
		
		
		
		
		
		
		
		
		
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