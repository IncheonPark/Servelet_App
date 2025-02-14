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

</head>
<body>
    <%@ include file="/WEB-INF/views/template/header.jsp" %>
    

    <section class="parent">
    <div class="section_left left child">
        <%@ include file="/WEB-INF/views/template/nav.jsp" %>
    </div>
    <div class="section_right right child">
        <div class="login-wrapper">
			<h2>상품 정보 입력</h2>
			<form method="post" action="./add.do" id="login-form">
								
				<input type="text" name="productName" placeholder="상품 이름">
				<input type="text" name="productRate" placeholder="상품 연이율">
				<input type="date" name="productDate" placeholder="상품 만기일">
				<input type="text" name="productDetail" placeholder="상품 상세">
				
				<input type="submit" value="상품 등록하기">
			</form>
        </div>
    </div>
	</section>
	   

    <%@ include file="/WEB-INF/views/template/footer.jsp" %>
    


</body>
</html>