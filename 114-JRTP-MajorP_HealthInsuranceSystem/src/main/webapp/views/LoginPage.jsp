<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<body>
	<div align="center">
		<h1 style="color: white">HIS Login Page</h1>
		<hr />
	</div>
</body>

<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/plan-style.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script src="js/LoginValidations.js"></script>
</head>

<style>
table, tr, th, td {
	boder: 2px;
	border-collapse: collapse;
	background-color: lightgrey;
	padding: 10px;
	text-align: center;
}
</style>


<body>
	<div align="center">
		<h2>Welcome to Health Insurance System, Texas.</h2>
		<form:form action="userLogin" modelAttribute="loginModel"
			method="POST" name="LoginForm">
			<table>
				<thead>
					<tr>
						<td colspan="2">
							<h5 style="color: red">${loginFailed }</h5>
							<h5 style="color: red">${accountLocked }</h5>
							<h5 style="color: red">${AccountNotActive }</h5>
						</td>
					</tr>
					<tr>
						<th colspan="2">Login to your account</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>Email <br /></th>
						<td><form:input path="userEmail" /></td>
					</tr>
					<tr>
						<th>Password</th>
						<td><form:password path="userPassword" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Sign-in" /></td>
					</tr>
					<tr>
						<td colspan="2">Forgot password? <a href="resetPassword"><b><i>Reset here.</i></b></a></td>
					</tr>
				</tbody>
			</table>

		</form:form>

	</div>
</body>
<hr />
<!-- Site footer -->
<footer>
	<div align="center">
		<h1 style="color: white">Copyright &copy; 2020 All Rights
			Reserved by Legit Programmers</h1>
	</div>
</footer>
</html>