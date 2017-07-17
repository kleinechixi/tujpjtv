<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>myInfoView.jsp</title>



<script type="text/javascript">
function checkForm(){
	var val = 0;
    if(document.form1.password.value == "" || document.form1.passwordve.value == ""){
        alert("password is required.");
		val = 1;		
    } else if (document.form1.password.value !== document.form1.passwordve.value ){
        alert("password isn't match.");
		val = 1;		
    } else if (document.form1.email.value == "" ){
        alert("email is required.");
		val = 1;		
    }
	
    if (val == 1) {
        return false;    	
    } else {
    return true;
    }
}
</script>

</head>
<body>
<% String userids = (String)session.getAttribute("userids"); %>
<% String useridnum = (String)session.getAttribute("useridnum"); %>
<% String userid = (String)session.getAttribute("userid");%>
<% String password = (String)session.getAttribute("password");%>
<% String email = (String)session.getAttribute("email");%>
<% String firstname = (String)session.getAttribute("firstname");%>
<% String lastname = (String)session.getAttribute("lastname");%>
<% String sex = (String)session.getAttribute("sex");%>
<% String nationality = (String)session.getAttribute("nationality");%>
<% String birthday = (String)session.getAttribute("birthday");%>
<% String address = (String)session.getAttribute("address");%>
<% String phone = (String)session.getAttribute("phone");%>

<p><% out.println("Your registered information, " + userids + "(" + useridnum + ")" + ".(This is from session) "); %>
<p>
<p>----------------------------Main----------------------------- 
<p>Your registered infomation is below. You can change them except useridnum and userid. 
<p>
<form method="post" name="form1" action="ChangeMyInfoController.do">
<p><div>useridnum: <%out.print(useridnum);%></div>
<p><div>userid: <%out.print(userid);%></div>
<p><div>password: <input type="password" name="password"> password(verify): <input type="password" name="passwordve"></div>
<p><div>email: <input type="text" name="email" value="<%out.print(email);%>"></div>
<p><div>firstname: <input type="text" name="firstname" value="<%out.print(firstname);%>"></div>
<p><div>lastname: <input type="text" name="lastname" value="<%out.print(lastname);%>"></div>
<p><div>sex(<%out.print(sex);%> is set): <select name="sex"">
<option value="male">male</option> 
<option value="female">female</option>
</select></div>
<p><div>nationality: <input type="text" name="nationality" value="<%out.print(nationality);%>"></div>
<p><div>birthday: <input type="text" name="birthday" value="<%out.print(birthday);%>"></div>
<p><div>address: <input type="text" name="address" value="<%out.print(address);%>"></div>
<p><div>phone: <input type="text" name="phone" value="<%out.print(phone);%>"></div>
<p><input type="submit" value = "change" onclick="return checkForm();">
</form> 
<p>
<p>----------------------------Ref-----------------------------
<p><a href="/tujpjtv/myPageView.jsp">Go back to "myPageView.jsp". </a>
<p>
<form method="post" action="LogoutController.do">
<input type="submit" value = "Logout" > Logout.
</form>
<p>
</body>
</html>