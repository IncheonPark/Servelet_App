<%@page import="com.winter.app.locations.LocationDAO"%>
<%@page import="com.winter.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String l_id = request.getParameter("location_id");

	LocationDTO dto = new LocationDTO();
	dto.setLocation_id(Long.parseLong(l_id));
	
	LocationDAO dao = new LocationDAO();
	dto = dao.getDetail(dto);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	
	<h1>지역 수정 페이지</h1>
	
	<form action="./updateProcess.jsp" method="post">
		<input type="text" name="street_address" value="<%= dto.getStreet_address() %>" >
		<input type="text" name="postal_code" value="<%= dto.getPostal_code() %>" >
		<input type="text" name="city" value="<%= dto.getCity() %>" >
		<input type="text" name="state_province" value="<%= dto.getState_province() %>" >
		<input type="text" name="country_id" value="<%= dto.getCountry_id() %>" >
		<input type="hidden" name="location_id" value="<%= dto.getLocation_id() %>" >
		
		<button type="submit">수정하기</button>
	</form>






</body>
</html>