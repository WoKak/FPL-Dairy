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
            background-image: url("/resources/images/tott.jpg");
        }
    </style>
</head>
<body>
<h1 id="game">fpl dairy</h1>
<p id="registerPage"></p>
<p>
    <a href="<spring:url value="/home"/>">Powrót do strony głównej</a>.
</p>
<div class="box">
    <form:form modelAttribute="userToRegister">
        <label>Login:</label>
        <div class="form-group">
            <form:input id="login" path="login" type="text"/>
        </div>
        <label>Hasło:</label>
        <div>
            <form:input id="password" path="password" type="password"/>
        </div>
        <label>Powtórz hasło:</label>
        <div>
            <form:input id="repeatedPassword" path="repeatedPassword" type="password"/>
        </div>
        <div class="form-group">
            <input type="submit" class="button" value="rejestruj"/>
        </div>
    </form:form>
</div>
</body>
</html>
