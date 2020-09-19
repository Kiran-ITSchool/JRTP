<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>His Plan Edit</title>


<!-- date picker -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- <script>
$(function() {
	$("#pickStartDate").datepicker({
		altFormat : "dd/mm/yy",
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
		yearRange : '2000:2030'
	});
});
$(function() {
	$("#pickEndDate").datepicker({
		altFormat : "dd/mm/yy",
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
		yearRange : '2000:2030'
	});
});
</script> -->

<!-- plan-form-validations -->
<link rel="stylesheet" href="css/user-style.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>

</head>

<script src="js/plan-register-form-validations.js"></script>

<body>
<div align="center">
		<h2 style="color: darkgreen">${savedMsg }</h2>
		<h2 style="color: red">${failedMsg }</h2>
		<h2 style="color: darkgreen">${updateMsg }</h2>
		<h2 style="color: red">${updateFailMsg }</h2>
		<form:form action="createPlan" method="POST"
			modelAttribute="PlanModel" name="planForm">
			<table>
				<form:hidden path="planId" />
				<thead>
					<tr>
						<th colspan="2"><h2 style="color: darkblue">Update Plan</h2></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>Plan name :</th>
						<td><form:input path="planName" /></td>
					</tr>
					<tr>
						<th>Plan Description :</th>
						<td><form:input path="planDesc" /></td>
					</tr>
					<tr>
						<th>Start Date :</th>
						<td><form:input path="startDate" id="pickStartDate" /></td>
					</tr>
					<tr>
						<th>End Date :</th>
						<td><form:input path="endDate" id="pickEndDate" /></td>
					</tr>
					
					<tr>
						<td colspan="2"><input type="submit" value="Update"></td>
					</tr>
					<tr>
						<td colspan="2">
						<h2>
							<a href="displayAllPlans"> View Plans</a>
						</h2></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
</body>
</html>