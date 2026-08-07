
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환자 수정 조회</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<h2>수정할 환자 조회</h2>


<form action="updateSearch" method="get">

환자 이름 :
<input type="text" name="name">

<button type="submit">
조회
</button>

</form>


</body>
</html>
