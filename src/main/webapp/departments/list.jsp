<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
    
<!-- 자바 코드는 % 사용-->    
<% 
	// '스크립틀릿'이라 부른다.
	DepartmentDAO departmentDAO = new DepartmentDAO();
	List<DepartmentDTO> list = departmentDAO.getList();
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
	<%@ include file="/template/header.jsp"%>

	<section class="contents wrap_left">
		<div class="left contents_left">
			
			<%@ include file="/template/nav.jsp" %>
			
		</div>
		<div class="right contents_right">
		
			<h3><a href="/">홈으로 가기</a></h3>
			<div>
				<a href="./add.jsp">부서 등록</a>
			</div>
			
			<h1>Department List</h1>
			
			<div class="contents_right_list">
				<table class="table_shadow">
					<thead>
						<tr>
							<th>Dept_id</th> <th>Dept_name</th>
						</tr>
					</thead>
					
					<tbody>
						<% for (int i=0; i < list.size(); i++) { %>
						<tr>
							<td>
								<%=	list.get(i).getDepartment_id() %>
							</td>
							<td>	
								<a href="./detail.jsp?department_id=<%= list.get(i).getDepartment_id() %>">
								<%= list.get(i).getDepartment_name() %></a>
							</td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</div>
		</div>
	</section>

	<%@ include file="/template/footer.jsp"%>
	


</body>
</html>




