<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CoderBy</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Oswald&display=swap"
	rel="stylesheet">
<style>
body, html, form {
	width: 100%;
	height: 100%;
	padding: 0;
	margin: 0;
	font-family: Oswald;
}

ul {
	list-style: none;
}

iframe {
	width: 100%;
	height: 100%;
}

#container {
	width: 100%;
	height: 100%;
}

#menu {
	background-color: #8b6332;
	float: left;
	height: 100%;
	width: 20%;
	position: absolute;
	z-index: 1;
	text-align: right;
}

#content {
	float: right;
	height: 100%;
	width: 80%;
}

#title {
	font-size: 80pt;
}

#titleDiv {
	position: absolute;
	z-index: 2;
}

a:link {
	color: black;
	text-decoration: none;
}

a:visited {
	color: black;
	text-decoration: none;
}
</style>
</head>
<body>
	<div id="container">
		<div id="menu">
			<div id="titleDiv">
				<a href="./main" id="title" target="if"> BMS </a> <label for="title"
					style="font-size: 15pt;"><i>novemberBREAD</i></label>
			</div>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br>
			<ul style="font-size:25pt;">
				<li><a href="./introduce" target="if">INTRODUCE</a></li>
				<li><a href="./map" target="if">DIRECTIONS</a></li>
				<li><a href="./book" target="if">RESERVATION</a></li>
				<li><a href="./lookbook" target="if" style="color:red;">LOOK UP</a></li>
			</ul>

		</div>
		<div id="content">
			<iframe id="if" name="if" src="./main"> </iframe>
		</div>


	</div>
</body>
</html>
