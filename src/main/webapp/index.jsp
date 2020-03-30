<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo Spring Rest</title>
</head>
<body>

<h1>Welcome to Spring Rest Demo</h1>
<hr>

<a href="test/hello"> Click Here to Test Basic Rest Controller !!!</a>
<hr>
<br>
<a href="${pageContext.request.contextPath}/api/getAllStudents">Click to Get all Students</a>

</body>
</html>