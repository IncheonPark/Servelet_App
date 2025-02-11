<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//DepartmentDTO dto = (DepartmentDTO)request.getAttribute("dto");
%>

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
			
			<%@ include file="../template/nav.jsp" %>
			
		</div>
		<div class="right contents_right">
		
			<h1>Update Form</h1>
	
			<form action="./update.do" method="post">
			
				<fieldset>
					<legend>부서 이름</legend>
					<input type="text" name="department_name" value="${request.dto.department_name}">

				</fieldset>
				<fieldset>
					<legend>매니저 아이디</legend>
					<input type="text" name="manager_id" value="${dto.manager_id}">

				</fieldset>
				<fieldset>
					<legend>지역 아이디</legend>
					<input type="text" name="location_id" value="${dto.location_id}">

				</fieldset>
				<fieldset>
					<input type="hidden" name="department_id" value="${dto.department_id}">

				</fieldset>
			
				<fieldset>
					<button type="submit">수정하기</button>
				</fieldset>
				
				
			</form>
		
		</div>
	</section>

	<%@ include file="../template/footer.jsp"%>
	


</body>
</html>

