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
<link rel="stylesheet" type="text/css" href="/resources/css/form.css">
<link rel="stylesheet" type="text/css" href="/resources/css/table.css">

</head>
<body>
    <%@ include file="/WEB-INF/views/template/header.jsp" %>
    

    <section class="parent">
    <div class="section_left left child">
        <%@ include file="/WEB-INF/views/template/nav.jsp" %>
    </div>
    <div class="section_right right child">
        
			
		<div class="login-wrapper">
			<h2>유저 정보</h2>
			<form method="post" action="" id="login-form">
				<input type="hidden" name="userName" value="${sessionScope.user.userName}">
				비밀번호 <input type="password" name="password" value="${sessionScope.user.password }" readonly>
				이름 <input type="text" name="name" value="${sessionScope.user.name }" readonly>
				전화번호 <input type="text" name="phone" value="${sessionScope.user.phone }" readonly>
				이메일 <input type="text" name="email" value="${sessionScope.user.email }" readonly>
				
				<a href="./update.do"><input type="button" value="정보 수정"></a>
			</form>
        </div>
        							
			<table class="table1">
				<thead>
					<tr>
						<th>계좌번호</th> <th>예금주</th> <th>상품번호</th> <th>잔액</th> <th>생성일</th>
					</tr>
					
				</thead>
				<tbody>
				<c:if test="${not empty requestScope.list }">
					<c:forEach var="dtoA" items="${requestScope.list}">
						<tr>
							<td>${dtoA.accountNum }</td>
							<td>${dtoA.userName }</td>
							<td>${dtoA.productNum }</td>
							<td>${dtoA.accountBalance }</td>
							<td>${dtoA.date }</td>
														
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty requestScope.list }">
					<tr>
						<td>계좌정보 없음</td>
						<td>계좌정보 없음</td>
						<td>계좌정보 없음</td>
						<td>계좌정보 없음</td>
						<td>계좌정보 없음</td>
													
					</tr>
				</c:if>
										
				</tbody>
			</table>
				
				
    </div>
	</section>
    

    <%@ include file="/WEB-INF/views/template/footer.jsp" %>
    


</body>
</html>