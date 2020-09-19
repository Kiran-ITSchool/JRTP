<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
<link rel="stylesheet" href="css/style.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
</head>

<style>
table, tr, th, td {
	boder: 2px;
	border-collapse: collapse;
	background-color: lightgreen;
	padding: 10px;
	text-align: center;
}
</style>
<!-- form-validation -->
<script src="js/user-register-form-validations.js"></script>


<body>
	<div align="center">
		<h2 style="color: darkgreen">${savedMsg }</h2>
		<h2 style="color: red">${failedMsg }</h2>
		<h2 style="color: darkgreen">${updateMsg }</h2>
		<h2 style="color: red">${updateFailMsg }</h2>
		<form:form action="createUser" method="POST"
			modelAttribute="UserModel" name="userForm">
			<table>
				<form:hidden path="userId" />
				<thead>
					<tr>
						<th colspan="2"><h2 style="color: darkblue">Edit User</h2></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>First Name :</th>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<th>Last Name :</th>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<th>Email Address :</th>
						<td><form:input path="userEmail"/></td>
					</tr>
					<tr>
						<th>Gender :</th>
						<td><form:radiobutton path="userGender" value="M" id="gender" />Male
							<form:radiobutton path="userGender" value="F" />Female</td>
					</tr>
					<tr>
						<th>Role :</th>
						<td><form:select path="userRole">
								<form:option value=""> -select- </form:option>
								<form:option value="CaseWorker"> Case Worker</form:option>
								<form:option value="Admin"> Admin </form:option>
							</form:select></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Update"></td>
					</tr>
					<tr>
						<td colspan="2"><h2>
								<a href="displayAllUsers?role=casewroker"> View All Users</a>
							</h2></td>
					</tr>
					
				</tbody>
			</table>

		</form:form>
	</div>
</body>
</html>