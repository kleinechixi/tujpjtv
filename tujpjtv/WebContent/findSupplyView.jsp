<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="isLogin" scope="session" type="java.lang.Boolean"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>findSupplyView.jsp</title>

<script type="text/javascript">
function checkForm(){
	var val = 0;
    if (document.form1.origin.value == document.form1.destination.value ){
        alert("choices can't be the same.");
		val = 1;		
    }
    
    if (val == 1) {
    	return false;    	
    } else {
	    return true;
    }
}

function checkLogout(){
	if(window.confirm('sure?')){
		return true;
	}
	else{
		return false;
		window.alert('canceled.'); 
	}
}

</script>


</head>
<body>

<p>----------------------------Main-----------------------------
<p>
<% String userids = (String)session.getAttribute("userids"); %>
<% String useridnum = (String)session.getAttribute("useridnum"); %>
<% out.println("ferry avairable to enjoy Ogasawara!");  %>
<p>
<form method="post" name="form1" action="FindSupplyController.do">

<p>
	<div>origin
		<select name=origin list size="1">
			<option value="Tokyo">Tokyo</option>
			<option value="Ogasawara">Ogasawara</option>
		</select>
	</div>
<p>	
<p>	
	<div>destination
		<select name=destination list size="1">
			<option value="Tokyo">Tokyo</option>
			<option value="Ogasawara">Ogasawara</option>
		</select>
	</div>
<p>
	<input type="submit" value="submit" onclick="return checkForm();">
</form>
<p>
<p>
<p>
<p>
<p>----------------------------Ref-----------------------------
<p><a href="/tujpjtv/myPageView.jsp">Go back to "myPageView.jsp". </a>
<p>
<form method="post" action="LogoutController.do">
<input type="submit" value = "Logout" onclick="return checkLogout();"> Logout.
</body>
</html>