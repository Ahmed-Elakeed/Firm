<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 1/18/2021
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
<div class="topnav">
    <a class="active">Welcome <%=request.getSession().getAttribute("name")%></a>
    <a id="logout" href="/Firm_war/Logout">Logout</a>
</div>
<div id="con" class="content">
    <a href="/Firm_war/Employees"><h1>Employees</h1></a>
    <a href="/Firm_war/SalesOffices"><h1>Sales Offices</h1></a>
    <a href="/Firm_war/Owners"><h1>Owners</h1></a>
    <a href="/Firm_war/Properties"><h1>Properties</h1></a>
    <a href="/Firm_war/PropertyOwned"><h1>Properties Owned</h1></a>
    <a href="changePassword.jsp"><h1>Change Password</h1></a>
    <input id="hide" type="hidden" value="<%=request.getSession().getAttribute("name")%>">
</div>
<script src="js/home.js"></script>
</body>
</html>
