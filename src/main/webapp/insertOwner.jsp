<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 1/20/2021
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Owner</title>
    <link rel="stylesheet" type="text/css" href="css/InsertPropertyownedForm.css">
</head>
<body>
<form action="/Firm_war/InsertOwner" method="post">
    <div class="container">
        <h1>Owner</h1>
        <p>Please Fill In this Form To Add Owner.</p>
        <hr>

        <label for="email"><b>Owner ID</b></label>
        <input type="number" placeholder="Enter Owner ID" name="owner_id" id="email" required>

        <label for="psw"><b>Owner Name</b></label>
        <input type="text" placeholder="Enter Owner Name" name="owner_name" id="psw" required>
        <hr>

        <button type="submit" class="registerbtn">Enter</button>
        <input id="hide" type="hidden" value="<%=request.getSession().getAttribute("name")%>">
    </div>
</form>
<script src="js/home.js"></script>
</body>
</html>
