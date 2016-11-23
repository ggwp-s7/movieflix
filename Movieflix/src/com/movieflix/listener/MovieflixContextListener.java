package com.movieflix.listener;

import java.sql.Connection;
import java.sql.DriverManager;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MovieflixContextListener implements ServletContextListener{
	private static Connection conn;
	public Connection getConn() {
		return conn;
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		try{
		conn.close();
		}
		catch(Exception ex)
		{
		
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		String url,name,password,driver;
		ServletContext context= arg0.getServletContext();
		url= context.getInitParameter("URL");
		name=context.getInitParameter("USERNAME");
		password=context.getInitParameter("PASSWORD");
		driver=context.getInitParameter("DRIVER");
		try{
			Class.forName(driver);
			conn=DriverManager.getConnection(url, name, password);
			if(conn!=null)
			{	
				System.out.println("connection successful");
				context.setAttribute("conn",conn);
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
