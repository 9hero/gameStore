<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>The time on the server is ${serverTime}. </P>
<c:if test="${empty userName}">
<a href="joinAndlogin">로그인 하기</a>
</c:if>
<c:if test="${not empty userName}">
<a href="logout">로그아웃</a>
</c:if>
<c:if test="${isCompany eq 0}">
<a href="shop/joinSeller">판매자가입</a>
</c:if>
<c:if test="${isCompany eq 1}">
<a href="shop/myCompany">상점 관리</a>
</c:if>
<c:if test="${isCompany eq 2}">
<a href="Adminmanage">관리자 페이지</a>
</c:if>

<P>${userName}</P>





</body>
</html>
