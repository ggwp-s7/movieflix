package com.movieflix.movies;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.movieflix.DAO.MoviesDAO;
import com.movieflix.bean.Movie;

public class MoviesFilter implements Filter{
	FilterConfig fc;
	@Override
	public void init(FilterConfig fc){
		this.fc=fc;
	}
	@Override
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)throws IOException,ServletException{
		HttpServletRequest req=(HttpServletRequest)request;
		ArrayList<Movie> movies=new ArrayList<>();
		if(req.getParameter("showtime").equals("nowShowing")){
			movies=MoviesDAO.getMovies(1, req.getServletContext());
		}
		else
			movies=MoviesDAO.getMovies(2, req.getServletContext());
		req.setAttribute("movieslist",movies);
		chain.doFilter(req, response);
	}
	@Override
	public void destroy()
	{
		
	}
}
