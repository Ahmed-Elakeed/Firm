<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 1/20/2021
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Property</title>
    <link rel="stylesheet" type="text/css" href="css/InsertPropertyownedForm.css">
</head>
<body>
<form action="/Firm_war/InsertProperty" method="post">
    <div class="container">
        <h1>Property</h1>
        <p>Please Fill In this Form To Add Property.</p>
        <hr>

        <label for="email"><b>Property ID</b></label>
        <input type="number" placeholder="Enter Property ID" name="prop_id" id="email" required>

        <label for="psw"><b>Property Address</b></label>
        <input type="text" placeholder="Enter Property Address" name="prop_address" id="psw" required>

        <label for="email"><b>Property City</b></label>
        <input type="text" placeholder="Enter Property City" name="prop_city" id="email1" required>

        <label for="psw"><b>Property State</b></label>
        <input type="text" placeholder="Enter Property State" name="prop_state" id="psw1" required>

        <label for="email"><b>Property Zip_Code</b></label>
        <input type="text" placeholder="Enter Property Zip_Code" name="prop_zipCode" id="email2" required>

        <label for="psw"><b>Property Office_Num</b></label>
        <input type="number" placeholder="Enter Property Office_Num" name="prop_officeNum" id="psw2" required>
        <hr>

        <button type="submit" class="registerbtn">Enter</button>
        <input id="hide" type="hidden" value="<%=request.getSession().getAttribute("name")%>">
    </div>
</form>
<script src="js/home.js"></script>

</body>
</html>
