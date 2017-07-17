<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignupView.jsp</title>

<script type="text/javascript">
function checkForm(){
	var val = 0;
    if(document.form1.userid.value == "" ){
        alert("userid is required.");
		val = 1;
    } else if(document.form1.password.value == "" || document.form1.passwordve.value == ""){
        alert("password is required.");
		val = 1;		
    } else if (document.form1.password.value !== document.form1.passwordve.value ){
        alert("password isn't match.");
		val = 1;		
    } else if (document.form1.email.value == "" ){
        alert("email is required.");
		val = 1;
    } else if (document.form1.sex.options[document.form1.sex.selectedIndex].value == "") {
        alert("sex is not choosen.");
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
<form method="post" name="form1" action="SignupController.do">
	
	Register your infomation.
	<p><div>userid: <input type="text" name="userid"> *required</div>
	<p><div>password: <input type="password" name="password"> *required</div>
	<p><div>password(verify): <input type="password" name="passwordve"> *required</div>
	<p><div>email: <input type="text" name="email"></div>
	<p><div>firstname: <input type="text" name="firstname"></div>
	<p><div>lastname: <input type="text" name="lastname"></div>
	<p>sex: <select name="sex"">
		<option value="" selected></option>
		<option value="male">male</option>
		<option value="female">female</option>
	</select>
	<p><div>nationality: <input type="nationality" name="nationality"></div>
	<p><div>birthday: <input type="birthday" name="birthday"></div>
	<p><div>address: <input type="text" name="address"></div>
	<p><div>phone: <input type="text" name="phone"></div>
	<p><input type="submit" value="sign-up" onclick="return checkForm();"> 
	<p><input type="reset" value="reset">

</form>
</body>
</html>