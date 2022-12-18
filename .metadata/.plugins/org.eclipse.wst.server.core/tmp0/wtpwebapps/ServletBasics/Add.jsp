<%@ page import="java.util.* , java.lang.*" %>   <!-- this is an import statement using directive in JSP-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="Cyan">

<!--Scriptlet - Any java code goes here  -->
<%     
// Java code goes here
	int a = Integer.parseInt(request.getParameter("FirstNumber"));  // The request and response object are provided implicityly in JSP
	int b = Integer.parseInt(request.getParameter("SecondNumber"));
	int k=a+b;
	out.println(k);  // Print writer is also provided by JSP

%>


<%= "This will actually print on the HTML page using a Print writer"  %>  <!-- This is called an expression  -->
<%! int a; %> <!-- This is called a declarative and will create this a as an instance variable in the servlet class -->  

</body>
</html>