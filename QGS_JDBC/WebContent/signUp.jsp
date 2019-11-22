<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<title>Quote Generation System</title>
<meta charset="UTF-8">

<body>
 <form method="post" action="createUser.qgs">
  <h1><b> Enter your details</b></h1> <br><br><br>
    Create Username <input type="text" name = "username" required pattern="[a-zA-Z][a-zA-Z0-9-_.]{6,}" maxlength= "20"><br><br>
   Create Password <input type="text" name = "password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" maxlength= "12"><br><br>
    <button type="submit"> SUBMIT </button></div>
</body>
</html>


