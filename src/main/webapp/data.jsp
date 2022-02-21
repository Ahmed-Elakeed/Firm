<%@ page import="domain.PropertyOwned" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.DataClass" %><%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 1/17/2021
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Properties Owned</title>
    <link rel="stylesheet" type="text/css" href="css/data.css">
</head>
<body>
    <table id="dataTable">
        <tr>
            <th>Owner ID</th>
            <th>Owner Name</th>
            <th>Property ID</th>
            <th>Property Address</th>
            <th>Percent Owned</th>
        </tr>
    <% List<DataClass> list=(List<DataClass>) request.getAttribute("data");
        for(DataClass dataClass:list){%>
        <tr>
            <td><%=dataClass.getOwner_id()%></td>
            <td><%=dataClass.getOwner_name()%></td>
            <td><%=dataClass.getProp_id()%></td>
            <td><%=dataClass.getProp_address()%></td>
            <td><%=dataClass.getPercent_owned()%>%</td>
        </tr>
        <%}%>
    </table>
</body>
</html>
