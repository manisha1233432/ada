<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<title>Quote Generation System</title>
<meta charset="UTF-8">
<body>
<h1 style="text-align: center"><b> Account Creation</b></h1>
<form method="post" action="createAccount.qgs">
 <h1 style="text-align: center; color:blue"><b> Create Your Account</b></h1> <br><br>
    Insured Name <input type="text" name = "insuredName" required/><br> <br>
           Insured Street <input type="text" name = "insuredStreet" required><br><br>
           Insured City <input type="text" name = "insuredCity" required><br><br>
           Insured State <input type="text" name = "insuredState" required><br><br>
           Insured Zip <input type="number" name = "insuredZip" maxlength="5" required><br><br>
           Profession/Business <input type="text" name = "businessSeg" required><br><br>
           Agent Name  <input type="text" name = "agentUser" required><br><br>
           Username <input type="text" name = "userName" required pattern="[a-zA-Z][a-zA-Z0-9-_.]{6,}" maxlength= "20"><br><br>
			
  <button type="submit"> SUBMIT</button></div>
 </body>
</html>

