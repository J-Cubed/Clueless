<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/resources/css/gameboard.css'/>" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="resources/js/scripts.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Menu</title>
<style type="text/css">
	.gameblock { float:left;width:100px; }
	.label { clear:both;float:left;text-align:left;font-weight:bold; }
	.clearfix {clear:both; }
	.floatleft { float:left; }
	.floatright { float:right; }
	.floatnone { float:none; }
</style>
</head>
<body>	
	<h2>Game Screen</h2>
	
	<!-- 	<div style="float:right;width:40%;"> -->
	<div class="top">
		<button id="move" class="nav-button">Move</button>
		
		<button id="suggest" class="nav-button">Suggest</button>
		
		<button id="accuse" class="nav-button">Accuse</button>
		
		<button id="end" class="nav-button">End Turn</button>
		
		<button class="nav-button" onClick="popUp('gamerules')">Help</button>
		
		<button class="nav-button" onClick="location.href='mainmenu';return false;">Exit</button>
		
		<c:if test="${isAdmin}">
			<c:if test="${!isGameActive}">
				<button id="start" class="nav-button">Start Game</button>
			</c:if>
		</c:if>
	</div>
	<div class="wrapper">
		<aside class="aside aside-right">
			<h3>Detective Notebook</h3>
			<form id="frmDetNote" action="" method="post">
			<div class="notebook-container">
				<div class="notebook-item">
					<span style="font-weight:bold;">Suspects</span><br />
					<input type="checkbox" name="s" value="0" <c:if test="${s[0]}">checked</c:if>> Col. Mustard<br />
					<input type="checkbox" name="s" value="1" <c:if test="${s[1]}">checked</c:if>> Ms. Scarlet<br />
					<input type="checkbox" name="s" value="2" <c:if test="${s[2]}">checked</c:if>> Prof. Plum<br />
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
					<br />
					<span style="font-weight:bold;">Weapons</span><br />
					<input type="checkbox" name="w" value="0" <c:if test="${w[0]}">checked</c:if>> Rope <br />
					<input type="checkbox" name="w" value="1" <c:if test="${w[1]}">checked</c:if>> Lead Pipe <br />
					<input type="checkbox" name="w" value="2" <c:if test="${w[2]}">checked</c:if>> Knife <br />
					<input type="checkbox" name="w" value="3" <c:if test="${w[3]}">checked</c:if>> Wrench <br />
					<input type="checkbox" name="w" value="4" <c:if test="${w[4]}">checked</c:if>> Candlestick <br />
					<input type="checkbox" name="w" value="5" <c:if test="${w[5]}">checked</c:if>> Revolver <br />
					<br />
					Notes:<br/>
					<textarea name="notes" rows="6" cols="14">
						${notes}
					</textarea><br />
					<input type="hidden" id="referrer" name="referrer" value="${referrer}">
				</div>
			</div>
			</form>
		</aside>
		<aside class="aside aside-left">
			<h3>Game Board</h3>
			<div class="gameboard">
<%-- 				<c:forEach var="loc" items="${curLocations}">
				  <div id="${loc.key}" class="${loc.value} abs"></div>
				</c:forEach> --%>
				<c:forEach var="loc" items="${curLocations}">
					<ul id="${loc.key}" class="abs">
						<li class="${loc.value}"/>
					</ul>
				</c:forEach>
