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
			<h2>로그인</h2>
			<form method="post" action="./login.do" id="login-form">
				<input type="text" name="userName" placeholder="아이디">
				<input type="password" name="password" placeholder="비밀번호">
				<label for="remember-check">
					<input type="checkbox" id="remember-check">아이디 저장하기
				</label>
				<input type="submit" value="로그인 하기">
			</form>
        </div>
    </div>
	</section>
	   

    <%@ include file="/WEB-INF/views/template/footer.jsp" %>
    


</body>
</html>