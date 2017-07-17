<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buget Travel Maker loginView.jsp</title>
</head>
<body>
<p>----------------------------Main-----------------------------
<p>
Login info is wrong, try again.
<form method="post" action="LoginController.do">
	<!-- Go to Model　LoginModel.java-->
	<div>userid <input type="text" name="userid"></div>
	<div>password <input type="password" name="password"></div>
	<input type="submit" value="LOGIN"> 
	<input type="reset" value="RESET">
</form>
<p>
<p>----------------------------Ref-----------------------------
<p><a href="/tujpjtv/myPageView.jsp">Go back to "myPageView.jsp". </a>
<p>
<form method="post" action="LogoutController.do">
<input type="submit" value = "Logout" > Logout.
</body>
</html>