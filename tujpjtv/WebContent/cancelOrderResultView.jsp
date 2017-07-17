<%@page import="model.SupplyModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>bookFerryResultView.jsp</title>
</head>
<body>
<jsp:useBean id="isLogin" scope="session" type="java.lang.Boolean"/>
<% String userids = (String)session.getAttribute("userids"); %>
<% String useridnum = (String)session.getAttribute("useridnum"); %>
<% out.println("Cancel succeeded. " + userids + "(" + useridnum + ")" + ".(This is from session) "); %>
<p>
<p>
<p>----------------------------Ref-----------------------------
<p>
<p><a href="/tujpjtv/myPageView.jsp">Go back to "myPageView.jsp". </a>
<p>
<form method="post" action="LogoutController.do">
<input type="submit" value = "Logout" > Logout.
</body>
</html>