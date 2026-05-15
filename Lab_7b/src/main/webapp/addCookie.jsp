<%@ page import="javax.servlet.http.*" %>
<html>
<head>
<title>Cookie Added</title>
</head>
<body>

<%
String name = request.getParameter("name");
String domain = request.getParameter("domain");
String ageStr = request.getParameter("age");

try{
    int age = Integer.parseInt(ageStr);

    Cookie c = new Cookie(name, domain);
    c.setMaxAge(age);

    response.addCookie(c);

    out.println("<h2>Cookie Added Successfully</h2>");
    out.println("<p>Name: " + name + "</p>");
    out.println("<p>Domain: " + domain + "</p>");
    out.println("<p>Max Age: " + age + " seconds</p>");

}catch(Exception e){
    out.println("<h3 style='color:red;'>Invalid Input</h3>");
}
%>

<br><br>
<a href="index_7b.jsp">Add Another Cookie</a><br>
<a href="viewCookies.jsp">Go to Active Cookie List</a>

</body>
</html>