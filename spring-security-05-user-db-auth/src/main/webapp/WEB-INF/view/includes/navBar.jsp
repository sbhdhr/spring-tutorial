<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<nav class="navbar navbar-inverse" style="border-radius: 0px; ">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">Spring Security DB Auth</a>
		    </div>
		    <form:form action="${pageContext.request.contextPath}/logout" method="post">
			    <ul class="nav navbar-nav navbar-right">
			    <li><input class="btn btn-danger navbar-btn" type="submit" value="Logout"/></li>
		      		<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>			      	
			    </ul>
		    </form:form>
		    
		  </div>
		</nav>