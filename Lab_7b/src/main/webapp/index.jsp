<html>
<head>
<title>Cookie Management</title>
</head>
<body>

<h2>Add Cookie</h2>

<form action="addCookie.jsp" method="post">
Name: <input type="text" name="name"><br><br>
Domain: <input type="text" name="domain"><br><br>
Max Expiry Age (sec): <input type="text" name="age"><br><br>
<input type="submit" value="Add Cookie">
</form>

<br><br>
<a href="viewCookies.jsp">Go to Active Cookie List</a>

</body>
</html>