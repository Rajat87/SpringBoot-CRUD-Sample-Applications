<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%=request.getAttribute("List") %> Added   
		
	<form action="Product" method="post">
<label>Enter the Product name
<input type="text" name="name"></label><br></br>
<label>Enter the Product Price
<input type="text" name="price"></label><br></br>
<input type="submit">

</form>

	

	
</body>
</html>