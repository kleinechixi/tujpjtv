<%@page import="model.SupplyModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="isLogin" scope="session" type="java.lang.Boolean"/>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>findSupplyResultView.jsp</title>

<script type="text/javascript">
function checkForm(){
	var val = false;
	for(var i=0; i<document.form1.shipnum.length;i++){
	    if (document.form1.shipnum[i].checked){
		val = true;
	    }
    }
    
    if (!val) {
        alert("select.");
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
<% String userids = (String)session.getAttribute("userids"); %>
<% String useridnum = (String)session.getAttribute("useridnum"); %>
<p><% out.println("Check out your choice below, " + userids + "(" + useridnum + ")" + ".(This is from session) "); %>
<p>
<% ArrayList<SupplyModel> list = new ArrayList<SupplyModel>(); %>
<% list = (ArrayList<SupplyModel>)request.getAttribute("list"); %>

<p>----------------------------Main-----------------------------
<p>
<% if (list.size() >= 1 ) { %>
<%-- Display All the list --%>
<% for(int i=0; i < list.size(); i++){ 
	String shipnum = list.get(i).getShipnum();
	String type = list.get(i).getType();
	String date = list.get(i).getDate();
	String origin = list.get(i).getOrigin();
	String destination = list.get(i).getDestination();
	String availseats = list.get(i).getAvailseats();
%>
<form method="post" name="form1" action="OrderController.do">
<input type="radio" name="shipnum" value="<%out.print(shipnum);%>">					
<%out.print(shipnum +" (" + type + ") "+ date + " From:" + origin + " ---> To:" + destination + " Max: " + availseats);%>
<p>
<% } %>
<p>
<p>
<select name="numofseats">
	<option value="1"> 1 person </option>
	<option value="2" selected> 2 people </option>
	<option value="3"> 3 people </option>  
	<option value="4"> 4 people </option>
	<option value="5"> 5 people </option> 
</select>					
<input type="submit" value = "book this" onclick="return checkForm();" >
<input type="reset" value="reset">
</form> 							
<p>
<% } else { %>
<p><% out.println("no match found."); %>
<% } %>
<p>
<p>
<p>----------------------------Ref-----------------------------
<p>
<p><a href="/tujpjtv/findSupplyView.jsp">Go back to "findSupplyView.jsp". </a>
<p>
<p><a href="/tujpjtv/myPageView.jsp">Go back to "myPageView.jsp". </a>
<p>
<form method="post" action="LogoutController.do">
<input type="submit" value = "Logout" onclick="return checkLogout();"> Logout.
</body>
</html>