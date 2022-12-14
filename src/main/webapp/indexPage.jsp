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
<form action="Login" method="post">
User Id<input type="text" name="userId"/>
Password<input type="password" name="password" />
<input type="submit" value="submit"/>
<a href="displaySignupForm">Signup</a>
</form>
</body>
</html>