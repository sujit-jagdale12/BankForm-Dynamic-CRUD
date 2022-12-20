<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login into the bank</title>
</head>
<body>
	<form action="CreateAccount" method="post" align="center">
		<h2>Welcome to HOD Bank</h2>
		<table align="center">
			<tr>
				<td size="2">A/c No:</td>
				<td><input type="text" name="acc_no"
					placeholder="Your A/c no..."></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"
					placeholder="Enter name #sujit"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"
					placeholder="address,street"></td>
			</tr>
			<tr>
				<td>IFSC code</td>
				<td><input type="text" name="ifsc"
					placeholder="Ifsc: ##0000..."></td>
			</tr>
			<tr><td><button>Save</button></td></tr>
		</table>
		<a href="View.jsp">View Accounts</a>
	</form>
</body>
</html>