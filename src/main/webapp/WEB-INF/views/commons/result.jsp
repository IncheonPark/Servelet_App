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

</head>
<body>
	
		<script type="text/javascript">
			alert("${requestScope.result}");
			location.href="${requestScope.path}";
		</script>
	
		

    <%@ include file="/WEB-INF/views/template/header.jsp" %>
    

    <section class="parent">
    <div class="section_left left child">
        <%@ include file="/WEB-INF/views/template/nav.jsp" %>
    </div>
    <div class="section_right right child">
        <div class="content">
			<h1>여기는 처리 결과 화면입니다</h1>
			
        </div>
    </div>
	</section>
    

    <%@ include file="/WEB-INF/views/template/footer.jsp" %>
    


</body>
</html>