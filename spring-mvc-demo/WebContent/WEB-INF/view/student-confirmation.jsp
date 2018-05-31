<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/materialize.css">
    	<script src="${pageContext.request.contextPath}/resources/js/materialize.js"></script>
		<title> Student Confirmation</title>
	</head>
	<body>
		<p>The student is confirmed: ${student.firstName} ${student.lastName}</p>
		<p>Country: ${student.country}</p>
		<p>Student's favorite programming language: ${student.favoriteLanguage}</p>
		
		Operating Systems
		<ul>
		<c:forEach var="temp" items="${student.operatingSystems }">
			<li>${temp}</li>
		</c:forEach>
		</ul>
	</body>
</html>