package com.movieflix.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;

import com.movieflix.bean.User;


public class LoginDAO {
	public static User validate(User user,ServletContext context){
		try{
			Connection conn =(Connection) context.getAttribute("conn");
			String query= "select * from users where email=? and password=?";
			PreparedStatement ps= conn.prepareStatement(query);
			ps.setString(1,user.getEmail());
			ps.setString(2,user.getPassword());
			
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				User userdata=new User();
				userdata.setEmail(rs.getString("email"));
				userdata.setPassword(rs.getString("password"));
				userdata.setUsername(rs.getString("name"));
				rs.close();
				return userdata;
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
		
	}

}
