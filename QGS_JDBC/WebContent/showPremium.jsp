<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<title>Quote Generation System</title>
<meta charset="UTF-8">
<body>
<h1 style="text-align: center"><b> Premium</b></h1>
<%double premium = (double)request.getAttribute("premium");%>
<h2>Your Premium amount :  ${premium }</h2><br><br>
<form method="post" action="viewReport.qgs">
<button type="submit">View Report</button>
</form>
</body>
</html>

