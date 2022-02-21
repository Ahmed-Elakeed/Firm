<%@ page import="domain.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 1/20/2021
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
    <link rel="stylesheet" type="text/css" href="css/PropertyOwnedTopNav.css">
    <link rel="stylesheet" type="text/css" href="css/data.css">
</head>
<body>
<div id="del" class="topnav">
    <a href="home.jsp">Back</a>
    <a href="insertEmployee.jsp">Insert Employee</a>
    <div class="delete-container">
        <form action="/Firm_war/Employees" method="post">
            <input type="number" placeholder="Delete Employee By ID" name="emp_id" required>
            <input id="manager" type="number" placeholder="New Manager If Needed" name="manager_id" required>
            <button type="submit">Delete</button>
            <input id="hide" type="hidden" value="<%=request.getSession().getAttribute("name")%>">
            <input id="hide1" type="hidden" value="<%=request.getSession().getAttribute("degree")%>">
        </form>
    </div>
</div>
<table id="dataTable">
    <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Employee Office_Number</th>
        <th>Employee Email</th>
    </tr>
    <% List<Employee> list=(List<Employee>) request.getAttribute("data");
        for(Employee employee:list){%>
    <tr>
        <td><%=employee.getEmp_id()%></td>
        <td><%=employee.getEmp_name()%></td>
        <td><%=employee.getOffice_num()%></td>
        <td><%=employee.getEmp_email()%></td>
    </tr>
    <%}%>
</table>
<script src="js/employee.js"></script>
</body>
</html>
