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
	<h2>Main Menu</h2>
	<ul class="mainmenu-container">
		<li class="button"><a class="buttonlink" href="" onClick="location.href='creategame';return false;">Create Game</a></li>
		<li class="button"><a class="buttonlink" href="" onClick="location.href='joingame';return false;">Join Game</a></li>
		<li class="button"><a class="buttonlink" href="" onClick="location.href='gamerules';return false;">Game Rules</a></li>
	</ul>
</body>
</html>