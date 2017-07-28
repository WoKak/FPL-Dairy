<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html>
<head>
	<title>game</title>
	<link rel="stylesheet"
		  type="text/css"
		  href="<c:url value="/resources/styles/main.css" />">
	<style>
		body {
			background-image: url("/resources/images/chelsea.jpg");
		}
	</style>
</head>
<body>
	<p>Hello! :D</p>
	<form:form action="${'/logout'}" method="post">
		<input type="submit" id="button" value="wyloguj"/>
	</form:form>
</body>
</html>