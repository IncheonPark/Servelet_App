<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/layout.css">

</head>
<body>
	<!-- Sementic tag -->
	<!-- JSP 파일 불러오기 : header.jsp -->
	<%@ include file="../template/header.jsp"%>

	<section class="contents wrap_left">
		<div class="left contents_left">
			<!-- JSP 파일 불러오기 : nav.jsp -->
			<%@ include file="../template/nav.jsp" %>
			
		</div>
		<div class="right contents_right">
			
			<div>
				<h3>ID : ${sessionScope.user.employee_id }</h3>
				<h3>FirstName : ${sessionScope.user.firstName }</h3>
				<h3>LastName : ${requestScope.user.last_name}</h3>
			</div>
			
			<div>
				<a href="./update.do">정보 수정</a>
			</div>
		
		</div>
	</section>
	<!-- JSP 파일 불러오기 : footer.jsp -->
	<%@ include file="../template/footer.jsp"%>
	


</body>
</html>