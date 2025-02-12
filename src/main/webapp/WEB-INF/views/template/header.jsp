<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
	<header class="wrap_left">
		<div class="left logo">
			<img src="/resources/images/bithumb.png">
		</div>
		<div class="right menu ">
			<ul>
				<c:choose>					
					<c:when test="${empty user }">
						<li><a href="/employees/login.do">로그인</a></li>
						<li><a href="/employees/join.do">사원 등록</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/employees/logout.do">로그아웃</a></li>
						<li><a href="/employees/mypage.do">마이 페이지</a></li>
					</c:otherwise>
				</c:choose>
				
				
			</ul>
			
		</div>
	</header>
