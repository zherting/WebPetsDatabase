<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Lists</title>
</head>
<body>
	<form method="post" action="">
		<table>
			<c:forEach items="${requestScope.allBills}" var="currentbill">
				<tr>
					<td><input type="radio" name="id"
						value="${currentbill.billId}"></td></tr>
				<tr>
					<td colspan="3">Bill: ${currentbill.bill}</td>
				</tr>
				<tr> <td colspan="3">Pet Id: ${currentbill.id}</td></tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToItem"> <input
			type="submit" value="delete" name="doThisToItem"> <input
			type="submit" value="add" name="doThisToItem">
	</form>
	<a href="addItemsForListServlet">Create a new Bill</a>
	<a href="index.html">Insert a new pet</a>
</body>
</html>