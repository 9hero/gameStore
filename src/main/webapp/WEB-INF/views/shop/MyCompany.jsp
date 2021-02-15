<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 상점</title>
<script type="text/javascript" src="../resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../resources/js/store/storeManage.js"></script>
<link rel="stylesheet" type="text/css" href="../resources/css/store/storeManagecss.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
    <div class="contents">
        <h1>상점관리</h1>
        <div class="float-left">
            <div class="manageOption">
                <a href="">상품 등록</a>
            </div>
            <div class="manageOption">
                <a href="">상품 관리</a>
            </div>
        </div>
        <div class="main">

            <div class="mainform">
            	 <div class="mainContent">
                <form action="/test" method="post" id="myCompanyForm" > 
                   
                        <div>게임 명<br><input id="GO_NAME" name="GO_NAME" type="text"></div>
                        <div>재고 <br><input name="GO_QTY" type="text"></div>
                        <div>정가 <br><input name="GO_LISTPRICE" type="text"></div>
                        <div>판매가격 <br><input name="GO_PRICE" type="text"></div>
                        <div>회사 명 <br><input readonly="readonly" value="${userName }" type="text"></div>
                        <div>출시일 <br><input name="GO_LAUNCH" type="text"></div>
                        <div>타이틀 사진 <input type="file" id="titleImg" name="titleImg"></div>
                        <div>참조 사진 <input type="file" id="gFile" name="gFile" multiple></div>
                        <div><button onclick="goodsReg(myCompanyForm)" type="button">상품등록</button></div>
                    
                </form>
               	 </div>
                <a href="javascript:void(0)" id="btn_popup_open">타이틀 사진 보기</a>
                <a href="#">태그 넣어야하는데 어캐넣을까</a>               
            </div>

            <div class="imgDiv">
                <div class="imgbox">
                    
                </div>
            </div>
        </div>
    </div>

    <!-- 레이어 팝업 -->    
        <div class="popup_panel">
            <div class="popup_bg">              
            </div>
            <div class="popup_contents">
                <a href="javascript:void(0)" id="btn_popup_close">타이틀 사진을 등록하세요</a>
            </div>
        </div>
</body>
<script>

	function goodsReg(form){
		var GO_NAME = $(".GO_NAME").value;
		if(GO_NAME.trim() == ''){
			alert('제목쓰시오');
		}
		else {
			form.submit();
		}
	}
    function goWrite(form){
        if (title.trim() == ''){
            alert("제목을 입력해주시오")
            return false;
        }else if (content.trim() == ''){
            alert('글자좀 써보시오')
            return false;
        }

        form.submit();
        
    } 

	
    
    $(document).ready(function(){        
        //<!-- //이미지 선택 -->
        $("#gFile").on("change", ImgSelect); 
        $("#titleImg").on("change", titleImgSelect);   
    });
    
    function ImgSelect(e){ 
       
        $(".imgbox").empty();

        var index = 0;
    
        var file = e.target.files;
        filesLength = file.length;
    
        for(i = 0; i<file.length; i++){                             
            var fileReader = new FileReader();        
            fileReader.readAsDataURL(file[i]);            
            fileReader.onload = function(f){                         
                var test = '<img src="'+f.target.result+'">';                                  
                $(".imgbox").append(test);     
            };
        }
        
    }
    function titleImgSelect(e){

    $(".popup_contents").empty();

    var fileReader = new FileReader();
    fileReader.readAsDataURL(e.target.files[0]);

    fileReader.onload = function(f){
    var test = '<img src="'+f.target.result+'">';
    $(".popup_contents").append(test);

    }

    }

    </script>
</html>