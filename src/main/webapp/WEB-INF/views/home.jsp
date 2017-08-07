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
            background-image: url("/resources/images/manu.jpg");
        }
    </style>
</head>
<body>
<h1 id="game">fpl dairy</h1>
<p id="homePage"></p>
<p>Aplikacja/dziennik gry w fantasy football.</p>
<p><a href=" <spring:url value="/dashboard"/> ">Graj teraz!</a></p>
</div>
</body>
</html>
