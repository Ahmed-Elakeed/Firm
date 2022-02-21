<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 1/18/2021
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/PropertyOwnedTopNav.css">
</head>
<body>

<div class="topnav">
    <a href="home.jsp">Back</a>
    <a href="insertPropertyOwnedForm.jsp">Insert a Property Owned</a>
    <div class="delete-container">
        <form action="/Firm_war/PropertyOwned" method="post">
            <input type="number" placeholder="Delete Owner By ID" name="owner_id">
            <input type="number" placeholder="Delete Property By ID" name="prop_id">
            <button type="submit">Delete</button>
            <input id="hide" type="hidden" value="<%=request.getSession().getAttribute("name")%>">
        </form>
    </div>
</div>
<script src="js/home.js"></script>
</body>
</html>
