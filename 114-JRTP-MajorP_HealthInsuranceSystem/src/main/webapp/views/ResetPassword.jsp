<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
</head>
<script src="js/resetPwd.js"></script>
<body>

	<div align="center">
	<h3 style="color: green">${PwdSent }</h3>
		<h3 style="color: red">${PwdNotSent }</h3>
		<form:form action="resetPassword" modelAttribute="PwdModel"
			method="POST" name="PwdResetForm">
			<table>
				<caption style="color: Grey">Password Recovery</caption>
				<thead>
					<tr>
						<th><h5 style="color: green">Enter registered email
								address</h5></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><form:input type="text" path="registeredEmail"></form:input></td>
					</tr>
					<tr>
						<td><input type="submit" value="Submit" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<h3>
			<a href="userLogin">Back to Login Page</a>
		</h3>
	</div>
</body>
</html>