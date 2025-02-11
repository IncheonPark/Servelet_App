<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
				<a href="./add.do">부서 등록</a>
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
						<c:forEach items="${list }" var="dto" varStatus="st"> <!-- items는 list의 갯수만큼 반복한다 -->
							<tr>
								<td>
									${pageScope.dto.department_id }									
									<%-- forEach에서 items 사용 시 쓸 수 있는 여러 기능 
									<h4>현재 아이템 : ${st.current }</h4>
									<h4>인덱스 번호 : ${st.index }</h4>
									<h4>카운트 : ${st.count }</h4>
									<h4>첫번째 여부 : ${st.first }</h4>
									<h4>마지막 여부 : ${st.last }</h4> --%>
								</td>
								<td>	
									<a href="./detail.do?department_id=${pageScope.dto.department_id }">
									${pageScope.dto.department_name }</a>
								</td>
							</tr>
						
						</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>
	</section>

	<%@ include file="../template/footer.jsp"%>
	


</body>
</html>




