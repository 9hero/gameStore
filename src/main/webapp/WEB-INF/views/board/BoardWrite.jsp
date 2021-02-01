<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- summer note -->
<script src="resources/js/summernote/summernote-lite.js"></script>
<script src="resources/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="resources/css/summernote/summernote-lite.css">
</head>
<body>
<h1>글작페(글작성페이지)</h1>
	<form action="boardWrite" method="post" enctype="multipart/form-data">
		<div id="forms">
		<input type="hidden" name="BO_TYPE" value="${type }">
		<input type="hidden" name="BO_MBCODE" value="${userCode }">
		<p>작성자 <input type="text" value="${userID }" readonly><p>		
		<p>제목 <input type="text" name="BO_TITLE"><p>
		<p>글내용 <textarea id="summernote" name="BO_CONTENT"></textarea><p>
		<p>파일첨부 <input type="file" name="BFILE"><p>
		<button type="button" onclick="goWrite(this.form)">작성</button>
		</div>
	</form>
</body>
<script>
function goWrite(form){
	var writer = form.BWRITER.value;
	var title = form.BTITLE.value;
	var content = form.editordata.value;
	if (title.trim() == ''){
		alert("제목을 입력해주시오")
		return false;
	}else if (content.trim() == ''){
		alert('글자좀 써보시오')
		return false;
	}
	form.submit();
}
$(document).ready(function() {
	//여기 아래 부분
	$('#summernote').summernote({			
		  width: 1000,
		  height: 300,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
		  callbacks: { 
			// 콜백을 사용
            // 이미지를 업로드할 경우 이벤트를 발생
				onImageUpload: function(files, editor, welEditable) {
					for (var i = files.length - 1; i >= 0; i--) {
			              sendFile(files[i], this);
			        }//출처: https://devofhwb.tistory.com/90 [이든의 생활코딩]	
				}
		  }
	});
});

	function sendFile(file, editor) {
        // 파일 전송을 위한 폼생성
 		data = new FormData();
 	    data.append("uploadFile", file);
 	    $.ajax({ // ajax를 통해 파일 업로드 처리
 	        data : data,
 	        type : "POST",
 	        url : "imgStore",
 	        cache : false,
 	        contentType : false,
 	        enctype: 'multipart/form-data',
 	        processData : false,
 	        success : function(url) { // 처리가 성공할 경우
                // 에디터에 이미지 출력
 	        	$(editor).summernote('editor.insertImage', url);
 	        }
 	    });
 	}
</script>
</html>