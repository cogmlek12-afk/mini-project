<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환자 수정</title>
<link rel="stylesheet" href="css/style.css">
</head>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f8fb;
    margin: 0;
    padding: 40px;
}

.container {
    width: 450px;
    margin: auto;
    background: white;
    padding: 30px;
    border-radius: 15px;
    box-shadow: 0 5px 15px rgba(0,0,0,0.1);
}

h2 {
    text-align: center;
    color: #2c6e91;
    margin-bottom: 30px;
}

label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
    color: #444;
}

input {
    width: 100%;
    padding: 10px;
    margin-bottom: 18px;
    border: 1px solid #ccc;
    border-radius: 8px;
    box-sizing: border-box;
}

button {
    width: 100%;
    padding: 12px;
    background-color: #2c6e91;
    color: white;
    border: none;
    border-radius: 8px;
    font-size: 16px;
    cursor: pointer;
}

button:hover {
    background-color: #1f526e;
}
</style>
</head>

<body>

<div class="container">

<h2>환자 정보 수정</h2>

<form action="updatePatient" method="post">


<!-- 환자번호는 숨겨서 전달 -->
<input type="hidden" name="patientId"
value="${patient.patientId}">


이름 :
<input type="text" name="name"
value="${patient.name}" readonly>
<br><br>


나이 :
<input type="number" name="age"
value="${patient.age}">
<br><br>


주민번호 :
<input type="text" name="ssn"
value="${patient.ssn}">
<br><br>


보호자번호 :
<input type="text" name="pSsn"
value="${patient.PSsn}">

성별 :
<input type="text" name="gender"
value="${patient.gender}">
<br><br>


진료과 :
<input type="text" name="department"
value="${patient.department}">
<br><br>


<button type="submit">
수정 완료
</button>


</form>


</body>
</html>