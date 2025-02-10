<%@page import="com.winter.app.locations.LocationDAO"%>
<%@page import="com.winter.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String address = request.getParameter("street_address");
	String post = request.getParameter("postal_code");
	String city = request.getParameter("city");
	String province = request.getParameter("state_province");
	String c_id = request.getParameter("country_id");
	String l_id = request.getParameter("location_id");
	
	LocationDTO dto = new LocationDTO();
	dto.setStreet_address(address);
	dto.setPostal_code(post);
	dto.setCity(city);
	dto.setState_province(province);
	dto.setCountry_id(c_id);
	dto.setLocation_id(Long.parseLong(l_id));
	
	LocationDAO dao = new LocationDAO();
	int result = dao.update(dto);
	
	String reply = "지역 정보 수정 실패";
	
	if (result > 0 ) {
		reply = "지역 정보 수정 성공";
	}
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>지역 업데이트 진행 페이지</h1>
	
	<a href="/">HOME</a>
	<a href="./list.jsp">LIST</a>
	
	<h3> <%= reply %> </h3>
	
	
	
</body>
</html>