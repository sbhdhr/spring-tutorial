

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
		  </div>
		</nav>
	
	
		
		
		<div class="container">
		  <div class="page-header">
		    <h1 style="color:red;">${title}</h1>      
		  </div>
		  <p>This incident will be logged and reported.</p> 
		  <p><a href="${pageContext.request.contextPath}/" class="btn btn-primary">Homepage</a></p>  
		  
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