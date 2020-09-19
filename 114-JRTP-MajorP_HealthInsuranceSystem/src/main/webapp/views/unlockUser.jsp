<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unlock your account</title>
</head>

<style>
table, tr, th, td {
	boder: 2px;
	border-collapse: collapse;
	background-color: lightblue;
	padding: 10px;
	text-align: center;
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
	function validatePwds() {
		var newPwd = $('#newPwd').val();
		var confirmPwd = $('#confirmPwd').val();
		var tempPswd= $('#tempPswd').val();

		$('#errId2').text('');
		$('#errId3').text('');
		$('#errId').text('');
		
		if(tempPswd == ''){
			$('#errId2').text('* Temp password is empty!');
			return false;
		}
		if (newPwd == '') {
			$('#errId3').text('* New password is empty');
			return false;
		}
		if (newPwd != confirmPwd) {
			$('#errId').text('* Passwords not equal');
			return false;
		}
		return true;
	}
</script>


<body>
	<div align="center">
		<form:form action="unlockWithNewPwd" modelAttribute="unlockModel" method="POST">
			<table>
				<thead>
					<tr>
						<th colspan="2"><h3 style="color: darkgreen">Unlock
								your account</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>Your Email ID :</th>
						<td>${email }</td>
					</tr>
					<tr>
						<th>Temporary password :</th>
						<td><form:input path="tempPazzword" id="tempPswd"/><br/><font
							color='red'><span id="errId2"></span></font></td>
					</tr>
					<tr>
						<th>New password :</th>
						<td><form:password path="newPazzword" id="newPwd" /><br/><font
							color='red'><span id="errId3"></span></font></td>

					</tr>
					<tr>
						<th>Confirm password :</th>
						<td><form:password path="confirmPazzword" id="confirmPwd" /><br/><font
							color='red'><span id="errId"></span></font></td>

					</tr>
					<tr>
						<th><input type="reset" value="Reset" /></th>
						<td><input type="submit" value="Submit"
							onclick="javascript:return validatePwds()" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>

</body>
</html>