<%@ page import="com.dao.EmpDAO, com.model.Emp" %>

<%
    int empno = Integer.parseInt(request.getParameter("empno"));
    String empname = request.getParameter("empname");
    int salary = Integer.parseInt(request.getParameter("salary"));

    Emp e = new Emp();
    e.setEmpNo(empno);
    e.setEmpName(empname);
    e.setBasicSalary(salary);

    EmpDAO dao = new EmpDAO();
    dao.insertEmp(e);

    response.sendRedirect("index.jsp");
%>