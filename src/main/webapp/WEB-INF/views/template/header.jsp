<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header class="parent">
    <div class="header_left left child">
        <div class="logo">
            <a href="/index.do">
            	<img src="/resources/images/sinhan.png">
            </a>
        </div>
    </div>
    <div class="header_right right child">
        <ul class="header_nav">
        
        	<c:if test="${empty sessionScope.user }">
	            <li><a href="/users/login.do">로그인</a></li>
	            <li><a href="/users/join.do">회원가입</a></li>        	
        	</c:if>
        	
        	<c:if test="${not empty sessionScope.user }">
        		<li>${user.name }님 접속 중</li>
        		<li><a href="/users/logout.do">로그아웃</a></li>
	            <li><a href="/users/mypage.do">마이페이지</a></li>
        	</c:if>
        
        </ul>
    </div>
</header>