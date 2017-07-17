<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>findSupplyView.jsp</title>
</head>
<body>

<p>----------------------------Main-----------------------------
<p>
<% String userids = (String)session.getAttribute("userids"); %>
<% String useridnum = (String)session.getAttribute("useridnum"); %>
<% out.println("ferry avairable to enjoy Ogasawara!");  %>
<p>
<form method="post" action="FindSupplyController.do">

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
	<input type="submit" value="submit">
</form>
<p>
<p>
<p>
<p>
<p>----------------------------Ref-----------------------------
<p><a href="/tujpjtv/myPageView.jsp">Go back to "myPageView.jsp". </a>
<p>
<form method="post" action="LogoutController.do">
<input type="submit" value = "Logout" > Logout.
</body>
</html>