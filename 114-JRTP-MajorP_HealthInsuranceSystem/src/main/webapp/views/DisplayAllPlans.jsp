<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Plans</title>
</head>

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
		<form:form modelAttribute="plans" method="GET">
			<h1 style="color: green">${deleteSuccess }</h1>
			<h1 style="color: red">${deleteFailed }</h1>
			<table border="1" id="myPlans">
				<thead>

					<tr>
						<th colspan="7"><h2 style="color: navy;">All Plans</h2></th>
					</tr>


					<tr>
						<th><h3 style="color: darkgreen">S.No.</h3></th>
						<th><h3 style="color: darkgreen">Plan Name</h3></th>
						<th><h3 style="color: darkgreen">Plan Description</h3></th>
						<th><h3 style="color: darkgreen">Plan Start Date</h3></th>
						<th><h3 style="color: darkgreen">Plan End Date</h3></th>
						<th colspan="2"><h3 style="color: blue">Action</h3></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${plans }" var="plan" varStatus="index">
						<tr>
							<th>${index.count}</th>
							<th>${plan.planName}</th>
							<th>${plan.planDesc}</th>
							<th>${plan.startDate}</th>
							<th>${plan.endDate}</th>
							<th><a href="editPlan?planId=${plan.planId}">EDIT</a>
							</th>
							<th>
							<c:if test="${plan.activatedSwitch eq 'Y' }">
									<a href="deletePlan?planId=${plan.planId}"
										onclick="
							return confirm('Are you sure, you want to activate - ${plan.planName}?');">
									Activate</a>
									
							</c:if> 
							
							<c:if test="${plan.activatedSwitch eq 'N' }">
									<a href="deletePlan?planId=${plan.planId}"
										onclick="
							return confirm('Are you sure, you want to delete - ${plan.planName}?');">
									Delete</a>
							</c:if>
							</th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form:form>
		
		
		<c:if test="${cpn > 1 }">
			<a href="displayAllPlans?pno=${cpn-1}">Previous</a>
		</c:if>

		<c:forEach begin="1" end="${tp}" var="pno">
			<c:if test="${cpn == pno }">
		     ${pno}
		</c:if>
			<c:if test="${cpn != pno }">
				<a href="displayAllPlans?pno=${pno}">${pno}</a>
			</c:if>
		</c:forEach>

		<c:if test="${cpn < tp }">
			<a href="displayAllPlans?pno=${cpn+1}">Next</a>
		</c:if>
		
		
		
	</div>
</body>
</html>