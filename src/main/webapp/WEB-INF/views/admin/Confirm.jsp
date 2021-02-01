<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기서 확인</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<table class="table table-hover">
		<tr>
			<td>글 번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>작성일</td>
			<td>회원코드</td>
		</tr>
		<c:forEach items="${beSellerList}" var="list">
		<tr>
			<td>${list.BO_NUM}</td>
			<td>${list.BO_TITLE}</td>
			<td><a href="BoardView?BO_NUM=${list.BO_NUM}">${list.BO_CONTENT}</a></td>
			<td>${list.BO_DATE}</td>
			<td>${list.BO_MBCODE}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>