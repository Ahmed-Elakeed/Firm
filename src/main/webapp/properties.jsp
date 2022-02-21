<%@ page import="domain.Property" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 1/20/2021
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Properties</title>
    <link rel="stylesheet" type="text/css" href="css/PropertyOwnedTopNav.css">
    <link rel="stylesheet" type="text/css" href="css/data.css">
</head>
<body>
<div class="topnav">
    <a href="home.jsp">Back</a>
    <a href="insertProperty.jsp">Insert Property</a>
    <div class="delete-container">
        <form action="/Firm_war/Properties" method="post">
            <input type="number" placeholder="Delete Property By ID" name="prop_id" required>
            <button type="submit">Delete</button>
            <input id="hide" type="hidden" value="<%=request.getSession().getAttribute("name")%>">
        </form>
    </div>
</div>
<table id="dataTable">
    <tr>
        <th>Property ID</th>
        <th>Property Address</th>
        <th>Property City</th>
        <th>Property State</th>
        <th>Property Zip_Code</th>
        <th>Property Office_Number</th>
    </tr>
    <% List<Property> list=(List<Property>) request.getAttribute("data");
        for(Property property:list){%>
    <tr>
        <td><%=property.getProp_id()%></td>
        <td><%=property.getAddress()%></td>
        <td><%=property.getCity()%></td>
        <td><%=property.getState()%></td>
        <td><%=property.getZip_code()%></td>
        <td><%=property.getOffice_num()%></td>
    </tr>
    <%}%>
</table>
<script src="js/home.js"></script>

</body>
</html>
