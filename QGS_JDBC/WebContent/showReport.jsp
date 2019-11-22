<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="com.cg.project.bean.Report"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     


<!DOCTYPE html>
<html lang="en">
<title>Quote Generation System</title>
<meta charset="UTF-8">

<body>
<%
Report report = (Report)request.getAttribute("repList");
double policyNo = (double)request.getAttribute("policyNo1");
%>
<form method="post" action="policy.jsp">
<br><h2>INSURED NAME => <%=report.getInsuredName() %></h2><br>
<br><h2>INSURED STREET => <%=report.getInsuredStreet() %></h2><br>
<br><h2>INSURED CITY => <%=report.getInsuredCity() %></h2><br>
<br><h2>INSURED STATE => <%=report.getInsuredState() %></h2><br>
<br><h2>INSURED PINCODE => <%=report.getInsuredZip() %></h2><br>
<br><h2>BUSINESS SEGMENT => <%=report.getBusinessSegment() %></h2><br>
<br><h2>POLICY NO => <%=policyNo %></h2><br>
<br><h2>PROPOSED PREMIUM => <%=report.getPolicyPremium() %></h2><br>
<button type="submit">THANK YOU</button>
</form>
</body>
</html>

