<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("department_id");
	DepartmentDTO dto = new DepartmentDTO();
	dto.setDepartment_id(Long.parseLong(id));
	
	DepartmentDAO dao = new DepartmentDAO();
	int result = dao.delete(dto);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>부서 삭제 진행 페이지</h1>
	
	<a href="/">HOME</a>
	<a href="./list.jsp">LIST</a>
	
	<% if (result > 0) { %>
		<h3>부서 삭제 성공</h3>
	
	<% } else { %>
		<h3>부서 삭제 실패</h3>	
	
	<% } %>
	
</body>
</html>