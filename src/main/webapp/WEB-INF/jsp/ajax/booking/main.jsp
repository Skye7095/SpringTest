<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/ajax/booking/style.css" type="text/css">
	
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<div id="wrap" >
            <%@ include file="header.jsp" %>

            <section class="banner">
                <img src="http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner1.jpg" id="bannerImage">
            </section>
            <sction class="d-flex">
                <article class="reservation d-flex justify-content-center align-items-center">
                    <div class="display-4">
                        실시간 <br>
                        예약 하기 
                    </div>
                </article>
                <article class="reservation-confirm">
                    <div class="m-4">
                        <div>
                        	<h3>예약확인</h3>
                        	<div class="d-flex mt-3">
                        	<label class="text-center col-3 mr-3">이름</label>
                        	<input type="text" class="form-control col-9" id="nameInput">
                        	</div>
                        	
                        	<div class="d-flex mt-3">
                        	<label class="text-center col-3 mr-3">전화번호</label>
							<input type="text" class="form-control col-9" id="phoneNumberInput">
							</div>
                        </div>
                        <div class="d-flex justify-content-end">
                            <button class="btn btn-success mt-3 mr-5" id="lookupBtn">조회 하기</button>
                        </div>
                    </div>
	                </article>
	                <article class="reservation-call d-flex justify-content-center align-items-center">
	                    <div>
	                        <h3>예약문의 : </h3>
	                        <h1>010-</h1>
	                        <h1>000-1111</h1>
	                    </div>
	                </article>
	            </sction>

            <%@ include file="footer.jsp" %>


        </div>
        
        <script>
        $(document).ready(function() {
        	$("#lookupBtn").on("click", function() {
               	let name = $("#nameInput").val();
               	let phoneNumber = $("#phoneNumberInput").val();
        	   
                if(name == "")   {
                    alert("이름을 입력하세요.");
                    return;
                }

                if(phoneNumber == "")   {
                    alert("전화번호를 입력하세요.");
                    return;
                }

                // 010 으로 시작하는 것만 통과
                if(!phoneNumber.startsWith("010"))   {
                    alert("010 으로 시작하는 번호만 입력가능합니다. ");
                    return;
                }


                $.ajax({
             	   type:"get"
             	   , url:"/ajax/booking/main/confirm"
             	   , data:{"name":name, "phoneNumber":phoneNumber}
            		, success:function(data){
            			
            			if(data.result == "fail"){
            				alert("조회한 대상이 없습니다");
            			}else{
            			// console.log(data);
            			
	             			alert("이름: " + data.booking.name +
	             					"\n날짜: " + data.booking.date + 
	             					"\n일수: " + data.booking.day + 
	             					"\n인원: " + data.booking.headcount + 
	             					"\n상태: " + data.booking.state);
	            			}
	            		}
            		, error:function(){
            			alert("조회 에러");
            		}
                })

           });
	
           var bannerList = ["http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner1.jpg", "http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner2.jpg", "http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner3.jpg", "http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner4.jpg"];
           var currentImageIndex = 0;
           setInterval(function() {
               $("#bannerImage").attr("src", bannerList[currentImageIndex]);
               currentImageIndex++;

               if(currentImageIndex == bannerList.length) {
                   currentImageIndex = 0;
               }
           }, 3000); 
	    } );
	   </script>
</body>
</html>