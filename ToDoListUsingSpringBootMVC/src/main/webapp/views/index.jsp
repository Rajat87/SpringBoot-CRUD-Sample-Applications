<%@page import="com.springboot.ToDoList.Model.ToDo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyToDoList</title>
</head>
<body>
<div>
<h1 >My Own To Do List using Spring Boot</h1>
</div>


<% List<ToDo> todos= (List<ToDo>)request.getAttribute("toDoList");
for(ToDo toDO : todos){
	response.getWriter().println(toDO.getSubject()+" : ");
	response.getWriter().println(toDO.getDescription());
}%>




<h1>Please Enter the details to add a To do item</h1>
<form action="addToDo" method="post">
	<label>Enter ID:</label>
	<input name="topicId" type="text"><br></br>
	<label>Enter Subject:</label>
	<input name="subject" type="text"><br></br>
	<label>Enter Description:</label>
	<input name="description" type="text"><br></br>
	<input type="submit">
	</form>
	
	<h1>Please Enter the details to update a To do item</h1>
	<form action="updateToDo" method="post">
	<label>Enter ID:</label>
	<input name="topicId" type="text"><br></br>
	<label>Enter Subject:</label>
	<input name="subject" type="text"><br></br>
	<label>Enter Description:</label>
	<input name="description" type="text"><br></br>
	<input type="submit">
	</form>
	
	<h1>Please Enter the details to delete a To do item</h1>
	<form action="deleteToDo" method="post">
	<label>Enter ID:</label>
	<input name="topicId" type="text"><br></br>
	<input type="submit">
	</form>
	

</body>
</html>