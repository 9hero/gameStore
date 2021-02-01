<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 가입</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<h1>판매자가 되길 원하십니까? ${sessionScope.userCode }</h1>
	<form name="form" action="doJoinSeller" method="post">
		<input type="hidden" name="BO_MBCODE" value="${sessionScope.userCode }">
		<input type="hidden" name="BO_TYPE" value="JS">
		제목 <input id="title" type="text" name="BO_TITLE">
		내용 <textarea id="content"name="BO_CONTENT"></textarea>
		<button type="button" onclick="submits()">제출</button>
	</form>
</body>
<script>
function submits(){
    var title = document.getElementById("title").value;
    var content = $('#content').val();
	if(content == "" || title == "" ){
        alert('제목과 내용을 작성 해주십시오')
	}else{
		form.submit();
	}	
}
</script>

</html>