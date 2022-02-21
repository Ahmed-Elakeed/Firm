<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 1/20/2021
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Employee</title>
    <link rel="stylesheet" type="text/css" href="css/InsertPropertyownedForm.css">
</head>
<body>
<form action="/Firm_war/InsertEmployee" method="post">
    <div class="container">
        <h1>Employee</h1>
        <p>Please Fill In this Form To Add Employee.</p>
        <hr>

        <label for="email"><b>Employee ID</b></label>
        <input type="number" placeholder="Enter Employee ID" name="emp_id" id="email" required>

        <label for="psw"><b>Employee Name</b></label>
        <input type="text" placeholder="Enter Employee Name" name="emp_name" id="psw" required>

        <label for="email"><b>Employee Office_Number</b></label>
        <input type="number" placeholder="Enter Employee Office_Number" name="emp_officeNumber" id="email1" required>

        <label for="psw"><b>Employee Email</b></label>
        <input type="text" placeholder="Enter Employee Email" name="emp_email" id="psw1" required>

        <label for="email"><b>Employee Password</b></label>
        <input type="password" placeholder="Enter Employee Password" name="emp_pass" id="email2" required>

        <label for="psw"><b>Confirm Employee Password</b></label>
        <input type="password" placeholder="Confirm Employee Password" name="emp_pass1" id="psw2" required>
        <hr>

        <button type="submit" class="registerbtn">Enter</button>
        <input id="hide" type="hidden" value="<%=request.getSession().getAttribute("name")%>">
    </div>
</form>
<script src="js/home.js"></script>
</body>
</html>
