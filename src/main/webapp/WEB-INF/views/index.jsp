<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/layout.css">
<%@ include file="/WEB-INF/views/template/common.jsp" %>

</head>
<body>
	<!-- Sementic tag -->
	<!-- JSP 파일 불러오기 : header.jsp -->
	<%@ include file="/WEB-INF/views/template/header.jsp"%>

	<section class="contents wrap_left">
		<div class="left contents_left">
			
			<%@ include file="./template/nav.jsp" %>
			
		</div>
		<div class="right contents_right"></div>
	</section>

	<%@ include file="./template/footer.jsp"%>
	


</body>
</html>