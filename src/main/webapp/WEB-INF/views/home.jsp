<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<link rel="stylesheet" href="resources/js/jqueryCalendar.css"/>
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
<script type="text/javascript" src="resources/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.8.15.custom.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function() {
		    $("#birthDate").datepicker({
		    	dateFormat:"yy-mm-dd",
		    	changeYear:true,
		    	yearRange:"-100:+0",
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
		.form {
			
		}
		
	</style>
	<title>Home</title>
</head>
<body>
	<div class="container" style="margin: 100px auto">
	<form:form method="POST" action="add" commandName="player" class="form-horizontal" role="form" enctype="multipart/form-data">
			<div class="form-group">
				<label class="control-label col-sm-4" for="sel1">Team</label>
				<div class="col-sm-5">
					<form:select path="team" class="form-control" id="sel1">
						<%-- <c:forEach var="team" items="${teams}">
							<form:option value="${team}">${team.teamName}</form:option>
						</c:forEach> --%>
						<form:options items="${teams}" itemLabel="teamName" itemValue="teamId"/>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="firstName">First Name</label>
				<div class="col-sm-5">
					<input type="text" name="firstName" id="firstName" class="form-control" value="${player.firstName}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="lastName">Last Name</label>
				<div class="col-sm-5">
					<input type="text" name="lastName" id="lastName" class="form-control" value="${player.lastName}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="position">Possition</label>
				<div class="col-sm-5">
					<form:select path="position" class="form-control" id="sel1">
						<form:options items="${positions}" itemLabel="name" itemValue="name"/>
						<%-- <input type="text" name="position" id="position" class="form-control" value="${player.position}"/> --%>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="address">Address</label>
				<div class="col-sm-5">
					<input type="text" name="address" id="address" class="form-control" value="${player.address}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="phoneNo">Phone</label>
				<div class="col-sm-5">
					<input type="text" name="phoneNo" id="phoneNo" class="form-control" value="${player.phoneNo}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="email">Email</label>
				<div class="col-sm-5">
					<input type="text" name="email" id="email" class="form-control" value="${player.email}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="birthDate">Birthday</label>
				<div class="col-sm-5">
					<input type="text" name="birthDate" id="birthDate" class="form-control" value="${player.birthDate}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="uploadFile">Avatar</label>
				<div class="col-sm-5">
					<input type="file" name="file" class="form-control" id="file">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4"></div>
				<div class="col-sm-5">
					<button type="submit" class="btn btn-primary" value="Add" name="add">Add</button>
					<button type="reset" class="btn btn-primary" value="Reset" name="reset">reset</button>
				</div>
			</div>
	</form:form>
	<form:form action="findPlayer" method="GET" role="form" class="form-horizontal" >
		<div class="col-sm-4"></div>
		<div class="col-sm-2">
			<input type="text" class="form-control" name="id"/>
		</div>
		<button type="submit" class="btn btn-primary">
			<span class="glyphicon glyphicon-search">Search</span>
		</button>
	</form:form>
	<%-- <form:form class="form-wrapper" method="get" action="findPlayer">
	    <input type="text" id="search" placeholder="Search for CSS3, HTML5, jQuery ..." required>
	    <input type="submit" value="Find" id="submit">
	</form:form> --%>
	
	<c:choose>
		<c:when test="${!empty findResult}">
			<p>Result</p>
			<table class="data">
				<tr>
					<th>Id</th>
					<th>Team</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Position</th>
					<th>Address</th>
					<th>Phone no</th>
					<th>Email</th>
					<th>Birthday</th>
					<th>Action</th>
				</tr>
				<tr>
					<td><a href="?empId=${findResult.playerId}">${findResult.playerId}</a></td>
					<td>${findResult.team.teamName}</td>
					<td>${findResult.firstName}</td>
					<td>${findResult.lastName}</td>
					<td>${findResult.position}</td>
					<td>${findResult.address}</td>
					<td>${findResult.phoneNo}</td>
					<td>${findResult.email}</td>
					<td>${findResult.birthDate}</td>
					<td>
						<a href="delete/${findResult.playerId}">Delete</a>
						<a href="<c:url value="${contextPath}/update/${findResult.playerId}"/>">update</a>	
					</td>
				</tr>
			</table>
		</c:when>
	</c:choose>
	<form:form method="GET">
		<c:choose>
			<c:when test="${!empty listPlayer}">
				<table class="table table-bordered table-striped table-hover">
				<tr style="background-color: aqua;">
					<th>Id</th>
					<th>Team</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Position</th>
					<th>Address</th>
					<th>Phone no</th>
					<th>Email</th>
					<th>Birthday</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${listPlayer}" var="items">
					<tr>
						<td><a href="${items.playerId}">${items.playerId}</a></td>
						<td>${items.team.teamName}</td>
						<td>${items.firstName}</td>
						<td>${items.lastName}</td>
						<td>${items.position}</td>
						<td>${items.address}</td>
						<td>${items.phoneNo}</td>
						<td>${items.email}</td>
						<td>${items.birthDate }</td>
						<td>
							<a href="delete/${items.playerId}">Delete</a> |
							<a href="<c:url value="${contextPath}/update/${items.playerId}"/>">update</a>	
						</td>
					</tr>
				</c:forEach>
			</table>
			</c:when>
			<c:otherwise>
				empty!!!
			</c:otherwise>
		</c:choose>
	</form:form>
	</div>
</body>
</html>
