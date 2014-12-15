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
	<img src="resources/images/Header_Logo-small.jpg">	
	<h2>Confidential Case File</h2>
	<h3>Game Over</h3>
	<h4>The murder remains unsolved.</h4>
	<div>
		<c:if test="${not empty casefile}">
			<c:forEach var="card" items="${casefile}">
				<div>${card}</div>
			</c:forEach>
		</c:if>
	</div>
	<button onClick="location.href='mainmenu';return false;">Play Again!</button>
</body>
<footer class="footer center">J-Cubed, Inc. 2014</footer>
</html>