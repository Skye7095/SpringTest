<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가하기 페이지</title>

<script
  src="https://code.jquery.com/jquery-3.6.3.js"
  integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
  crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가</h1>
		<label>제목</label><br>
		<input type="text" class="form-control" id="nameInput"><br>
		<label>주소</label><br>
		<div class="d-flex justify-content-between">
			<input type="text" class="form-control col-8" id="urlInput">
			<button type="button" class="col-3 btn btn-primary text-center text-light" id="duplicateBtn">중복확인</button>
		</div><br>
		<div>
			<span id="blankSpan"></span>
			<span id="duplicatedSpan" class="text-danger">중복된 URL입니다</span>
			<span id="NotDuplicatedSpan" class="text-success">저장 가능한 URL입니다</span>
		</div><br>
		
		<button type="button" id="addBtn" class="btn btn-success col-12 text-center">추가</btn>
	</div>
	
	<script>
		$(document).ready(function(){
			
			$("#blankSpan").show();
			$("#duplicatedSpan").hide();
			$("#NotDuplicatedSpan").hide();
			
			var isChecked = false;
			
			// url 중복상태 저장 변수
			var isDuplicate = true;
			
			
			$("#urlInput").on("input", function(){
				// urlInput 또 변경했는지 확인
				// 중복체크후 변경하면 중복체크 과정을 초기화하는 것
				isChecked = false;
				isDuplicate = true;
			});
			
			$("#duplicateBtn").on("click", function(){
				
				let url = $("#urlInput").val();
				
				if(url == ""){
					alert("url를 입력하세요");
					return;
				}
				
				$.ajax({
					type:"post"
					, url:"/ajax/favorite/is_duplicateURL"
					, data:{"url":url}
					, success:function(data){
						
						isChecked = true;
						
						if(data.is_duplicate){
							$("#blankSpan").hide();
							$("#duplicatedSpan").show();
							$("#NotDuplicatedSpan").hide();
							isDuplicate = true;
						}else{
							$("#blankSpan").hide();
							$("#duplicatedSpan").hide();
							$("#NotDuplicatedSpan").show();
							isDuplicate = false;
						}
					}
					, error:function(){
						alert("URL 중복 여부를 확인할 수 없습니다");
					}
				});
			});
			
			$("#addBtn").on("click", function(){
				
				let name = $("#nameInput").val();
				let url = $("#urlInput").val();
				
				if(name == ""){
					alert("이름을 입력하세요");
					return;
				}
				if(url == ""){
					alert("링크를 입력하세요");
					return;
				}
				if(!(url.startsWith("http://") || url.startsWith("https://"))){
					alert("링크 형식 맞지 않습니다");
					return;
				}
				if(!isChecked){
					alert("중복확인 버튼 누르세요");
					return;
				}
				if(isDuplicate){
					alert("중복된 url를 저장할 수 없습니다");
					return;
				}
					
				$.ajax({
					type:"get"
					, url:"/ajax/favorite/add"
					, data:{"name":name, "url":url}
					, success:function(data){
						if(data.result == "success"){
							location.href="/ajax/favorite/list";
						}else{
							alert("추가 실패");
						}
					}
					, error:function(){
						alert("추가 에러");
					}
				});
				
			});
		});
	</script>
</body>
</html>