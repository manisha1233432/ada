
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    


<!DOCTYPE html>
<html lang="en">
<title>Quote Generation System</title>
<meta charset="UTF-8">

<body>
<form method="post" action="calWeightage.qgs">
<%int i = 0; %>

<c:forEach var="polq" items="${polquesList}">
${polq.polQuesDesc}<br><br>
<input type="hidden" value="${polq.polQuesDesc}" name="quesVal<%=(i+1)%>">
${polq.polQuesAns1}<input type="radio" value="${polq.polQuesAns1}" name="radio<%=++i %>" required="required">&nbsp;&nbsp;
${polq.polQuesAns2}<input type="radio" value="${polq.polQuesAns2}" name="radio<%=i %>" required="required">&nbsp;&nbsp;
${polq.polQuesAns3}<input type="radio" value="${polq.polQuesAns3}" name="radio<%=i %>" required="required">&nbsp;&nbsp;<br>
</c:forEach><br><br>
<input type="hidden" value=<%=i %> name="listSize">
<button type="submit">Submit</button>
</form>
</body>
</html>


