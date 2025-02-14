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

</head>
<body>
    <%@ include file="/WEB-INF/views/template/header.jsp" %>
    

    <section class="parent">
    <div class="section_left left child">
        <%@ include file="/WEB-INF/views/template/nav.jsp" %>
    </div>
    <div class="section_right right child">    	
        <div class="content">
        	<div>
        		<a href="./add.do"><input type="button" value="상품 등록"></a>        		
        	</div>
			<table class="table1">
				<thead>
					<tr>
						<th>상품번호</th> <th>이름</th> <th>연이율</th> <th>만기일</th> <th>설명</th>
					</tr>
					
				</thead>
				<tbody>
					<c:forEach var="dto" items="${list}">
						<tr style="cursor:pointer;" onClick="location.href='./detail.do?productNum=${dto.productNum}'">
							<td>${dto.productNum }</td>
							<td>${dto.productName }</td>
							<td>${dto.productRate }</td>
							<td>${dto.productDate }</td>
							<td>${dto.productDetail }</td>
						</tr>
					</c:forEach>		
				</tbody>
			</table>
			
        </div>
    </div>
	</section>
    

    <%@ include file="/WEB-INF/views/template/footer.jsp" %>
    


</body>
</html>