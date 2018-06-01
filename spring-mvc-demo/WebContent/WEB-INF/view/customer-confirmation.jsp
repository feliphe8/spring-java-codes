<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/materialize.css">
    	<script src="${pageContext.request.contextPath}/resources/js/materialize.js"></script>
		<title> Customer Confirmation</title>
	</head>
	<body>
		<p>The customer is confirmed: ${customer.firstName} ${customer.lastName}</p>
		<p>Free passes: ${customer.freePasses} </p>
		<p>Postal Code: ${customer.postalCode} </p>
		<p>Course Code: ${customer.courseCode} </p>
	</body>
</html>