<!-- 				<ul class="green abs" id="study"/>
				<ul class="scarlet abs" id="study"/>
				<div class="scarlet abs"/>
				<div class="scarlet abs"/>
				<div class="scarlet abs"/> -->

			</div>
		</aside>
	</div>
	<div class="wrapper">
		<aside class="aside">
		<h3>Cards</h3>
		<div class="cards">
			<c:if test="${not empty cards}">
				<ul>
					<c:forEach var="card" items="${cards}">
						<li>${card}</li>
					</c:forEach>
				</ul>
			</c:if>
		</div>
		</aside>
		<aside class="aside">
			<h3>Status</h3>
			<c:set var="scount" value="0"/>
			<div class="status" id="status">
				<ul id="statusUpdate">
					<c:if test="${not empty status}">
						<c:forEach var="statusValue" items="${status}">
							<c:set var="scount" value="${scount + 1}"/>
							<li>${statusValue}</li>
						</c:forEach>
					</c:if>	
				</ul>
			</div>
		</aside>
		<aside class="aside">
			<h3>Move History</h3>
			<c:set var="mcount" value="0"/>
			<div class="movehistory" id="moveHistory">
				<ul id="moveHistoryUpdate">
					<c:if test="${not empty moveHistory}">	
						<c:forEach var="moveValue" items="${moveHistory}">
							<c:set var="mcount" value="${mcount + 1}"/>
							<li>${moveValue}</li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
		</aside>
	</div>
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript">
	var isAdmin = "${isAdmin}";
	var isGamePlayable = "${isGamePlayable}";
	var isGameActive = "${isGameActive}";
	var isMyTurn = "${isMyTurn}";
	var allowSuggest = "${allowSuggest}";
	var allowMove = "${allowMove}";
	var scount = ${scount};
	var mcount = ${mcount};
	
	updateControls();
	$( "#frmDetNote" ).change(function() {
		$.post('detectivenotebook', $('#frmDetNote').serialize())
		
		return false;
	});	
	
	(function poll() {
		   setTimeout(function() {
			$.ajax({
				type: "GET",
				url: 'ajaxStatus?scount=' + scount + '&mcount=' + mcount,
				dataType: "xml",
				success: function(xml){
					processStatus(xml);
					processLocations(xml);
				},
				error: function() {
					alert("Game unexpectedly terminated.");
				},
				complete: poll
			});
		   }, 5000);
	})();
	
	function saveNotebook() {
		
	}
	function updateControls() {
		if (isAdmin === "true" && isGamePlayable === "true" && isGameActive !== "true") {
			activateButton("start");
			enableStartButton("start");
		} else {
			deactivateButton("start");
			disableLink("start");
		}
		
		if (isGameActive !== "true") {
			deactivateButton("notebook");
			disableLink("notebook");
		} else {
			activateButton("notebook");
			enableLink("notebook","detectivenotebook");
		}
		
		if (isGameActive !== "true" || isMyTurn !== "true") {
			deactivateButton("suggest");
			deactivateButton("accuse");
			deactivateButton("move");
			deactivateButton("end");
			
			disableLink("suggest");
			disableLink("accuse");
			disableLink("move");
			disableLink("end");
		} else {
			activateButton("accuse");
			activateButton("end");
			
			enableLink("accuse","accusesuggest?type=Accuse");
			enableLink("end","gamescreen?type=endTurn");
			
			if (allowSuggest === "true") {
				activateButton("suggest");
				enableLink("suggest","accusesuggest?type=Suggest");
			} else {
				deactivateButton("suggest");
				disableLink("suggest");
			}
			
			if (allowMove === "true") {
				activateButton("move");
				enableLink("move","movement");
			} else {
				deactivateButton("move");
				disableLink("move");
			}
		}
	}
	function processStatus(xml) {
		isGamePlayable = $(xml).find('isGamePlayable').text().toString();
		isGameActive = $(xml).find('isGameActive').text().toString();
		isMyTurn = $(xml).find('isMyTurn').text().toString();
		allowSuggest = $(xml).find('allowSuggest').text().toString();
		allowMove = $(xml).find('allowMove').text().toString();
		
		$(xml).find("statusUpdate").each(function() {
			scount++;
			$( "#statusUpdate" ).append( "<li>" + $(this).text().toString() + "</li>" );
		});
		$('#status').scrollTop($('#status')[0].scrollHeight);
		
		$(xml).find("moveHistoryUpdate").each(function() {
			mcount++;
			$( "#moveHistoryUpdate" ).append( "<li>" + $(this).text().toString() + "</li>" );
		});
		$('#moveHistory').scrollTop($('#moveHistory')[0].scrollHeight);
		
		updateControls();
	}
	function processLocations(xml) {
		$(xml).find("entry").each(function() {
			var key = $(this).find('key').text().toString();
			var value = $(this).find('value').text().toString();
			
			if (!value) {
				$( "#" + key ).removeClass();
				$( "#" + key ).addClass( "abs" );
			} else {
				if (!$( "#" + key ).hasClass( value )) {
					$( "#" + key ).removeClass();
					$( "#" + key ).addClass( value + " abs" );
				}
			}
		});
	}
	function activateButton(id) {
		$( "#" + id ).removeClass("button-disabled");
	}
	function deactivateButton(id) {
		$( "#" + id ).addClass("button-disabled");
	}
	function enableLink(id,loc) {
		$( "#" + id ).off( "click" );
		$( "#" + id ).on( "click", function() {
			location.href=loc;
			return false;
		});
	}
	function disableLink(id) {
		$( "#" + id ).off( "click" );
		$( "#" + id ).on( "click", function() {
			return false;
		});
	}
	function enableStartButton(id) {
		$( "#" + id ).off( "click" );
		$( "#" + id ).on( "click", function() {
			var  formData = "startGame=true&scount=" + scount + "&mcount=" + mcount;
			 
			$.ajax({
			    url : "ajaxStatus",
			    type: "POST",
			    dataType: "xml",
			    data : formData,
			    success: function(xml) {
			        processStatus(xml);
			        processLocations(xml);
			        removeStartButton();
			    },
			    error: function () {
			    	alert("Game unexpectedly terminated.");
			    }
			});
			
			return false;
		});
	}
	function removeStartButton(id) {
		$( "#" + id).remove();
	}

	(function(w, d, s) {
		function go(){
			var js, fjs = d.getElementsByTagName(s)[0], load = function(url, id) {
				if (d.getElementById(id)) {return;}
				js = d.createElement(s); js.src = url; js.id = id;
				fjs.parentNode.insertBefore(js, fjs);
			};
			$('#status').scrollTop($('#status')[0].scrollHeight);
			$('#moveHistory').scrollTop($('#moveHistory')[0].scrollHeight);
		}
		if (w.addEventListener) { w.addEventListener("load", go, false); }
		else if (w.attachEvent) { w.attachEvent("onload", go); }
		else { window.onload = go; }
	}(window, document, 'script'));
	</script>
</body>
</html>