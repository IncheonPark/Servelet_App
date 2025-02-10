<%@page import="com.winter.app.locations.LocationDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.winter.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<LocationDTO> list = (List<LocationDTO>)request.getAttribute("list");
	for(LocationDTO dto : list){
		System.out.println(dto.getStreet_address());
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/layout.css">
<link rel="stylesheet" href="/resources/css/list_table.css">

</head>
<body>
	<!-- Sementic tag -->
	<!-- JSP 파일 불러오기 : header.jsp -->
	<%@ include file="../template/header.jsp"%>

	<section class="contents wrap_left">
		<div class="left contents_left">
			
			<%@ include file="../template/nav.jsp" %>
			
		</div>
		<div class="right contents_right">
		
			<h3><a href="/index.do">홈으로 가기</a></h3>
			<div>
				<a href="./add.do">지역 등록</a>
			</div>
			
			<h1>Location List</h1>
			
			<div class="contents_right_list">
				<table class="table_shadow">
					<thead>
						<tr>
							<th>Location_id</th> <th>Street_address</th>
						</tr>
					</thead>
					
					<tbody>
						<% for (int i=0; i < list.size(); i++) { %>
						<tr>
							<td>
								<%=	list.get(i).getLocation_id() %>
							</td>
							<td>	
								<a href="./detail.do?location_id=<%= list.get(i).getLocation_id() %>">
								<%= list.get(i).getStreet_address() %></a>
							</td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</div>
		</div>
	</section>

	<%@ include file="../template/footer.jsp"%>
	


</body>
</html>


