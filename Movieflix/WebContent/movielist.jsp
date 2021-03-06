<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/movielist.css" type="text/css" rel="stylesheet"/>
<title>Movies</title>
</head>
<body>
	<c:forEach var="movie" items="${movieslist}">
		<div class="movieContainer">
			<div class="poster">
				<img class="poster" src="<%=request.getContextPath()%>/images/${movie.image}">
				<a class="book" href="book?movieId=${movie.movieId}"><button>BOOK NOW</button></a>
			</div>	
			<h3><a href="movie?movieId=${movie.movieId}">${movie.name}</a></h3>
			
			<div class="subElement">
				<div class="subHeading"><b>Synopsis:</b></div>
				<blockquote>${movie.synopsis}</blockquote>			
			</div>	
			<div class="content">
				<div class="subHeading"><b>Cast:</b></div>
				<blockquote>${movie.casts}</blockquote>			
			</div>	
			<div class="content">
				<div class="subHeading"><b>Directors:</b></div>
				<blockquote>${movie.directors}</blockquote>			
			</div>	
			<div class="content">
				<div class="subHeading"><b>Producers:</b></div>
				<blockquote>${movie.producers}</blockquote>			
			</div>	
			<div class="content">
				<div class="subHeading"><b>Release Date:</b></div>
				<blockquote>${movie.releaseDate}</blockquote>			
			</div>
				
		</div>
		
	</c:forEach>
	
</body>
</html>