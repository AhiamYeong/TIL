<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 화면</title>
</head>
<body>
	<h2>결과</h2>
	<a href="/img/${fileName}">결과이미지</a>
	<img src="/img/${fileName}">
	
	<a href="/download?fileName=${fileName}">이미지 다운로드</a>
	
	
</body>
</html>