<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Execution</title>
</head>
<body>

<%-- Web Browsee <%= request.getHeader("User-agent") %> <br></br>
<jsp:include page="include.jsp"></jsp:include><br></br> --%>

Student's Name is: <%=request.getParameter("firstName") %> 
<%=request.getParameter("lastName") %><br></br> 
Country is :<%=request.getParameter("country") %><br></br>
Favorite Programming Languages are:
<ul>
 <%
String[] lRef = request.getParameterValues("Languages");
for(String s :lRef){
	out.println("<li>"+s+"</li>");
}
%>
</ul>
<%-- Alternate Way --%>
<%-- Getting Information ${param.firstName} ${param.LastName}--%>
</body>
</html>