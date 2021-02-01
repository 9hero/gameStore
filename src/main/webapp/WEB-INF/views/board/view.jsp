<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 내용</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>
	.tableContents{
	width: 60%;
	margin: auto;
	height: 500px;
	}
	.cont{
		width : 500px;
		height: 500px;
		margin: auto;
	}
</style>
</head>
<body>

	<h1>상세보기</h1>
		<div class="tableContents">
			<table class="table table-striped">
				<tr style="text-align: center;">
					<th>게시판번호</th>
					<th>작성자</th>
					<th>제목</th>			
					<th>작성일</th>
					<th>조회수</th>
					<c:if test="${type eq 'JS' }">
					<th>승인</th>
					</c:if>
					<c:if test="${BoardInfo.BO_MBCODE eq userCode }">
					<th>수정</th>
					</c:if>
				</tr>				
				<tr style="text-align: center;">
					<td>${BoardInfo.BO_NUM}</td>
					<td>${BoardInfo.MB_NAME}</td>
					<td>${BoardInfo.BO_TITLE}</td>
					<td>${BoardInfo.BO_DATE}</td>
					<td>${BoardInfo.BO_HIT}</td>
					<c:if test="${type eq 'JS' }">	
					<td><a href="sellerApprove?mbcode=${BoardInfo.BO_MBCODE}">승인</a></td>
					</c:if>
					<c:if test="${BoardInfo.BO_MBCODE eq userCode }">
					<td><a href="boardModi?bnum=${BoardInfo.BO_NUM}">수정</a></td>
					</c:if>
				</tr>
			</table>
			<p>${BoardInfo.BO_CONTENT }</p>	
			<img src="${BoardInfo.BO_FICODE }">
			<a href="boardDel?bnum=${BoardInfo.BO_NUM}">삭제</a>
			
		</div>

<h2>보드 리스트</h2>
	<div class="tableContents">
	<table class="table table-striped">
		<tr>
			<th>게시판번호</th>
			<th>작성자</th>
			<th>제목</th>			
			<th>작성일</th>
			<th>조회수</th>			
		</tr>
			<c:forEach items="${BoardList}" var ="list">
			<tr>				
				<td>${list.BO_NUM}</td>
				<td>${list.MB_NAME}</td>
				<td><a href="boardView?bnum=${list.BO_NUM}&id=${id}">${list.BO_TITLE}</a></td>
				<td>${list.BO_DATE}</td>
				<td>${list.BO_HIT}</td>			
			</tr>
			</c:forEach>	
	</table>
	<a href="goWriteForm" class="button">글쓰기</a>
	</div>
	<div>
		<div id="pageBtn">
			<c:choose>
				<c:when test="${page.page eq 1}">
					[이전]&nbsp;
				</c:when>
				<c:otherwise>
					<a href="boardList?page=${page.page-1 }&id=${type}">[이전]</a>&nbsp;
				</c:otherwise>
			</c:choose>
			
			<c:forEach var = "i" begin="${page.pageBtnStart}" end="${page.pageBtnEnd }" step="1">
				<c:choose>
					<c:when test="${i eq page.page}">
					${i}
					</c:when>
					<c:otherwise>
					<a href="boardList?page=${i}&id=${type}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<c:choose>
				<c:when test="${page.page eq page.lastPage}">
					[다음]
				</c:when>
				<c:otherwise>
					<a href="boardList?page=${page.page+1 }&id=${type}">[다음]</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>