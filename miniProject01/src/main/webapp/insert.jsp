<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환자 등록</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>환자 등록</h2>

<form action="insert" method="post">

환자번호
<input type="number" name="patientId"><br><br>

이름
<input type="text" name="name"><br><br>

나이
<input type="number" name="age"><br><br>

주민번호
주민번호
<input type="text"
       name="ssn"
       maxlength="14"
       oninput="formatSSN(this)"><br><br>

보호자번호
<input type="text"
       name="pssn"
       maxlength="14"
       oninput="formatSSN(this)"><br><br>

성별
<select name="gender">

    <option value="M">남(M)</option>

    <option value="F">여(F)</option>

</select>

<br><br>

진료과
<select name="department">

    <option value="내과">내과</option>
    <option value="치과">치과</option>
    <option value="방사선과">방사선과</option>
    <option value="외과">외과</option>
    <option value="성형외과">성형외과</option>
    <option value="안과">안과</option>
    <option value="산부인과">산부인과</option>
    <option value="비뇨기과">비뇨기과</option>

</select>

<br><br>

<input type="submit" value="등록">

</form>
<script>
function formatSSN(input){

    let value = input.value.replace(/[^0-9]/g, "");

    if(value.length > 6){
        value = value.substring(0,6) + "-" + value.substring(6,13);
    }

    input.value = value;
}
</script>
</body>
</html>