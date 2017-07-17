<%@page import="model.SharedModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="isLogin" scope="session" type="java.lang.Boolean"/>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>findOrderResultView.jsp</title>

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

</script>

</head>
<body>

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
	String orderid = list.get(i).getOrderid();
	String shipnum = list.get(i).getShipnum();
	String type = list.get(i).getType();
	String date = list.get(i).getDate();
	String origin = list.get(i).getOrigin();
	String destination = list.get(i).getDestination();
	String numofseats = list.get(i).getNumofseats();
%>
<p>
<% out.println("-----------<p>"); %>
<% out.println("No. " + j); %>
<%out.print("orderid: " + orderid);%> <%out.print(", type: " + type);%> <%out.print(", date: " + date);%> <%out.print(", origin: " + origin);%> <%out.print("-> destination: " + destination);%> <%out.print(", numofseats: " + numofseats);%>
<p>
<form method="post" name="form1" action="ChangeOrderController.do">
	<input type="submit" value = "change # of seats from <%out.print(numofseats);%> to ..." >
	<select name="numofseats">
		<option value="1"> 1 person </option>
		<option value="2"> 2 people </option>
		<option value="3"> 3 people </option>  
		<option value="4"> 4 people </option>
		<option value="5"> 5 people </option> 
	</select>
	<input type="hidden" name="orderid" value="<%out.print(orderid);%>">
</form>
<p>
<form method="post" name="form2" action="CancelOrderController.do">
	<input type="hidden" name="orderid" value="<%out.print(orderid);%>">
	<input type="submit" value = "cancel this booking" >
</form>

<% } %>
<% } else { %>
<p><% out.println("no match found."); %>
<% } %>
<p>
<p>
<p>
<p>----------------------------Ref-----------------------------
<p>
<p><a href="/tujpjtv/myPageView.jsp">Go back to "myPageView.jsp". </a>
<p>
<form method="post" action="LogoutController.do">
<input type="submit" value = "Logout" onclick="return checkLogout();"> Logout.
</body>
</html>