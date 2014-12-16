<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Menu</title>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
</head>
<body>	
	<img src="resources/images/Header_Logo-small.jpg"  style="border:0;">
	<h2>${type} Screen</h2>
	<div>
		<form id="accusesuggestForm" method="post" action="">
		Character:<br />
		<select name="character">
			<c:if test="${not empty players}">
				<c:set var="count" value="0" scope="page" />
				<c:forEach var="player" items="${players}">
					<c:set var="count" value="${count + 1}" scope="page"/>
					<option value="${count}">${player}</option>
				</c:forEach>
			</c:if>
		</select><br />
		<br />
		Weapon:<br />
		<select name="weapon">
			<c:if test="${not empty weapons}">
				<c:set var="count" value="0" scope="page" />
				<c:forEach var="weapon" items="${weapons}">
					<c:set var="count" value="${count + 1}" scope="page"/>
					<option value="${count}">${weapon}</option>
				</c:forEach>
			</c:if>
		</select><br />
		<br />
		Room:<br />
		<c:choose>
			<c:when test="${type == 'Suggest'}">
				<input type="hidden" name="room" value="0"><span style="font-weight:bold;">${currentPlace}</span>
			</c:when>
			<c:otherwise>
				<select name="room">
					<c:if test="${not empty places}">
						<c:set var="count" value="0" scope="page" />
						<c:forEach var="place" items="${places}">
							<c:set var="count" value="${count + 1}" scope="page"/>
							<option value="${count}">${place}</option>
						</c:forEach>
					</c:if>
				</select>
			</c:otherwise>
		</c:choose>
		<br />
		<br />
		
		</form>
	</div>
	<div >
		<button onClick="document.getElementById('accusesuggestForm').submit();return false;">${type}</button>
		<button onClick="location.href='gamescreen';return false;">Return to Game</button>
	</div>
</body>
<footer class="footer">J-Cubed, Inc. 2014</footer>
</html>