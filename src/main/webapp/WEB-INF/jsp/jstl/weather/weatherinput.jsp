<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 입력 페이지</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script
  src="https://code.jquery.com/jquery-3.6.3.js"
  integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
        
<link rel="stylesheet" href="/jstl/weather/style.css" type="text/css">

</head>
<body>
	<div id="wrap">
		<form method="post" action="/jstl/weather/add">
		<section class="contents d-flex">
			<%@ include file="menu.jsp" %>
			<div class="main-contents col-9 ml-3 mt-3">
				<h1>날씨 입력</h1>
				<div class="container">
					<div class="d-flex justify-content-around mt-3">
						<div class="date input-group d-flex align-items-center mr-3">
							<label class="mr-2">날짜</label>
							<input type="text" class="form-control" id="date" name="date" >
						</div>
						<div class="weather input-group d-flex align-items-center mr-3">
							<label class="mr-2">날씨</label>
							<select class="custom-select" name="weather">
								<option>맑음</option>
								<option>구름조금</option>
								<option>흐림</option>
								<option>비</option>
							</select>
						</div>
						<div class="microDust input-group d-flex align-items-center">
							<label class="mr-2">미세먼지</label>
							<select class="custom-select" name="microDust">
								<option>좋음</option>
								<option>보통</option>
								<option>나쁨</option>
								<option>최악</option>
							</select>
						</div>
					</div>
					
					<div class="d-flex justify-content-around mt-5">
						<div class="temperatures input-group d-flex align-items-center mr-3">
							<label class="mr-2">기온</label>
							<input type="text" class="form-control" name="temperatures">
							<div class="input-group-append">
								<span class="input-group-text">℃</span>
							</div>
						</div>
						<div class="precipitation input-group d-flex align-items-center mr-3">
							<label class="mr-2">강수량</label>
							<input type="text" class="form-control" name="precipitation">
							<div class="input-group-append">
								<span class="input-group-text">mm</span>
							</div>
						</div>
						<div class="windSpeed input-group d-flex align-items-center">
							<label class="mr-2">풍속</label>
							<input type="text" class="form-control" name="windSpeed">
							<div class="input-group-append">
								<span class="input-group-text">km/h</span>
							</div>
						</div>
					</div>
					
					<div class="d-flex justify-content-end">
					<button type="submit" class="btn btn-success mt-3 right">저장</button>
					</div>
				</div>
			</div>
		</section>
		</form>
		<%@ include file="footer.jsp" %>
	</div>
	
	<script>
		$("#date").datepicker({
			dateFormat:"yy-mm-dd"	
		});
	</script>
</body>
</html>