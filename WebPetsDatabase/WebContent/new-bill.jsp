<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new bill</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
Bill: <input type = "text" name = "bill"><br />
Pet: <input type = "text" name = "Id"><br />

Available Items: <br />
<select name="allInfoToAdd" multiple size = "6">
<c:forEach items = "${requestScope.allItems}" var="currentitem">
<option value = "${currentitem.id}">${currentitem.name}|$currentitem.type}|${currentitem.owner}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value = "Create Bill and Add Info">

</form>
</body>
</html>