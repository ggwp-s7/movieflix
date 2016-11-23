<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.movieflix.bean.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	
	<title>Movie Flex-Home</title>
	<link rel="stylesheet" type="text/css" href="css/home.css"> 
	<link rel="stylesheet" type="text/css" href="css/login.css"> 
</head>
<body>
	<!-- Navigation Bar-->
	<ul id="navbar">
		
		<li><a href="movies">Movies</a></li>
		<li><a href="aboutus">About Us</a></li>
		<li><a href="contactus">Contact Us</a></li>
		<li class="login"><a id="login" href="#">Login</a></li>
		<li class="login"><a id="signup" href="signup.html">Sign Up</a></li>
		<li class="login"><a><%=((User)request.getAttribute("user")).getUsername()%></a></li>
	</ul>
	<!---------------------------------------------------------------------->
	<!------------------------------Mid Body-------------------------------->
	<p align="center" class="heading">Now Showing</p>
	<div class="movieList">
		<a class="viewall" href="movielist.jsp?showtime=nowshowing">Veiw All</a>
	</div>
	<p align="center" class="heading">Coming Soon</p>
	<div class="movieList">
		<a class="viewall" href="comingsoon">Veiw All</a>
	</div>
	
</body>
</html>