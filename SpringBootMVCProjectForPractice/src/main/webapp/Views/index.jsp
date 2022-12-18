<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo Spring Boot MVC App</title>
</head>
<body>

<h1>Please Enter the details to add a Student</h1>
<form action="/Student" method="post">
<label>Please Enter Student ID</label>
<input name=studentid type="text"><br></br>
<label>Please Enter Student Name</label>
<input name=studentName type="text"><br></br>
<label>Please Enter Student Marks</label>
<input name=studentMarks type="text"><br>
<input type="submit">
</form><br>


<h1>Please Enter the details to update a Student</h1>

<form action="/Student/update" method="post">
<label>Please Enter Student ID</label>
<input name=studentid type="text"><br></br>
<label>Please Enter Student Name</label>
<input name=studentName type="text"><br></br>
<label>Please Enter Student Marks</label>
<input name=studentMarks type="text"><br>
<input type="submit">
</form><br>


<h1>Please Enter the details to delete a Student</h1>

<form action="/Student/delete" method="post">
<label>Please Enter Student ID</label>
<input name=studentid type="number"><br></br>
<input type="submit">
</form><br>

${StudentList}<br>


</body>
</html>