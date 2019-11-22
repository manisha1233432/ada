<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<title>Quote Generation System</title>
<meta charset="UTF-8">

<body>
<form method="post" action="agentTask.jsp">
<%
List<String> list = (List)request.getAttribute("agentNameList");
for(int i = 0; i<list.size(); i++){%>
<h1><%=list.get(i) %></h1>
<% 
}
%>
<button type="submit">Back</button>
</form></center>
</body>
</html>

