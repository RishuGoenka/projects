<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%><html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome</title>
	<script type="text/javascript">
	</script>
	</head>
	<body>
		<center>
			<h4>Welcome ${ user.name }</h4>
			<form action="/Reetam_OnlineMovieTicketBooking/showMovies.do" onsubmit='return validate(this);'>
				<h4>Select a Date:</h4>
				<select name="date">
					<%Calendar cal=Calendar.getInstance();
						long time=cal.getTimeInMillis();
						String date;
					for(int index=0;index<14;index++){
						cal.setTimeInMillis(time);
						date=(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DATE)+"/"+cal.get(Calendar.YEAR);%>
						<option value="<%=date %>"><%=date %></option>
					<%  time=time+(24*3600*1000);
					}
						%>
				</select> 
				<br/><br/>
					<input type="submit" value="Show Movies"/>
			</form>
		</center>
	</body>
</html>