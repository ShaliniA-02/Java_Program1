<%@ page import="javax.servlet.http.*" %>
<html>
<head>
<title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
Cookie[] cookies = request.getCookies();

if(cookies != null){
    for(Cookie c : cookies){
        out.println("<p>Name: " + c.getName() + "</p>");
        out.println("<p>Value: " + c.getValue() + "</p>");
        out.println("<hr>");
    }
}else{
    out.println("<p>No Cookies Found</p>");
}
%>

<br>
<a href="index_7b.jsp">Go Back</a>

</body>
</html>