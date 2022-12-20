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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function displayProfile(uid){
	alert(uid);
	$.ajax({
		type:"GET",
		contentType: "application/json",
		url: "viewProfile?uid="+uid,
		dataType : 'json',
		success:function (response){
			$("#profileDetailsDisplayArea").html(JSON.stringify(response.firstName));
		}
	})
}
function editProfilePost(){
	var uid=$("#uid").val();
	var firstName=$("#firstName").val();
	var lastName=$("#lastName").val();
	var email=$("#email").val();
	var password=$("#password").val();
	var userData={"uid":uid,"firstName":firstName,"lastName":lastName,"email":email,"password":password};
	$.ajax({
		type:"post",
		data:JSON.stringify(userData),
		contentType: "application/json",
		url: "/editProfile",
		dataType : 'json',
		success:function(){
			alert("success");
		}
		
	});
}

function editProfile(){
	$("#editProfileArea").css("display","block");
}
</script>
<body>
	Welcome ${userBean.firstName }
	<a href="#" onclick="javascript:displayProfile(${userBean.userId})">Profile</a>
	<a href="#" onclick="javascript:editProfile()">EditProfile</a>
	<div id="profileDetailsDisplayArea"></div>
	<div id="editProfileArea" style="display: none">
	
		<input type="hidden" id="uid" name="uid" value="${userBean.userId }"></input>
		First Name:
		<input path="firstName" type="text" id="firstName"
			name="firstName" value="${userBean.firstName }"></input>
		Last Name:
		<input type="text" path="lastName" id="lastName" name="lastName"
			value="${userBean.lastName }"></input>
		Email:
		<input path="email" type="text" id="email" name="email"
			value="${userBean.email }"></input>
		<input path="password" type="hidden" id="password"
			name="password" value="${userBean.password} "></input>
		<input type="submit" onclick="javascript:editProfilePost()"
			value="submit"></input>

	</div>
</body>
</html>