<%@page import="model.SharedModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>findOrderResultView.jsp</title>
</head>
<body>
<jsp:useBean id="isLogin" scope="session" type="java.lang.Boolean"/>
<% String userids = (String)session.getAttribute("userids"); %>
<% String useridnum = (String)session.getAttribute("useridnum"); %>
<% if(isLogin != true) { 
	out.println("Booked info below!"); 
} else {
out.println("Booked info below, " + userids + "(" + useridnum + ")" + ".(This is from session) ");
} %>
<p>
<% ArrayList<SharedModel> list = new ArrayList<SharedModel>(); %>
<% list = (ArrayList<SharedModel>)request.getAttribute("list"); %>
<p>
<p>----------------------------Main-----------------------------

<%-- Check the number --%>
<% if (list.size() >= 1 ) { %>

<%-- Display All the list --%>
<% for(int i=0 ; i < list.size(); i++){
	int j = i + 1;
	out.println("<p>No. " + j + " ----------------------------------------------------<p>");
	String orderid = list.get(i).getOrderid();
	String shipnum = list.get(i).getShipnum();
	String type = list.get(i).getType();
	String date = list.get(i).getDate();
	String origin = list.get(i).getOrigin();
	String destination = list.get(i).getDestination();
	String numofseats = list.get(i).getNumofseats();
%>
<p><form method="post" action="CancelOrderController.do">
<input type="radio" name="orderid" value="<%out.print(orderid);%>">
<%out.print(orderid);%>
<input type="submit" value = "cancel this booking" >
</form>
<p><%out.print("type: " + type);%>
<p><%out.print("date: " + date);%>
<p><%out.print("origin: " + origin);%>
<p><%out.print("destination: " + destination);%>
<p><form method="post" action="ChangeOrderController.do">
<input type="text" name="numofseats" value="<%out.print(numofseats);%>"> passangers
<input type="submit" value = "change the number of seats" >
</form>








<p>
<p>------------------------------------------------------
<% } %>
<p>
<% } else { %>
<p><% out.println("no match found."); %>
<% } %>
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