<%@page import="com.winter.app.locations.LocationDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.winter.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	LocationDAO dao = new LocationDAO();
	List<LocationDTO> list = dao.getList();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	table {
		width: 40%;
		margin: 0 auto;
		border: 1px solid red;
	}
	
	table th, table td {
		border: 1px solid gold;
		height: 50px;
	}
</style>

</head>
<body>

	<h3><a href="/">홈으로 가기</a></h3>
	<div>
		<a href="./add.jsp">지역 등록</a>
	</div>

	<h1>Location List</h1>
	
	<table>
		<thead>
			<tr>
				<th>Location_id</th>
				<th>City</th>
			</tr>
		</thead>
		
		<tbody>
			<% for (int i = 0; i < list.size(); i++) { %>
			<tr>
				<td><%= list.get(i).getLocation_id() %></td>
				<td><a href="./detail.jsp?location_id=<%= list.get(i).getLocation_id() %>">
				<%= list.get(i).getCity() %></a></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	
	

</body>
</html>


