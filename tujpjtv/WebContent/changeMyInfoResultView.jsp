<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="isLogin" scope="session" type="java.lang.Boolean"/>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>changeMyInfoResultView.jsp</title>


<script type="text/javascript">

function checkLogout(){
	if(window.confirm('sure?')){
		return true;
	}
	else{
		return false;
		window.alert('canceled.'); 
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
<p>
Change Succeeded. 
<p>
<p>----------------------------Ref-----------------------------
<p><a href="/tujpjtv/myPageView.jsp">Go back to "myPageView.jsp". </a>
<p>
<form method="post" action="LogoutController.do">
<input type="submit" value = "Logout" onclick="return checkLogout();"> Logout.
</form>
</body>
</html>