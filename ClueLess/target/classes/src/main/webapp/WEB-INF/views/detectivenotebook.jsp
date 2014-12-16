<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Menu</title>
<style type="text/css">
	.button_small { width:240px;height:60px;line-height:60px;background:#4f81bd;border:solid #385d8a 1px;border-radius:10px;color:#0000ff;float:left;margin:20px; }
	.buttonlink { color:#fff;font-size:24px; }
	.floatnone { float:none; }
</style>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
</head>
<body>	
	<h2>Detective Notebook</h2>
	<form id="frmDetNote" action="" method="post">
	<div class="notebook-container" style="float:left;width:60%;">
		<div class="notebook-item">
			<span style="font-weight:bold;">Suspects</span><br />
			<input type="checkbox" name="s" value="0" <c:if test="${s[0]}">checked</c:if>> Colonel Mustard<br />
			<input type="checkbox" name="s" value="1" <c:if test="${s[1]}">checked</c:if>> Miss Scarlet<br />
			<input type="checkbox" name="s" value="2" <c:if test="${s[2]}">checked</c:if>> Professor Plum<br />
			<input type="checkbox" name="s" value="3" <c:if test="${s[3]}">checked</c:if>> Mr. Green<br />
			<input type="checkbox" name="s" value="4" <c:if test="${s[4]}">checked</c:if>> Mrs. White<br />
			<input type="checkbox" name="s" value="5" <c:if test="${s[5]}">checked</c:if>> Mrs. Peacock<br />
			<br />
			<span style="font-weight:bold;">Rooms</span><br />
			<input type="checkbox" name="r" value="0" <c:if test="${r[0]}">checked</c:if>> Study <br />
			<input type="checkbox" name="r" value="1" <c:if test="${r[1]}">checked</c:if>> Hall <br />
			<input type="checkbox" name="r" value="2" <c:if test="${r[2]}">checked</c:if>> Lounge <br />
			<input type="checkbox" name="r" value="3" <c:if test="${r[3]}">checked</c:if>> Library <br />
			<input type="checkbox" name="r" value="4" <c:if test="${r[4]}">checked</c:if>> Billiard Room <br />
			<input type="checkbox" name="r" value="5" <c:if test="${r[5]}">checked</c:if>> Dining Room <br />
			<input type="checkbox" name="r" value="6" <c:if test="${r[6]}">checked</c:if>> Conservatory <br />
			<input type="checkbox" name="r" value="7" <c:if test="${r[7]}">checked</c:if>> Ballroom <br />
			<input type="checkbox" name="r" value="8" <c:if test="${r[8]}">checked</c:if>> Kitchen <br />
		</div>
		<div class="notebook-item">
			<span style="font-weight:bold;">Weapons</span><br />
			<input type="checkbox" name="w" value="0" <c:if test="${w[0]}">checked</c:if>> Rope <br />
			<input type="checkbox" name="w" value="1" <c:if test="${w[1]}">checked</c:if>> Lead Pipe <br />
			<input type="checkbox" name="w" value="2" <c:if test="${w[2]}">checked</c:if>> Knife <br />
			<input type="checkbox" name="w" value="3" <c:if test="${w[3]}">checked</c:if>> Wrench <br />
			<input type="checkbox" name="w" value="4" <c:if test="${w[4]}">checked</c:if>> Candlestick <br />
			<input type="checkbox" name="w" value="5" <c:if test="${w[5]}">checked</c:if>> Revolver <br />
			<br />
			Notes:<br/>
			<textarea name="notes" rows="13" cols="25">
				${notes}
			</textarea><br />
			<input type="hidden" id="referrer" name="referrer" value="${referrer}">
		</div>
	</div>
	<div style="float:right;width:40%;">
		<div class="button_small floatnone"><a class="buttonlink" href="" onClick="document.getElementById('frmDetNote').submit();return false;">Save</a></div>
		<div class="button_small floatnone"><a class="buttonlink" href="" onClick="location.href=document.getElementById('referrer').value;return false;">Back</a></div>
		<div class="button_small floatnone"><a class="buttonlink" href="" onClick="location.href='gamescreen';return false;">Return to Game</a></div>
	</div>
	</form>
</body>
</html>