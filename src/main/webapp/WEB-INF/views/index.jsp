<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/layout.css">
<%-- <%@ include file="/WEB-INF/views/template/common.jsp" %>
 --%><c:import url="/WEB-INF/views/template/common.jsp"></c:import>

</head>
<body>
	<!-- Sementic tag -->
	<!-- JSP 파일 불러오기 : header.jsp -->
<%-- 	<%@ include file="/WEB-INF/views/template/header.jsp"%>
 --%>	<c:import url="/WEB-INF/views/template/header.jsp"></c:import>

	<section class="contents wrap_left">
		<div class="left contents_left">			
<%-- 			<%@ include file="./template/nav.jsp" %>
 --%>			<c:import url="./template/nav.jsp"></c:import>
		</div>
		<div class="right contents_right">
			<h4>foreach 연습</h4>
			<c:forEach begin="1" end="10" var="i"> <!-- 1부터 10까지, 즉 10번 반복 -->
				<h4>${i }</h4>
			</c:forEach>
			
			<hr>
			<c:forEach begin="1" end="10" step="2" var="i"> <!-- 1부터 10까지 ++2, -->
				<h4>${i }</h4>
			</c:forEach>
			
			<hr>
			<c:forEach begin="1" end="10" varStatus="st" var="i" step="1"> <!-- 1부터 10까지, 즉 10번 반복 -->
				<h4>${i }</h4>
				<h4>시작값 : ${st.begin }</h4>
				<h4>마지막값 : ${st.end }</h4>
				<h4>스텝 : ${st.step }</h4>
				<hr>
			</c:forEach>
		</div>
	</section>

<%-- 	<%@ include file="./template/footer.jsp"%>
 --%>	<c:import url="./template/footer.jsp"></c:import>
	


</body>
</html>