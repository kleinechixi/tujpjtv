<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MypageView.jsp</title>
</head>
<body>
<p>----------------------------Main-----------------------------
<% String userids = (String)session.getAttribute("userids"); %>
<% String useridnum = (String)session.getAttribute("useridnum"); %>
<p><% out.println("Welcome, " + userids + "(" + useridnum + ")" + ".(This is from session) "); %>

<p>Go to your menu.
<p>

<p><a href="/tujpjtv/findSupplyView.jsp">1. Go to "findSupplyView.jsp" to MAKE A BOOKING. </a>
<p>	
	<form method="post" action="FindOrderController.do">
    2. Display your BOOKING info. <input type="submit" value="Go 2 Booking info">
    </form>
<p>
<form method="post" action="MyInfoController.do">
	3. Display your USER info. <input type="submit" value="Go 2 Your Info">
</form>
<p>  
<p>
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