<%@ page import="domain.SalesOffice" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 1/21/2021
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sales Offices</title>
    <link rel="stylesheet" type="text/css" href="css/PropertyOwnedTopNav.css">
    <link rel="stylesheet" type="text/css" href="css/data.css">
</head>
<body>
<div id="del" class="topnav">
    <a href="home.jsp">Back</a>
    <a href="insertOffice.jsp">Insert Office</a>
    <div class="delete-container">
        <form action="/Firm_war/SalesOffices" method="post">
            <input type="number" placeholder="Delete Office By Number" name="office_num" required>
            <input type="number" placeholder="New Office Number" name="office_num1" required>
            <button type="submit">Delete</button>
            <input id="hide" type="hidden" value="<%=request.getSession().getAttribute("name")%>">
            <input id="hide1" type="hidden" value="<%=request.getSession().getAttribute("degree")%>">
        </form>
    </div>
</div>
<table id="dataTable">
    <tr>
        <th>Office Number</th>
        <th>Office Location</th>
        <th>Manager ID</th>
    </tr>
    <% List<SalesOffice> list=(List<SalesOffice>) request.getAttribute("data");
        for(SalesOffice salesOffice:list){%>
    <tr>
        <td><%=salesOffice.getOffice_num()%></td>
        <td><%=salesOffice.getOffice_location()%></td>
        <td><%=salesOffice.getManager_id()%></td>
    </tr>
    <%}%>
</table>
<script src="js/employee.js"></script>
</body>
</html>
