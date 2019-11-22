<%@page import="com.cg.project.bean.Policy"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html lang="en">
<title>Quote Generation System</title>

<body>


<form method="post" action="adminTask.jsp">

<table border="2">
<tr>
<th>USER</th><th>ROLECODE</th></tr>
<c:forEach var="role" items="${roleList}">
<tr>
<td>${role.userName }</td>
<td>${role.roleCode }</td>
</tr>
</c:forEach><br><br>
</table>

<button type="submit">Back</button>
</form>
</body>
</html>

