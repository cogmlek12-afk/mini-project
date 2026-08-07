<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환자 조회</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>환자 조회</h2>

<form action="search" method="get">

환자번호

<input type="number" name="patientId">

<input type="submit" value="조회">

</form>

</body>
</html>