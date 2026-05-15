<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
String name = request.getParameter("username");
session.setAttribute("username", name);
session.setMaxInactiveInterval(60);
%>
<html>
<body>
<h2>Hello <%= name %>!</h2>
<p>Session will expire in 1 minute.</p>
<a href="check.jsp">Click here to check session</a>
</body>
</html>