<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>지역 추가 페이지</h1>
	
	<form action="./addProcess.jsp" method="post">
	<input type="text" value="거리명" name="street_address">
	<input type="text" value="우편번호" name="postal_code">
	<input type="text" value="도시명" name="city">
	<input type="text" value="지역주" name="state_province">
	<input type="text" value="국가코드" name="country_id">
	
	<input type="submit" value="등록">
	</form>

</body>
</html>