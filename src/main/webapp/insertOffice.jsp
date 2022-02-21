<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 1/21/2021
  Time: 1:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Office</title>
    <link rel="stylesheet" type="text/css" href="css/InsertPropertyownedForm.css">
</head>
<body>

<form action="/Firm_war/InsertOffice" method="post">
    <div class="container">
        <h1>Sales Office</h1>
        <p>Please Fill In this Form To Add Office.</p>
        <hr>

        <label for="email"><b>Office Number</b></label>
        <input type="number" placeholder="Enter Office Number" name="office_num" id="email" required>

        <label for="psw"><b>Office Location</b></label>
        <input type="text" placeholder="Enter Office Location" name="office_location" id="psw" required>

        <label for="email"><b>Manager ID</b></label>
        <input type="number" placeholder="Enter Manager ID" name="manager_id" id="email1" required>
        <hr>

        <button type="submit" class="registerbtn">Enter</button>
        <input id="hide" type="hidden" value="<%=request.getSession().getAttribute("name")%>">
    </div>
</form>
<script src="js/home.js"></script>
</body>
</html>
