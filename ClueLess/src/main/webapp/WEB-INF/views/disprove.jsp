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
	<h2>Disprove Screen</h2>
	<div style="text-align:left;">
		<form action="" method="get">
		Card:<br />
		<select name="card">
			<option value="">- Card -</option>
			<option value="card1">Card 1</option>
			<option value="card2">Card 2</option>
			<option value="card3">Card 3</option>
		</select>
		</form><br />
		<br />
		<button onClick="location.href='gamescreen';return false;">Disprove</button>
		<button onClick="location.href='gamescreen';return false;">Cannot Disprove</button>
	</div>
</body>
<footer class="footer">J-Cubed, Inc. 2014</footer>
</html>