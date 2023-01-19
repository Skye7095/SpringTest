<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공인중개사 정보</title>
</head>
<body>
	<div class="container">
		<h1>공인중개사 정보</h1>
		<table>
			<tr>
				<th>id</th>
				<td>${realtor.id }</td>
			</tr>
			<tr>
				<th>상호명</th>
				<td>${realtor.office}</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${realtor.phoneNumber }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${realtor.address }</td>
			</tr>
			<tr>
				<th>등급</th>
				<td>${realtor.grade }</td>
			</tr>
		</table>
	</div>
</body>
</html>