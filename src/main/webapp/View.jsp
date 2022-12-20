<%@page import="java.util.List"%>
<%@page import="com.bean.Bank"%>
<%@page import="com.dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All account details</title>
</head>
<body>
	<h1>All account details</h1>
	<%
	List<Bank> list = BankDao.getAccounts();
	session.setAttribute("account", list);
	%>

	<table border="2">
		<tr>
			<th>Account Id</th>
			<th>Account NO</th>
			<th>Name</th>
			<th>Address</th>
			<th>IFSC code</th>
			<th>Operations</th>
		</tr>

		<c:forEach items="${account }" var="l">
			<tr>
				<td>${l.id }</td>
				<td>${l.acc_no }</td>
				<td>${l.name }</td>
				<td>${l.address }</td>
				<td>${l.ifsc }</td>

				<td><a href="UpdateAccount?id=${l.id }">update</a></td>
				<td><a href="DeleteAccount?id=${l.id }">delete</a></td>
		</c:forEach>
	</table>
	<br>
	<b>To create new account</b>
	<a href="LoginBank.jsp">click here</a>
</body>
</html>