<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Login</title>
</head>
<body>
<form action="logCustomer" method = "post">
	<h1>Customer Login Page</h1>
	<table>
		<tr>
			<td> <label for="tbEmail">Email:</label> </td>
			<td> <input type="email" name="tbEmail" id="tbEmail" value="<%=request.getParameter("tbCemail") %>"/> </td>
		</tr>
		<tr>
			<td> <label for="tbPass">Password:</label> </td>
			<td> <input type="password" name="tbPass" id="tbPass"  value="<%=request.getParameter("tbCpass") %>"/> </td>
		</tr>
		<tr>
			<td>  </td>
			<td> <input type="submit" value="Login" /> </td>
		</tr>
	</table>
</form>
	
</body>
</html>