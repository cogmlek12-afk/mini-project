<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환자 삭제</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
<h2>환자 삭제</h2>

<form action="delete" method="post">

삭제할 환자번호

<input type="number" name="patientId">

<br><br>

<input type="submit" value="삭제">

</form>
</div>
</body>
</html>