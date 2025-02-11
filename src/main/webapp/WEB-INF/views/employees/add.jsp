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

<style>

	.form-wrapper {
		width: 400px;
		height: 350px;
		padding: 40px;
		box-sizing: border-box;
	}

	.form-wrapper > h2 {
		font-size: 24px;
		color: #6A24FE;
		margin-bottom: 20px;
	}
	
	#add-form > input {
		width: 100%;
		height: 48px;
		padding: 0 10px;
		box-sizing: border-box;
		margin-bottom: 16px;
		border-radius: 6px;
		background-color: #F8F8F8;
	}
	
	#add-form > input[type="submit"]{
		color: #fff;
		font-size: 16px;
		background-color: #6A24FE;
		margin-top: 20px;
	}

</style>

</head>
<body>
	<!-- Sementic tag -->
	<!-- JSP 파일 불러오기 : header.jsp -->
	<%@ include file="../template/header.jsp"%>

	<section class="contents wrap_left">
		<div class="left contents_left">
			<!-- JSP 파일 불러오기 : nav.jsp -->
			<%@ include file="../template/nav.jsp" %>
			
		</div>
		<div class="right contents_right">
			<div class="form-wrapper">
				<h2>사원 등록 페이지</h2>
				
				<form action="./add.do" method="post" id="add-form">
					
						<input type="text" name="password" placeholder="password">
						
						<input type="text" name="first_name" placeholder="first_name">
						<input type="text" name="last_name" placeholder="last_name">
						<input type="text" name="email" placeholder="email">
						<input type="text" name="phone_number" placeholder="phone_number">
						<input type="text" name="job_id" placeholder="job_id">
						
						<input type="text" name="salary" placeholder="salary">
						<input type="text" name="commission_pct" placeholder="commission_pct">
						
						<input type="text" name="manager_id" placeholder="manager_id">
						<input type="text" name="department_id" placeholder="department_id">
						
															
						<input type="submit" value="등록하기">
						
				</form>
			</div>
		</div>
	</section>
	<!-- JSP 파일 불러오기 : footer.jsp -->
	<%@ include file="../template/footer.jsp"%>
	


</body>
</html>