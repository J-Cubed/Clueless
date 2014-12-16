<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='resources/css/main.css'/>" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Menu</title>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
</head>

<body style="text-align:left">
	<img class="center" src="resources/images/Header_Logo-small.jpg"  style="border:0;">	
	<h2>Game Rules</h2>
	<h3>"Just like the real game... but less!"</h3>
	<p>
		This game is a simplified version of the popular board game, Clue. The main simplification is in the navigation of the game board. In Clue-Less there are the same nine rooms, six weapons, and six people as in the board game. The rules are pretty much the same except for moving from room to room.
		<ul name="main-bullet">
			<li>The rooms are laid out in a 3x3 grid with a hallway separating each pair of adjacent rooms.</li>
			<li>Each hallway only holds one person. If someone is currently in a hallway, you may not move there.</li>
			<li>When it is your turn, you don't need to roll a die.</li>
			<li>Your options of moving are limited to the following:</li>
			<ul name="second-bullet">
				<li>If you are in a room, you may do one of the following:</li>
				<ul name="third-bullet">
					<li>Move through one of the doors to the hallway (if it is not blocked).
					<li>Take a secret passage to a diagonally opposite room (if there is one) and make a suggestion.</li>
					<li>If you were moved to the room by another player making a suggestion, you may, if you wish, stay in that room and make a suggestion. Otherwise you may move through a doorway or take a secret passage as described above.</li>
				</ul>
				<li>If you are in a hallway, you must do the following:</li>
				<ul name="third-bullet">
					<li>Move to one of the two rooms accessible from that hallway and make a suggestion.</li>
				</ul>
			</ul>
			<li>If all of the exits are blocked (i.e., there are people in all of the hallways) and you are not in one of the corner rooms (with a secret passage), and you weren't moved to the room by another player making a suggestion, you lose your turn (except for maybe making an accusation).</li>
			<li>Your first move must be to the hallway that is adjacent to your home square.</li>
			<li>Whenever a suggestion is made, the room must be the room the one making the suggestion is currently in. The suspect in the suggestion is moved to the room in the suggestion.</li>
			<li>You may make an accusation at any time during your turn.</li>
			<li>You don't need to show weapons on the board, since they really don't do anything. But you should show where each of the characters is.</li>
			<li>The rules for the <a href="http://www.hasbro.com/common/instruct/clueins.pdf">Classic Game</a>.</li>
		</ul>
	</p>


<!-- 	<button class="center" onClick="location.href='mainmenu';return false;">Main Menu</button> -->
<!-- 	<button class="center" onClick="location.href='gamescreen';return false;">Cancel</button> -->
</body>
<footer class="footer">J-Cubed, Inc. 2014</footer>
</html>