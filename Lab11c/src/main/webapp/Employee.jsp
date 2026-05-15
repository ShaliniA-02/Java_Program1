<%@ page import="java.util.*, com.dao.EmpDAO, com.model.Emp" %>

<%
    EmpDAO dao = new EmpDAO();
    List<Emp> list = dao.getAllEmployees();
%>

<html>
<head>
    <title>Salary Report</title>
</head>

<body>

<h2>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h2>
<h2>Salary Report</h2>
<h2>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h2>

<%
    for(Emp e : list) {
%>

<p>Emp_No : <%= e.getEmpNo() %></p>
<p>Emp_Name: <%= e.getEmpName() %></p>
<p>Basic   : <%= e.getBasicSalary() %></p>

<h2>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h2>

<%
    }
%>

</body>
</html>