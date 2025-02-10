<%@page import="com.winter.app.locations.LocationDTO"%>
<%@page import="com.winter.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	LocationDAO dao = new LocationDAO();
	LocationDTO dto = new LocationDTO();	
	String id = request.getParameter("location_id");
	
	dto.setLocation_id(Long.parseLong(id));
	int result = dao.delete(dto);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	<h1>지역 삭제 진행 페이지</h1>
	
	<a href="/">HOME</a>
	<a href="./list.jsp">LIST</a>
	
	<% if (result > 0) { %>
		<h3>지역 삭제 성공</h3>
	
	<% } else { %>
		<h3>지역 삭제 실패</h3>
	
	<% } %>

</body>
</html>