<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proceed</title>
</head>
<body>
	<%
		out.println("Welcome "+session.getAttribute("name")+", You have logged in successfully");
	%>
	<br/><br/>
	<table>
	<tr>
		<td><a href="Balance">Check Balance</a></td>
	</tr>
	<tr>
		<td><a href="transfer.jsp">Fund Transfer</a></td>
	</tr>
	<tr>
		<td><a href="">Change Password</a></td>
	</tr>
	<tr>
		<td><a href="">Apply for a Loan</a></td>
	</tr>
	<tr>
		<td><a href="">Get Statement</a></td>
	</tr>
	<tr>
		<td><a href="">LogOut</a></td>
	</tr>
	</table>
</body>
</html>