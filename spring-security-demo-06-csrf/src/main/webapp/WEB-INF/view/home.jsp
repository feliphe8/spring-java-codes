<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title> Home Page</title>
	</head>
	
	<body>
		<h1>Home Page</h1>
		
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value = "Logout"/>
		</form:form>
	</body>

</html>