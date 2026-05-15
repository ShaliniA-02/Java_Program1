<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Form</title>

<script>
function validate(){
var f=document.forms["studentForm"];

if(f.rollno.value=="" || f.name.value==""){
alert("Roll No and Name required");
return false;
}

var subs=["sub1","sub2","sub3","sub4","sub5"];

for(var i=0;i<subs.length;i++){
var m=f[subs[i]].value;
if(m=="" || isNaN(m) || m<0 || m>100){
alert("Enter valid marks between 0 and 100");
return false;
}
}
return true;
}
</script>
</head>

<body>
<h2>Student Marks Entry</h2>

<form name="studentForm" action="ResultServlet" method="post" onsubmit="return validate()">

Roll No: <input type="text" name="rollno"><br><br>
Name: <input type="text" name="name"><br><br>

Sub1: <input type="text" name="sub1"><br>
Sub2: <input type="text" name="sub2"><br>
Sub3: <input type="text" name="sub3"><br>
Sub4: <input type="text" name="sub4"><br>
Sub5: <input type="text" name="sub5"><br><br>

<input type="submit" value="Submit">

</form>
</body>
</html>