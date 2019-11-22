<%@page import="com.cg.project.bean.Policy"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <!DOCTYPE html>
<html lang="en">
<title>Quote Generation System</title>

<form method="post" action="policy.jsp">
<c:forEach var="viewPol" items="${policies}">
<p>Policy No => ${viewPol.policyNumber }&nbsp;&nbsp;
Proposed Premium => ${viewPol.policyPremium }&nbsp;&nbsp;
Account No => ${viewPol.accountNumber }</p>
</c:forEach><br><br>
<button type="submit">BACK</button><center>
</body>
</html>

