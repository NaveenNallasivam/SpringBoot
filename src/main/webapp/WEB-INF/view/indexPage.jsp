<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${passwordWarning }
${passwordreset }
<form action="Login" method="post">
User Id<input type="number" name="userId"/>
Password<input type="password" name="password" />
<input type="submit" value="submit"/>
<a href="displaySignupForm">Signup</a>
<a href="forgotPassword">Forgot Password</a>
</form>
</body>
</html>