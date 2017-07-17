<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginView.jsp</title>
</head>

<body>
<p>----------------------------Main-----------------------------
<p>
To login your Page, enter userid and password.

<form method="post" action="LoginController.do">

	<!-- Go to Model　Login.java-->
	<div>userid <input type="text" name="userid"></div>
	<div>password <input type="password" name="password"></div>
	<input type="submit" value="LOGIN"> 
	<input type="reset" value="RESET">
<p>
<p>
<a href="/tujpjtv/signupView.jsp"> First time? "signupView.jsp" to resister. </a>
</form>
</body>
</html>