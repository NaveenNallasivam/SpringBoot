/**
 * 
 */
 function displayProfile(uid){
	 var content = "<table>"
	$.ajax({
		type:"GET",
		contentType: "application/json",
		url: "viewProfile?uid="+uid,
		dataType : 'json',
		success:function (response){
			content+="<tr><td>First Name:</td><td>"+JSON.stringify(response.firstName)+"</td></tr>";
			content+="<tr><td>Last Name:</td><td>"+JSON.stringify(response.lastName)+"</td></tr>";
			content+="<tr><td>Email Name:</td><td>"+JSON.stringify(response.email)+"</td></tr>";
			content+='</table>';
			$("#profileDetailsDisplayArea").append(content);
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