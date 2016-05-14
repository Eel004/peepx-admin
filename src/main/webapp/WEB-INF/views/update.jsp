<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url var="contextPath" value="pageContext.request.contextPath"/>
<link rel="stylesheet" href="resources/js/jqueryCalendar.css"/>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.8.15.custom.min.js"></script>
	<script type="text/javascript">
		$(function() {
		    $("#birthDate").datepicker({
		    	dateFormat:"yy-mm-dd",
		    	changeYear:true,
		    	changeMonth:true
		    });
		    $("#birthDate").keydown(function(e) {
		            if (e.keyCode === 8) {
		                    return false;
		            } else {
		                    return false;
		            }
		    });
		});
	</script>
	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			border: 1px solid #aaa;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
			border: 1px solid #aaa;
		}
	</style>
	<title>Home</title>
</head>
<body>
	<form:form method="POST" action="../doUpdate/${player.playerId}" commandName="player">
		<table cellspacing="10">
			<tr>
				<th colspan="2">Update Employee here</th>
			</tr>
			<tr>
				<td>Player ID</td>
				<td><input type="text" name="playerId" value="${player.playerId}" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>Team ID</td>
				<td><input type="text" name="teamId" value="${player.teamId}"/></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" value="${player.firstName}"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" value="${player.lastName}"/></td>
			</tr>
			<tr>
				<td>Position</td>
				<td><input type="text" name="position" value="${player.position}"/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" value="${player.address}"/></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phoneNo" value="${player.phoneNo}"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="${player.email}"/></td>
			</tr>
			<tr>
				<td>Birthday</td>
				<td>
					<input type="text" name="birthDate" id="birthDate" value="${player.birthDate}"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Update" name="doUpdate"/>
				</td>
			</tr>
		</table>
		</form:form>
</body>
</html>