<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${passwordreset }
<form:form action="forgotPassword" modelAttribute="forgotPassword">
Enter User Id:<input type="number" name="userid" id="userid"/>
Enter New Password:<input type="password" name="newPassword" id="newPassword"/>
Confirm New Password:<input type="password" name="confirmNewPassword" id="confirmNewPassword"/>
<input type="submit" value="submit"/>
</form:form>
</body>
</html>