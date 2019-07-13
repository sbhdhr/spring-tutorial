<!DOCTYPE html>
<html>

	<jsp:include page="includes/standardHeader.jsp"></jsp:include>
	
	<body>
	
		<jsp:include page="includes/navBar.jsp"></jsp:include>
	
	
		<!----------------- Content -------------------->
	
	
		
		<div class="container">
		  <div class="page-header">
		    <h1 style="color:red;">${title}</h1>      
		  </div>
		  <p>This incident will be logged and reported.</p> 
		  <p><a href="${pageContext.request.contextPath}/" class="btn btn-primary">Homepage</a></p>  
		  
		</div>
		
		
		
		
		<!--------------------------------------------->
		
		<jsp:include page="includes/credFooter.jsp"></jsp:include>
		<jsp:include page="includes/standardFooter.jsp"></jsp:include>
		
	
	</body>
	
</html>





		