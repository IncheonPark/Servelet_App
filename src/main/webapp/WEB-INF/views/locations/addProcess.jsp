<%@page import="com.winter.app.locations.LocationDTO"%>
<%@page import="com.winter.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	LocationDAO dao = new LocationDAO();
	LocationDTO dto = new LocationDTO();
	
	dto.setCity(request.getParameter("city"));
	dto.setStreet_address(request.getParameter("street_address"));
	dto.setPostal_code(request.getParameter("postal_code"));
	dto.setState_province(request.getParameter("state_province"));
	dto.setCountry_id(request.getParameter("country_id"));
	
	int result = dao.add(dto);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>지역 등록 진행 페이지</h1>
	
	<% if (result > 0) { %>
		<h3>지역 등록 성공</h3>
		
	<% } else { %>
		<h3>지역 등록 실패</h3>
		
	<% } %>
	
	<a href="/">HOME</a>
	<a href="./list.jsp">목록으로</a>

</body>
</html>