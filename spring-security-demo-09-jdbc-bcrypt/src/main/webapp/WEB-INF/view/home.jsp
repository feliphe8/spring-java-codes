<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title> Home Page</title>
		
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
		<!-- Reference Bootstrap files -->
		<link rel="stylesheet"
		 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	
	<body class = "container">
		<h1>Home Page</h1>
		
		<hr>
		
		<p> User: <security:authentication property = "principal.username" /> </p>
		<p> Role(s): <security:authentication property = "principal.authorities" /> </p>
		
		<hr>
		
		<security:authorize access="hasRole('MANAGER')">
			<p><a href = "${pageContext.request.contextPath}/leaders">Leadership Meeting</a> (Only for Manager people) </p>
		</security:authorize>
		
		<hr>
		
		<security:authorize access="hasRole('ADMIN')">
			<p><a href = "${pageContext.request.contextPath}/systems">IT Systems Meeting</a> (Only for Admin people) </p>
		</security:authorize>
		
		<hr>
		
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value = "Logout"/>
		</form:form>
	</body>

</html>