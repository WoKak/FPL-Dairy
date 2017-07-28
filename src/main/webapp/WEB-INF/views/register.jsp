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
<h1 id="game">game</h1>
<p>
    <a href="<spring:url value="/home"/>">Powrót do strony głównej</a>.
</p>
<div class="box">
    <form:form modelAttribute="userToRegister">
        <label>Login:</label>
        <div class="form-group">
            <form:input id="login" path="login" type="text" htmlEscape="true"/>
        </div>
        <label>Password:</label>
        <div>
            <form:input id="password" path="password" type="password" onkeyup="counter();"/>
        </div>
        <label>Repeat password:</label>
        <div>
            <form:input id="repeatedPassword" path="repeatedPassword" type="password" htmlEscape="true"/>
        </div>
        <div class="form-group">
            <input type="submit" id="button" value="Register"/>
        </div>
    </form:form>
</div>
</body>
</html>
