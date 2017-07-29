<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>game</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/styles/main.css" />">
    <style>
        body {
            background-image: url("/resources/images/arsenal.jpg");
        }
    </style>
</head>
<body>
<h1 id="game">fpl dairy</h1>
<div class="nav">
    <ul>
        <li><a href="<spring:url value="/dashboard"/>">dashboard</a></li>
        <li><a href="<spring:url value="/admin"/>">dodaj mecz</a></li>
    </ul>
</div>
<p>Uzupełnij notatki z meczu</p>
<div class="box">
    <form:form modelAttribute="newMatch">
        <label>Kolejka:</label>
        <div class="form-group">
            <form:input id="dayNumber" path="dayNumber" type="text"/>
        </div>
        <label>Gospodarze:</label>
        <div>
            <form:input id="homeTeam" path="homeTeam" type="text"/>
        </div>
        <label>Goście:</label>
        <div>
            <form:input id="awayTeam" path="awayTeam" type="text"/>
        </div>
        <label>Gole gospodarzy:</label>
        <div>
            <form:input id="homeGoals" path="homeGoals" type="text"/>
        </div>
        <label>Gole gości:</label>
        <div>
            <form:input id="awayGoals" path="awayGoals" type="text"/>
        </div>
        <label>Notatka:</label>
        <div>
            <form:textarea id="note" path="note" rows="15" cols="45"  type=""/>
        </div>
        <div class="form-group">
            <input type="submit" id="button" value="dodaj"/>
        </div>
    </form:form>
</div>
</body>
</html>
