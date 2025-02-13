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
			<h2>정보수정 화면</h2>
			<form method="post" action="./update.do" id="login-form">
				<input type="hidden" name="userName" value="${sessionScope.user.userName}" >
				비밀번호 <input type="password" name="password" value="${sessionScope.user.password }" >
				이름 <input type="text" name="name" value="${sessionScope.user.name }" >
				전화번호 <input type="text" name="phone" value="${sessionScope.user.phone }" >
				이메일 <input type="text" name="email" value="${sessionScope.user.email }" >
				
				<input type="submit" value="수정하기">
			</form>
        </div>
						
        
    </div>
	</section>
    

    <%@ include file="/WEB-INF/views/template/footer.jsp" %>
    


</body>
</html>