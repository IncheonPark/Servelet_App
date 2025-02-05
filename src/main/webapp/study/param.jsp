<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="./study_paramProcess.jsp" method="post">
		<div>
			<input type="text" name="p1" value="p1 data" readonly>
			<!-- readonly 수정 불가 & 파라미터 넘어감, disabled 수정 불가 & 파라미터 안 넘어감 -->
		</div>
		
		<div>
			<input type="hidden" name="p2" value="value">
		</div>
		
		<div>
			남<input type="radio" name="p3" value="male">
			여<input type="radio" name="p3" value="female" checked="checked">
		</div>
		
		<div>
			<select name="p4">
				<option value="kt">KT</option>
				<option value="skt">SKT</option>
				<option value="lgt" selected="selected">LGT</option>
			</select>
		</div>
		
		<div>
			soccer<input type="checkbox" name="p5" value="soccer">
			baseball<input type="checkbox" name="p5" value="baseball">
			basketball<input type="checkbox" name="p5" value="basketball" checked="checked">
		</div>
		
		<div>
			<input type="submit" value="전송">
		</div>
	</form>

</body>
</html>