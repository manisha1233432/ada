<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<title>Quote Generation System</title>
<body>
<%
List<String> agentList = (List<String>)request.getAttribute("agentList");
int size = agentList.size();
%>
<center>
<%
for(int i = 0; i<size; i++){%>
<h2>	<%=agentList.get(i)%></h2>
<%}
%>
<form method="post" action="adminTask.jsp">

<button type="submit">Back</button>
</form>
</body>
</html>

