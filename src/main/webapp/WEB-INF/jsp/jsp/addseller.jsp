<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 추가</title>
</head>
<body>
	<div class="container">
		<form method="post" action="/jsp/seller/add">
			<h1>판매자 추가</h1>
			<label>닉네임</label><br>
			<input type="text" name="nickname"><br>
			<label>프로필 사진 url</label><br>
			<input type="text" name="profileImage" style="width:500px"><br>
			<label>온도</label><br>
			<input type="text" name="temperature"><br>
			<button type="submit" class="btn btn-primary mt-3">추가</button>
		</form>
	</div>
</body>
</html>