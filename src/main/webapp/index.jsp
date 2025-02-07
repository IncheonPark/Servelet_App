<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/reset.css">
<style>

	* {
		margin: 0px;
		padding: 0px;
	}

	div {
		display: inline-block;
		margin: 0px;
		padding: 0px;
		
	}

	.leftDiv {
		border: 3px solid gold;
		width:50px; 
	}

	.rightDiv {
		border: 3px solid silver;
		width:300px;
	}
	
	.hd1 {
		height: 50px;
	}

	.md1 {
		height: 300px;
	}

	.fd1 {
		height: 50px;
	}
	
</style>
</head>
<body>
	<header>
		<div class="leftDiv hd1">
			<img src="/resources/images/sco2.jpg" width="35px" height="35px">
		</div>
		<div class="rightDiv hd1"></div>
	</header>

	<main>
		<div class="leftDiv md1"></div>
		<div class="rightDiv md1"></div>
	</main>

	<footer>
		<div class="leftDiv fd1"></div>
		<div class="rightDiv fd1"></div>
	</footer>
		
	



</body>
</html>