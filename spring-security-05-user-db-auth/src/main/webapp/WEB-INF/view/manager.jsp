<!DOCTYPE html>
<html>

	<jsp:include page="includes/standardHeader.jsp"></jsp:include>
	
	<body>
	
		<jsp:include page="includes/navBar.jsp"></jsp:include>
	
	
		<!----------------- Content -------------------->
	
	
		
		<div class="container">			
			<div class="panel panel-primary ">
			  <div class="panel-heading">Welcome Manager</div>
			  <div class="panel-body">
			  	<p>This is exclusive to managers only</p>
			  	<p><a href="${pageContext.request.contextPath}/" class="btn btn-primary">Homepage</a></p>
			  </div>
			</div>			
		</div>
		
		
		
		
		<!--------------------------------------------->
		
		<jsp:include page="includes/credFooter.jsp"></jsp:include>
		<jsp:include page="includes/standardFooter.jsp"></jsp:include>
		
	
	</body>
	
</html>