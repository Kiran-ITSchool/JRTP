<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
</head>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">

<script>
	$(document).ready(function() {
		$('#myUsers').DataTable({
			"pagingType" : "full_numbers"
		});
		$('#idRole').on('change', function() {
             this.form.submit();
         });
	});
</script>

<style>
table, tr, th, td {
	boder: 2px;
	border-collapse: collapse;
	background-color: lightgreen;
	padding: 10px;
	text-align: center;
	background-color: lightgray;
}
</style>




<body>
	<div align="center">
		<form action="displayAllUsers" method="GET">
			<table>
				<tr>
					<td>Select Role :</td>
					<td><select name="role" id="idRole">
							<option value="">- select -</option>
							<option value="caseworker">Case Worker</option>
							<option value="admin">Admin</option>
					</select></td>
				</tr>
			</table>

		</form>

		<form:form modelAttribute="users" method="GET">
			<h1 style="color: green">${deleteSuccess }</h1>
			<h1 style="color: red">${deleteFailed }</h1>

			<table border="1" id="myUsers">
				<thead>

					<tr>
						<th colspan="7"><h2 style="color: navy;">All Users</h2></th>
					</tr>


					<tr>
						<th><h3 style="color: darkgreen">S.No.</h3></th>
						<th><h3 style="color: darkgreen">First name</h3></th>
						<th><h3 style="color: darkgreen">Last name</h3></th>
						<th><h3 style="color: darkgreen">Email</h3></th>
						<th><h3 style="color: darkgreen">Role</h3></th>
						<th><h3 style="color: blue">Action</h3></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users }" var="user" varStatus="index">
						<tr>
							<th>${index.count}</th>
							<th>${user.firstName}</th>
							<th>${user.lastName}</th>
							<th>${user.userEmail}</th>
							<th>${user.userRole}</th>
							<th><a href="editUser?userId=${user.userId}">EDIT</a> &nbsp;
								&nbsp; | &nbsp; &nbsp; <c:if test="${user.deleteSwitch eq 'Y' }">
									<a href="deleteUser?userId=${user.userId}"
										onclick="
							return confirm('Are you sure, you want to activate - ${user.firstName}?');">
										Activate</a>

								</c:if> <c:if test="${user.deleteSwitch eq 'N' }">
									<a href="deleteUser?userId=${user.userId}"
										onclick="
							return confirm('Are you sure, you want to delete - ${user.firstName}?');">
										Delete</a>
								</c:if></th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form:form>
	</div>
</body>
</html>