<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
String name = (String) session.getAttribute("username");
%>
<html>
<body>
<%
if(name != null){
%>
<h2>Hello again <%= name %>!</h2>
<p>Your session is still active.</p>
<%
}else{
%>
<h2>Session expired!</h2>
<p>Please enter your name again.</p>
<a href="index.html">Go Back</a>
<%
}
%>
</body>
</html>