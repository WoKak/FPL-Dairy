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
            background-image: url("/resources/images/chelsea.jpg");
        }
    </style>
    <script type="text/javascript" src="<c:url value="/resources/jquery/jquery-3.2.1.min.js" />"></script>
</head>
</head>
<body>
<h1 id="game">fpl dairy</h1>
<p id="dashboardPage"></p>
<div class="nav">
    <ul>
        <li><a href="<spring:url value="/dashboard"/>">dashboard</a></li>
        <li><a href="<spring:url value="/addMatch"/>">dodaj mecz</a></li>
    </ul>
</div>
<table id="content">
    <tr>
        <td>
            <form id="matchday_form">
                <label>Numer kolejki</label>
                <br>
                <input type="text" id="day_number">
                <br>
                <input type="submit" class="button" value="szukaj" id="search"/>
            </form>
        </td>
        <td>
            <div id="games"></div>
        </td>
        <td>
            <div id="note"></div>
        </td>
    </tr>
</table>
<form:form action="${'/logout'}" method="post">
    <input type="submit" class="button" value="wyloguj"/>
</form:form>
<script type="text/javascript" src="/resources/js/find_matches.js"></script>
<script type="text/javascript" src="/resources/js/find_note.js"></script>
</body>
</html>