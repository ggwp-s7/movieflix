package com.movieflix.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieflix.DAO.LoginDAO;
import com.movieflix.bean.User;

public class LoginFilter implements Filter {

	FilterConfig fc;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		User user=new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		User userResult=LoginDAO.validate(user, req.getServletContext());
		if(userResult!=null){
			HttpSession session= request.getSession();
			user.setUsername(userResult.getUsername());
			request.setAttribute("user", user);
		}
		chain.doFilter(request,response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.fc = config;
		
	}
	

}
