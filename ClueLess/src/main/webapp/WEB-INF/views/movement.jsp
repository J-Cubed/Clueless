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
	<h2>Move</h2>
	<div>
		<form method="post" action="" id="locationForm">
		Location:<br />
		<select name="location">
			<c:if test="${not empty options}">
				<c:set var="count" value="0" scope="page" />
				<c:forEach var="option" items="${options}">
					<c:set var="count" value="${count + 1}" scope="page"/>
					<option value="${count}">${option}</option>
				</c:forEach>
			</c:if>
		</select>
		</form>
	</div>
	<div>
		<button onClick="document.getElementById('locationForm').submit();return false;">Confirm</button>
		<button onClick="location.href='gamescreen';return false;">Cancel</button>
	</div>
</body>
<footer class="footer">J-Cubed, Inc. 2014</footer>
</html>