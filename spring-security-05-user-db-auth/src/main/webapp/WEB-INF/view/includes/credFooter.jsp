
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<style>
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: #084a82;
	color: white;
	text-align: center;
	padding: 10px;
}
</style>


<div class="container-fluid footer">
	Credentials :
	<security:authentication property="principal.username" />
	Roles :
	<security:authentication property="principal.authorities" />
</div>

