<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To Do List</title>
</head>
<body>
<form action="todo-listjsp.jsp" method="get">
<label>Enter Item Name: </label>
<input name="Item" type="text"> <br></br>
<input type="submit" name="Submit">

</form><br></br>
Item Entered <%= request.getParameter("Item") %><br></br>

<%
        // get the TO DO items from the session
        List<String> items = (List<String>) session.getAttribute("myToDoList");
%>

<%
if (items == null) {
    items = new ArrayList<String>();
    session.setAttribute("myToDoList", items);
}
%>
<% 
    String theItem = request.getParameter("Item");
        if (theItem != null) {
            items.add(theItem);
        }
    %>
        
 <hr>
    <b>To List Items:</b> <br/>
    <ol>
    <%
        for (String temp : items) {
            out.println("<li>" + temp + "</li>");
        }
    %>
    </ol>       



</body>
</html>