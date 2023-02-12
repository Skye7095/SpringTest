<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약페이지</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet" href="/ajax/booking/style.css" type="text/css">

</head>
<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>
	
		<div class="reservationDiv container">
			<h3 class="text-center mt-3">예약하기</h3>
			<label>이름</label><br>
			<input type="text" class="form-control" id="nameInput">
			
			<label>예약날짜</label><br>
			<input type="text" class="form-control" id="dateInput">
			
			<label>숙박일수</label><br>
			<input type="text" class="form-control" id="dayInput">
			
			<label>숙박인원</label><br>
			<input type="text" class="form-control" id="headcountInput">
			
			<label>전화번호</label><br>
			<input type="text" class="form-control" id="phoneNumberInput">
			
			<button type="button" id="bookingBtn" class="btn btn-success col-12 text-center">예약하기</btn>
		</div>
		
		<%@ include file="footer.jsp" %>
		
	</div>
	<script>
		$(document).ready(function(){
			/*
			$("#dateInput").datepicker({
	               minDate:0, 
	               dateFormat: "yyyy년 MM월 dd일",
	        });
			*/
			
			$("#bookingBtn").on("click", function(){
				let name = $("#nameInput").val();
				let date = $("#dateInput").val();
				let day = $("#dayInput").val();
				let headcount = $("#headcountInput").val();
				let phoneNumber = $("#phoneNumberInput").val();
				
				if(name == ""){
					alert("이름을 입력하세요");
					return;
				}
				if(date == ""){
					alert("예약날짜를 입력하세요");
					return;
				}
				if(day == ""){
					alert("숙박일수를 입력하세요");
					return;
				}
				// day가 숫자가 아닌 경우 유효성 검사
				if(isNaN(day)){
					alert("숙박일수는 숫자만 입력하세요");
					return;
				}
				if(headcount == ""){
					alert("숙박인원을 입력하세요");
					return;
				}
				// headcount가 숫자가 아닌 경우 유효성 검사
				if(isNaN(headcount)){
					alert("인원을 숫자로 입력하세요");
					return;
				}
				if(phoneNumber == ""){
					alert("전화번호를 입력하세요");
					return;
				}
				
				$.ajax({
    				type:"get"
    				, url:"/ajax/booking/add"
    				,data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
    				, success:function(data) {
    					if(data.result == "success") {
    						location.href = "/ajax/booking/list";
    					} else {
    						alert("예약 실패");
    					}
    				}
    				, error:function() {
    					alert("예약 에러");
    				}
    			});
			});
		});
	</script>
</body>
</html>