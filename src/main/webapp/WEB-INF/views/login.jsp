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
            background-image: url("/resources/images/lfc.jpg");
        }
    </style>
</head>
<body>
    <h1 id="game">game</h1>
    <p id="msg">${msg}</p>
	<p>
        Zaloguj się,
        <a href=" <spring:url value="/register"/> ">zarejestruj</a>
        lub
        <a href=" <spring:url value="/home"/> ">wróć do strony głównej</a>.
    </p>
    <div class="box">
        <form:form action="${'/login'}" method="post">
            <div class="form-group">
                <input type="text" name="username" placeholder="login"/>
                <br>
                <br>
                <input type="password" name="password" placeholder="hasło"/>
            </div>
            <div class="form-group">
                <input type="submit" id="button" value="zaloguj"/>
            </div>
        </form:form>
    </div>
</body>
</html>