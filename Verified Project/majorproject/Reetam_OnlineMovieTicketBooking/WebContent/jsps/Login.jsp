<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Log In Page</title>
	</head>
	<body>
	
		<center><h1>Login</h1></center>
		<form action="/Reetam_OnlineMovieTicketBooking/chechCredentials.do" method="post">
			<center>
				<table>
					<tr>
						<td>Email:</td>
						<td><input type="text" name="email" /> </td>
					</tr>
				
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password"/></td>
					</tr>
	
					<tr>
						<td><input type="submit" value="submit"/></td>
					</tr>
				</table>
				<%if(request.getAttribute("error")!=null){ %>	
							<label style="color: RED">${error}</label>
				<%} %>
			</center>
		</form>
	</body>
</html>