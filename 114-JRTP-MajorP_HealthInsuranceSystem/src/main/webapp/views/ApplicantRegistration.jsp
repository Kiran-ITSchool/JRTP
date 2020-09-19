<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Register</title>


<!-- date picker -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- <script>
$(function() {
	$("#dobpicker").datepicker({
		altFormat : "dd/mm/yy",
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
		yearRange : '2000:2030'
	});
});
</script> -->

<!-- applicant-form-validations -->
<link rel="stylesheet" href="css/user-style.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>

</head>

<script src="js/applicant-form-validations.js"></script>

<body>
	<div align="center">
		<h2 style="color: darkgreen">${RegistrationSuccess }</h2>
		<h2 style="color: red">${RegistrationFailed }</h2>
		<h2 style="color: red">${InvalidSsn }</h2>
		<h2 style="color: red">${NotEligibleSsn }</h2>
		<form:form action="applicantRegister" method="POST"
			modelAttribute="ApplicantModel" name="applicantForm">
			<table>
				<form:hidden path="applicationNumber" />
				<thead>
					<tr>
						<th colspan="2"><h2 style="color: darkblue">New
								Applicant Registration</h2></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>First name :</th>
						<td><form:input path="applicantFirstName" /></td>
					</tr>
					<tr>
						<th>Last Name :</th>
						<td><form:input path="applicantLastName" /></td>
					</tr>
					<tr>
						<th>Date of birth :</th>
						<td><form:input path="applicantDob" id="dobpicker" /></td>
					</tr>
					<tr>
						<th>Gender :</th>
						<td><form:radiobutton path="applicantGender" value="M"
								id="gender" />Male <form:radiobutton path="applicantGender"
								value="F" />Female</td>
					</tr>
					<tr>
						<th>SSN :</th>
						<td><form:input path="applicantSsn" /></td>
					</tr>
					<tr>
						<th>Phone Number :</th>
						<td><form:input path="applicantPhoneNumber" /></td>
					</tr>
					<tr>
						<th>Email Id :</th>
						<td><form:input path="applicantEmail" /></td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit" value="Resgister"></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
</body>
</html>