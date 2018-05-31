<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		
		<title> Student Form</title>
	</head>
	<body class="container">
		<form:form action="processForm" modelAttribute="student">
		
		First Name: <form:input path="firstName"/>
		<br><br>
		Last Name: <form:input path="lastName"/>
		<br><br>
		
		Country: <form:select path="country">
					<form:options items="${student.countryOptions}" />
				</form:select>
		<br><br>
		
		Favorite Programming Language:
			Java <form:radiobutton path="favoriteLanguage" value="Java"/>
			C# <form:radiobutton path="favoriteLanguage" value="C#"/>
			PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
			Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
			
		<br><br>
		
		Operating Systems: 
			Linux <form:checkbox path="operatingSystems" value="Linux"/>
			Mac OS <form:checkbox path="operatingSystems" value="Mac Os"/>
			MS Windowms <form:checkbox path="operatingSystems" value="MS Windowms"/>
		
		<input type="submit" value="Submit"/>
		
		</form:form>
	</body>
</html>