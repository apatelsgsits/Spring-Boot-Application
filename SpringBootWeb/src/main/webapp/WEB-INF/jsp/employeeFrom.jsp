<html>
<head>
    <title>spring boot form submit example</title>
</head>
<body>
<h2>Employee Details</h2>

<form method="post" action="saveDetails">  <!--  // saveDetails url mapping in EmployeeController -->
    Enter Name : <input type="text" name="employeeName"/><br>
    Enter Email Address: <input type="email" name="employeeEmail"><br>
    <input type="submit" value="Submit">
    
</form>
</body>
</html>