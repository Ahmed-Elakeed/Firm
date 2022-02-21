<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Insert Property Owned</title>
    <link rel="stylesheet" type="text/css" href="css/InsertPropertyownedForm.css">
</head>
<body>
<form action="/Firm_war/InsertPropertyOwned" method="post">
    <div class="container">
        <h1>Property Owned</h1>
        <p>Please Fill In this Form To Add a Property Owned.</p>
        <hr>

        <label for="email"><b>Owner ID</b></label>
        <input type="number" placeholder="Enter Owner ID" name="owner_id" id="email" required>

        <label for="psw"><b>Property ID</b></label>
        <input type="number" placeholder="Enter Property ID" name="prop_id" id="psw" required>

        <label for="psw-repeat"><b>Percent Owned</b></label>
        <input type="number" placeholder="Enter Percent Owned %" name="percent_owned" id="psw-repeat" required>
        <hr>

        <button type="submit" class="registerbtn">Enter</button>
        <input id="hide" type="hidden" value="<%=request.getSession().getAttribute("name")%>">
    </div>
</form>
<script src="js/home.js"></script>
</body>
</html>