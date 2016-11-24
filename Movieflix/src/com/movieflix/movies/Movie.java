package com.movieflix.movies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieflix.DAO.MovieDAO;

public class Movie extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		response.setContentType("text/html");
		com.movieflix.bean.Movie movie=MovieDAO.getMovie(Integer.parseInt((request.getParameter("movieId"))), getServletContext());
		request.setAttribute("movie",movie);
		request.getRequestDispatcher("/movieJsp.jsp").forward(request, response);
	}
}
