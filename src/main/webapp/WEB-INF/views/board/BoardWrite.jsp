<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        img{
            width: 300px;
            height: 400px;           
        }

    </style>
<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- summer note -->
<!-- <script src="resources/js/summernote/summernote-lite.js"></script>
<script src="resources/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="resources/css/summernote/summernote-lite.css"> -->
</head>
<body>
    <h1>글작페(글작성페이지)</h1>
		<form action="boardWrite" method="post" id="writeForm" enctype="multipart/form-data">		
			<input type="hidden" name="BO_TYPE" value="${type }">
			<input type="hidden" name="BO_MBCODE" value="${userCode }">
			<p>작성자 <input type="text" value="${userID }" readonly><p>		
			<p>제목 <input type="text" name="BO_TITLE"><p>
			<p>글내용 <textarea name="BO_CONTENT"></textarea><p>
	        <button type="button" onclick="goWrite(this.form)">작성</button>
	        <p>파일첨부 <input type="file" name="BFILE" id="bfile"multiple></p>
	    </form>	
        		
			파일 미리 보기
			<div id="PreImgFrame">
				<div id="Preimgs">
					<!--<img src="${e.target.result}"> 	 -->		
				</div>			
			</div>
		
		
    
    
</body>
<script>
var sel_files = [];
var filesLength;

$(document).ready(function(){        
    $("#bfile").on("change", ImgSelect);
});

function ImgSelect(e){
    sel_files = [];     
    $("#Preimgs").empty();
    filesLength = 0;
    var index = 0;

    var file = e.target.files;
    filesLength = file.length;

    for(i = 0; i<file.length; i++){        
        sel_files.push(file[i]);
        
        var fileReader = new FileReader();        
        fileReader.readAsDataURL(file[i]);
        
        fileReader.onload = function(f){                         
            var test = '<img src="'+f.target.result+'">';                                  
            $("#Preimgs").append(test);     
        };
    }
    
}


 function goWrite(form){
  	//var formData = new FormData(form);
	var title = form.BO_TITLE.value;
	var content = form.BO_CONTENT.value;
	/*
	for(i=0; i<filesLength; i++){           
        var index = "file" + i;
        console.log('append',index,sel_files[i]);
        formData.append('getfiles' , sel_files[i]);
    }*/
	if (title.trim() == ''){
		alert("제목을 입력해주시오")
		return false;
	}else if (content.trim() == ''){
		alert('글자좀 써보시오')
		return false;
	}/*
	console.log(formData.has('getfiles')); // true
	console.log(formData.getAll('getfiles'),'getfiles'); 
	if(formData.has('getfiles')){ */
	form.submit();
	
} 

</script>
</html>