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
	<h2>Join Game</h2>
	<div>
		<form id="joinForm" method="post" action="">
		Game Name: <input type="text" name="name" value="${name}">
		Password: <input type="password" name="password" value="${password}"><br /><br />
		<input id="type" type="hidden" name="type"  value="">
		</form>
		${errorMessage}
	</div>
	<button class="join" onClick="document.getElementById('type').value='private';document.getElementById('joinForm').submit();return false;">Join Private Game</button>
	<button onClick="location.href='mainmenu';return false;">Main Menu</button>
	<button class="join" onClick="document.getElementById('type').value='public';document.getElementById('joinForm').submit();return false;">Join Public Game</button>
</body>
<footer class="footer">J-Cubed, Inc. 2014</footer>
</html>