<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="resources/js/scripts.js"></script>
<!--
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">

-->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Menu</title>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
</head>
<body>	
	<img src="resources/images/Header_Logo-small.jpg"  style="border:0;">
	<h2>Main Menu</h2>
	<div class="mainmenu-container">
		<button onClick="location.href='creategame';return false;">Create Game</button>
		<button onClick="location.href='joingame';return false;">Join Game</button>
		<button onClick="popUp('gamerules')">Help</button>
<!-- 		<button onClick="location.href='gamerules';return false;">Help</button> -->
	</div>
</body>
<footer class="footer">J-Cubed, Inc. 2014</footer>
</html>