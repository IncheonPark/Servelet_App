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

<style type="text/css">

	table {
		width: 40%;
		margin: 0 auto;
		border: 1px solid red;
		border-collapse: collapse;
	}
	
	table td, table th {
		border: 1px solid gold;
		height: 50px;
	}
	
</style>

</head>
<body>
	
	<h3><a href="/">홈으로 가기</a></h3>
	<div>
		<a href="./add.jsp">부서 등록</a>
	</div>
	
	<h1>Department List</h1>
	
	<table>
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
	
	
	

</body>
</html>




