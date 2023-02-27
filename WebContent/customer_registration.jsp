<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration</title>
</head>
<body>
	<h1>Customer Registration Page</h1>
	<form action="regCustomer" method="post">
		<table>
			<tr>
				<td> Name: </td>
				<td> <input type="text" name="tbCname" id="tbCname" placeholder="Enter Name"/> </td>
			</tr>
			<tr>
				<td> Email: </td>
				<td> <input type="email" name="tbCemail" id="tbCemail" placeholder="Enter Email"/> </td>
			</tr>
			<tr>
				<td> Mobile Number: </td>
				<td> <input type="tel" name="tbMob" id="tbMob" placeholder="Enter Mobile Number"/> </td>
			</tr>
			<tr>
				<td> Password: </td>
				<td> <input type="password" name="tbCpass" id="tbCpass" placeholder="Enter Password"/> </td>
			</tr>
			<tr>
				<td> State: </td>
				<td> <select name="ddlStates"/> 
					 <option>---Select---</option>
					 <option value="Karnataka">KA</option>
					 <option value="Tamil Nadu">TN</option>
					 <option value="Andra Pradesh">AP</option>
					 <option value="Kerala">KL</option>
					 <option value="Maharastra">MH</option>
					 <option value="West Bengal">WB</option>
					 </select> </td>
			</tr>
			<tr>
				<td>  </td>
				<td> <input type="submit" value="Register" /> </td>
			</tr>
		</table>
	</form>

</body>
</html>