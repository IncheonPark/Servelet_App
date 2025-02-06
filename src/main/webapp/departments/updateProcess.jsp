<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = request.getParameter("department_name");
	String m_id = request.getParameter("manager_id");
	String l_id = request.getParameter("location_id");
	String d_id = request.getParameter("department_id");
	
	DepartmentDTO dto = new DepartmentDTO();
	dto.setDepartment_name(name);
	dto.setManager_id(Long.parseLong(m_id));
	dto.setLocation_id(Long.parseLong(l_id));
	dto.setDepartment_id(Long.parseLong(d_id));
	
	DepartmentDAO dao = new DepartmentDAO();
	int result = dao.update(dto);
	
	String r = "부서 수정 실패";
	
	if (result > 0 ) {
		r = "부서 수정 성공";
	}
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 수정 진행 페이지</h1>
	
	<a href="/">HOME</a>
	<a href="./list.jsp">LIST</a>
	
	<h3><%= r %></h3>



</body>
</html>