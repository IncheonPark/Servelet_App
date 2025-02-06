<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("department_id");

	DepartmentDTO dto = new DepartmentDTO();
	dto.setDepartment_id(Long.parseLong(id));
	
	DepartmentDAO dao = new DepartmentDAO();
	dto = dao.getDetail(dto);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Form</h1>
	
	<form action="./updateProcess.jsp" method="post">
		<input type="text" name="department_name" value="<%= dto.getDepartment_name() %>">
		<input type="text" name="manager_id" value="<%= dto.getManager_id() %>">
		<input type="text" name="location_id" value="<%= dto.getLocation_id() %>">
		<input type="hidden" name="department_id" value="<%= dto.getDepartment_id() %>">
		
		<button type="submit">수정하기</button>
		
	</form>

</body>
</html>