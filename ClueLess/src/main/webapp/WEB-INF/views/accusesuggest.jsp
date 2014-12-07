<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Menu</title>
</head>
<body>	
	<h2>${type} Screen</h2>
	<div style="float:left;width:60%;text-align:left;">
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
		<div class="button_small"><a class="buttonlink" href="" onClick="document.getElementById('accusesuggestForm').submit();return false;">${type}</a></div>
		</form>
	</div>
	<div style="float:right;width:40%;">
		<div class="button_small"><a class="buttonlink" href="" onClick="location.href='detectivenotebook';return false;">Detective Notebook</a></div>
		<div class="button_small"><a class="buttonlink" href="" onClick="location.href='gamescreen';return false;">Return to Game</a></div>
	</div>
</body>
</html>