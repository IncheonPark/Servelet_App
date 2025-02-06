<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	DepartmentDAO dao = new DepartmentDAO();
	DepartmentDTO dto = new DepartmentDTO();
	String parameter = request.getParameter("department_id");
	
	dto.setDepartment_id(Long.parseLong(parameter));
	dto = dao.getDetail(dto);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3><a href="/">홈으로 가기</a></h3>
	
	<h1>Dept Detail Page</h1>
	
	<% if(dto != null) { %>
		<h3><%= dto.getDepartment_id() %></h3>
		<h3><%= dto.getDepartment_name() %></h3>
		<h3><%= dto.getManager_id() %></h3>
		
		<a href="./deleteProcess.jsp?department_id=<%= dto.getDepartment_id() %>">부서 삭제</a>
		<a href="./update.jsp?department_id=<%= dto.getDepartment_id() %>">부서 수정</a>
		
	<% } else { %>
		<h3>없는 부서입니다.</h3>
		
	<% } %>
	

</body>
</html>