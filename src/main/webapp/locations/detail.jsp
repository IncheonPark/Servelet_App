<%@page import="com.winter.app.locations.LocationDTO"%>
<%@page import="com.winter.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	LocationDAO dao = new LocationDAO();
	LocationDTO dto = new LocationDTO();
	String parameter = request.getParameter("location_id");
	
	dto.setLocation_id(Long.parseLong(parameter));
	dto = dao.getDetail(dto);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Location Detail Page</title>
</head>
<body>
	
	<h3><a href="/">홈으로 가기</a></h3>
	
	<h1>Location Detail Page</h1>
	
	<% if (dto != null) { %>
		<h3><%= dto.getLocation_id() %></h3>
		<h3><%= dto.getCity() %></h3>
		<h3><%= dto.getStreet_address() %></h3>
		
	<% } else { %>
		<h3>없는 지역입니다.</h3>
	
	<% } %>
	

</body>
</html>