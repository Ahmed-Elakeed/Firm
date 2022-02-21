<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
    <link rel="stylesheet" type="text/css" href="css/changePassword.css">
</head>
<body>
<form action="/Firm_war/ChangePassword" method="post">
    <div class="container">
        <h1>Change Password</h1>
        <hr>

        <label for="email"><b>Old Password</b></label>
        <input type="password" placeholder="Old Password" name="old_pass" id="email" required>

        <label for="psw"><b>New Password</b></label>
        <input type="password" placeholder="New Password" name="new_pass1" id="psw" required>

        <label for="psw-repeat"><b>Confirm New Password</b></label>
        <input type="password" placeholder="New Password" name="new_pass2" id="psw-repeat" required>
        <hr>

        <button type="submit" class="registerbtn">Change</button>
        <input id="hide" type="hidden" value="<%=request.getSession().getAttribute("name")%>">
    </div>
</form>
<script src="js/home.js"></script>
</body>
</html>