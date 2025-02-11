<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	// 기존 스크립트릿 주석 처리하고 EL로 써보기	
	// DepartmentDTO dto = (DepartmentDTO)request.getAttribute("dto");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/layout.css">

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
	
			<h1>Dept Detail Page</h1>
			
			<c:choose>
				<c:when test="${not empty dto }">
					<h3>${dto.department_id}</h3>
					<h3>${dto.department_name }</h3>
					<h3>${dto.manager_id }</h3>
					
					<a href="./delete.do?department_id=${requestScope.dto.department_id}">부서 삭제</a>
					<a href="./update.do?department_id=${requestScope.dto.department_id}">부서 수정</a>
				</c:when>
					
				<c:otherwise>
					<h3>부서 정보 없음</h3>
				</c:otherwise>
				
			</c:choose>
			
			<%-- <c:if test="${not empty dto}">
				<h3>${dto.department_id}</h3>
				<h3>${dto.department_name }</h3>
				<h3>${dto.manager_id }</h3>
				
				<a href="./delete.do?department_id=${requestScope.dto.department_id}">부서 삭제</a>
				<a href="./update.do?department_id=${requestScope.dto.department_id}">부서 수정</a>
			</c:if>
			
			<c:if test="${empty dto}">
				<h3>부서 정보 없음</h3>
			</c:if> --%>
		
		</div>
	</section>

	<%@ include file="../template/footer.jsp"%>
	


</body>
</html>