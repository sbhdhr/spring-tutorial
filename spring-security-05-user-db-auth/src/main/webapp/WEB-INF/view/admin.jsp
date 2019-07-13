<!DOCTYPE html>
<html>

	<jsp:include page="includes/standardHeader.jsp"></jsp:include>
	
	<body>
	
		<jsp:include page="includes/navBar.jsp"></jsp:include>
	
	
		<!----------------- Content -------------------->
	
	
		
		<div class="container">			
			<div class="panel panel-danger ">
			  <div class="panel-heading">Welcome Admin</div>
			  <div class="panel-body">
			  	<p>System admins chill out here !!</p>
			  	<p><a href="${pageContext.request.contextPath}/" class="btn btn-danger">Homepage</a></p>
			  </div>
			</div>			
		</div>
		
		
		
		
		<!--------------------------------------------->
		
		<jsp:include page="includes/credFooter.jsp"></jsp:include>
		<jsp:include page="includes/standardFooter.jsp"></jsp:include>
		
	
	</body>
	
</html>