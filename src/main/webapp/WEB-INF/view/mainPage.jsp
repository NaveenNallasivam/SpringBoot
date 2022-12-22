<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="js/mainPage.js"></script>
<link href="css/mainPage.css" rel="stylesheet">
<body>
	<div class="row" id="header">
		<div class="col-sm-10">Welcome ${userBean.firstName }</div>
		<div class="col-sm-2">
			<a href="#" onclick="javascript:displayProfile(${userBean.userId})">Profile</a>
			<a href="#" onclick="javascript:editProfile()">EditProfile</a>
		</div>
	</div>
	<div id="profileDetailsDisplayArea"></div>
	<div id="editProfileArea" style="display: none">
		<table class="table table-bordered">
			<tr>
				<td><input type="hidden" id="uid" name="uid"
					value="${userBean.userId }"></input></td>
				<td><input path="password" type="hidden" id="password"
					name="password" value="${userBean.password} "></input></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input path="firstName" type="text" id="firstName"
					name="firstName" value="${userBean.firstName }"></input></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" path="lastName" id="lastName"
					name="lastName" value="${userBean.lastName }"></input></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input path="email" type="text" id="email" name="email"
					value="${userBean.email }"></input></td>
			</tr>
			<tr>
				<td><input type="submit" onclick="javascript:editProfilePost()"
					value="submit"></input></td>
			</tr>
		</table>
	</div>

</body>
</html>