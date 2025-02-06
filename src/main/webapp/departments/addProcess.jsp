<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	DepartmentDAO dao = new DepartmentDAO();
	DepartmentDTO dto = new DepartmentDTO();
	
	String name = request.getParameter("department_name");
	String manager_id = request.getParameter("manager_id");
	String location_id = request.getParameter("location_id");
	
	dto.setDepartment_name(name);
	dto.setManager_id(Long.parseLong(manager_id));
	dto.setLocation_id(Long.parseLong(location_id));
	
	int result = dao.add(dto);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>

<body>
	<h1>부서 등록 진행 페이지</h1>
	
	<a href="/">HOME</a>
	<a href="./list.jsp">LIST</a>
	
	<% if (result > 0) { %>
		<h3>부서 등록 성공</h3>
		
	<% } else { %>
		<h3>부서 등록 실패</h3>
		
	<% } %>
	
	<a href="/">HOME</a>
	<a href="./list.jsp">목록으로</a>
	

</body>
</html>