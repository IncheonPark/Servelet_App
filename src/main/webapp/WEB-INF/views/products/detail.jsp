<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/resources/css/layout.css">
<link rel="stylesheet" type="text/css" href="/resources/css/table.css">
<style>
	
</style>
</head>
<body>
    <%@ include file="/WEB-INF/views/template/header.jsp" %>
    

    <section class="parent">
    <div class="section_left left child">
        <%@ include file="/WEB-INF/views/template/nav.jsp" %>
    </div>
    <div class="section_right right child">
    	
        <div class="content">
        	
        	<c:if test="${not empty sessionScope.user }">
        		<a href="./update.do?productNum=${dtoSS.productNum}"><input type="button" value="상품 수정"></a>
        	</c:if>
        	
        	<a href="../accounts/make.do?productNum=${dtoSS.productNum}"><input type="button" value="상품 가입"></a>
        	
			<table class="table1">
				<thead>
					<tr>
						<th>상품번호</th> <th>이름</th> <th>연이율</th> <th>생성일</th> <th>설명</th>
					</tr>
					
				</thead>
				<tbody>
					
						<tr>
							<td>${dtoSS.productNum }</td>
							<td>${dtoSS.productName }</td>
							<td>${dtoSS.productRate }</td>
							<td>${dtoSS.productDate }</td>
							<td>${dtoSS.productDetail }</td>
						</tr>
										
				</tbody>
			</table>
			
        </div>
    </div>
	</section>
    

    <%@ include file="/WEB-INF/views/template/footer.jsp" %>
    


</body>
</html>