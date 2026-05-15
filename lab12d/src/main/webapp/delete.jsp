<%@ page import="java.util.*, com.dao.EmpDAO, com.model.Emp" %>

<%
    char ch = request.getParameter("ch").charAt(0);

    EmpDAO dao = new EmpDAO();

    // DELETE FIRST
    dao.deleteByName(ch);

    // FETCH REMAINING
    List<Emp> list = dao.getAll();
%>

<html>
<head><title>Salary Report</title></head>

<body>

<h2>Salary Report</h2>

<h2>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h2>

<%
if(list.isEmpty()) {
%>
    <h3>No Records Found</h3>
<%
} else {
    for(Emp e : list) {
%>

<p>Emp_No : <%= e.getEmpNo() %></p>
<p>Emp_Name: <%= e.getEmpName() %></p>
<p>Basic   : <%= e.getBasicSalary() %></p>

<h2>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h2>

<%
    }
}
%>

</body>
</html>