<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Custom Login Page</title>
		
		<style>
			.failed {color: red;}
		</style>
	</head>
	
	<body>
		<h1>My Custom Login Page</h1>
		<form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
		
			<c:if test="${param.error != null}">
				<i class="failed">Sorry! You entered invalid username/password.</i>
			</c:if>
		
			<label>
				User name: <input type = "text" name="username"/>
			</label>
			
			<label>
				Password: <input type = "password" name="password"/>
			</label>
			
			<input type = "submit" value = "Login" />
		</form:form>
	
	</body>
</html>