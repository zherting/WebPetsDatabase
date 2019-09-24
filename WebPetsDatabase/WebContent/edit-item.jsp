<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="editItemServlet" method="post">
		Name: <input type="text" name="name" value="${itemToEdit.name}">
		Type: <input type="text" name="type" value="${itemToEdit.type}">
		Owner: <input type="text" name="owner" value="${itemToEdit.owner}">
		<input type="hidden" name="id" value="${itemToEdit.id}"> <input
			type="submit" value="Save Edited Info">
	</form>
</body>
</html>