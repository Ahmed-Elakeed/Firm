<%@ page import="domain.Owner" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 1/20/2021
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Owners</title>
    <link rel="stylesheet" type="text/css" href="css/PropertyOwnedTopNav.css">
    <link rel="stylesheet" type="text/css" href="css/data.css">
</head>
<body>
<div class="topnav">
    <a href="home.jsp">Back</a>
    <a href="insertOwner.jsp">Insert Owner</a>
    <div class="delete-container">
        <form action="/Firm_war/Owners" method="post">
            <input type="number" placeholder="Delete Owner By ID" name="owner_id" required>
            <button type="submit">Delete</button>
            <input id="hide" type="hidden" value="<%=request.getSession().getAttribute("name")%>">
        </form>
    </div>
</div>
<table id="dataTable">
    <tr>
        <th>Owner ID</th>
        <th>Owner Name</th>
    </tr>
    <% List<Owner> list=(List<Owner>) request.getAttribute("data");
        for(Owner owner:list){%>
    <tr>
        <td><%=owner.getID()%></td>
        <td><%=owner.getName()%></td>
    </tr>
    <%}%>
</table>
<script src="js/home.js"></script>
</body>
</html>
