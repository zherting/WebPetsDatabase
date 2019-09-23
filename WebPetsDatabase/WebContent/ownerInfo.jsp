<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner Information</title>
</head>
<body>
<table>
<c:forEach items="{requestScopre.allItems}" var="currentitem">
<tr>
   <td><input type="radio" name="id" value="${currentitem.id}"></td>
<td>${currentitem.type}</td>
<td>${currentitem.name}</td>
<td>${currentitem.owner}</td>
</tr>
</c:forEach>
</table>

</body>
</html>