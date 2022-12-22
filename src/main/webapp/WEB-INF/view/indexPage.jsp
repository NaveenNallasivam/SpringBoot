<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<link href="css/indexPage.css" type="text/css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="row" id="header">
		<div class="col-sm-10">${passwordWarning }${passwordreset }</div>
		<div class="col-sm-2">
			<a href="displaySignupForm">Signup</a>
		</div>
	</div>
	<div class="row" id="tableRow">
		<div class="col-sm-12">
			<table class="table table-bordered">
				<tbody>
					<form action="Login" method="post">
						<tr>
							<td>User Id</td>
							<td><input type="number" name="userId" /></td>

						</tr>
						<tr>
							<td>Password</td>
							<td><input type="password" name="password" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="submit" /></td>
							<td><a href="forgotPassword">Forgot Password</a></td>
						</tr>
					</form>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>